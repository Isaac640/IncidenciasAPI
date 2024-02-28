package com.example.demo.excel;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class TiempoIncidenciaExcel extends AbstractXlsView {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @GetMapping("/export/tiempoIncidencia")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "SELECT num AS incident_id, " +
                "tipo AS incident_type, " +
                "descripcion AS incident_description, " +
                "fecha_creacion AS creation_date, " +
                "fecha_cierre AS resolution_date " +
                "FROM incidencias";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            Sheet sheet = workbook.createSheet("Duracion incidencia");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID incidencia");
            headerRow.createCell(1).setCellValue("Tipo incidencia");
            headerRow.createCell(2).setCellValue("Descripcion incidencia");
            headerRow.createCell(3).setCellValue("Fecha creacion");
            headerRow.createCell(4).setCellValue("Fecha cierre");
            headerRow.createCell(5).setCellValue("Duracion en minutos");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            int rowNum = 1;
            for (Map<String, Object> row : rows) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(row.get("incident_id").toString());
                dataRow.createCell(1).setCellValue((String) row.get("incident_type"));
                dataRow.createCell(2).setCellValue((String) row.get("incident_description"));

                LocalDateTime creationDate = LocalDateTime.parse((String) row.get("creation_date"), formatter);
                LocalDateTime resolutionDate = row.get("resolution_date") != null ? LocalDateTime.parse((String) row.get("resolution_date"), formatter) : LocalDateTime.now();

                long minutesSpent = Duration.between(creationDate, resolutionDate).toMinutes();
                dataRow.createCell(3).setCellValue(creationDate.format(formatter));
                dataRow.createCell(4).setCellValue(row.get("resolution_date") != null ? resolutionDate.format(formatter) : "Not resolved yet");
                dataRow.createCell(5).setCellValue(minutesSpent);
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=Tiempo_incidencia.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

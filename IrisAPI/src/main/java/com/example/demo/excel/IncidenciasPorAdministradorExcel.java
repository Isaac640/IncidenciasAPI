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
import java.sql.Connection;
import java.util.List;
import java.util.Map;

@RestController
public class IncidenciasPorAdministradorExcel extends AbstractXlsView {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @GetMapping("/export/IncidenciasUser")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "SELECT p.nombre AS administrator, \n" +
                "                            i.num AS incident_id, \n" +
                "                            i.tipo AS incident_type, \n" +
                "                            i.descripcion AS incident_description, \n" +
                "                            i.fecha_creacion AS incident_creation_date, \n" +
                "                            i.fecha_cierre AS incident_resolution_date \n" +
                "                       FROM incidencias i \n" +
                "                       JOIN personal p ON i.responsable_id = p.id \n" +
                "                       WHERE i.estado = 'resuelta' \n" +
                "                       ORDER BY administrator";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Resolved Incidents");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Administrador");
            headerRow.createCell(1).setCellValue("ID incidencia");
            headerRow.createCell(2).setCellValue("Tipo incidencia");
            headerRow.createCell(3).setCellValue("Descripcion incidencia");
            headerRow.createCell(4).setCellValue("Fecha creacion incidencia");
            headerRow.createCell(5).setCellValue("Fecha cierre incidencia");

            int rowNum = 1;
            for (Map<String, Object> row : rows) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(row.get("administrator").toString());
                dataRow.createCell(1).setCellValue(row.get("incident_id").toString());
                dataRow.createCell(2).setCellValue((String) row.get("incident_type"));
                dataRow.createCell(3).setCellValue((String) row.get("incident_description"));
                dataRow.createCell(4).setCellValue(row.get("incident_creation_date").toString());
                dataRow.createCell(5).setCellValue(row.get("incident_resolution_date").toString());
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=IncidenciasResueltasAdministrador.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

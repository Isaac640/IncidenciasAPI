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
import java.util.List;
import java.util.Map;

@RestController
public class TiempoPorTipoIncidenciaExcel extends AbstractXlsView {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @GetMapping("/export/tiempoTipoIncidencia")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "SELECT tipo AS incident_type, " +
                "AVG(TIMESTAMPDIFF(MINUTE, fecha_creacion, fecha_cierre)) AS avg_resolution_time " +
                "FROM incidencias " +
                "WHERE estado = 'resuelta' " +
                "GROUP BY tipo";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Incident Resolution Time");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Incident Type");
            headerRow.createCell(1).setCellValue("Average Resolution Time (minutes)");

            int rowNum = 1;
            for (Map<String, Object> row : rows) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue((String) row.get("incident_type"));
                Double avgResolutionTime = (Double) row.get("avg_resolution_time");
                dataRow.createCell(1).setCellValue(avgResolutionTime != null ? avgResolutionTime : 0);
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=incident_resolution_time.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

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
public class IncidenciasACadaAdministradorExcel extends AbstractXlsView {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @GetMapping("/export/incidenciaACadaAdmin")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sql = "SELECT p.nombre AS admin_name, " +
                "i.num AS incident_id, " +
                "i.tipo AS incident_type, " +
                "i.descripcion AS incident_description, " +
                "i.fecha_creacion AS creation_date, " +
                "i.fecha_cierre AS resolution_date " +
                "FROM incidencias i " +
                "JOIN personal p ON i.responsable_id = p.id";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Incidencias por Admin");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Nombre Admin");
            headerRow.createCell(1).setCellValue("ID incidencia");
            headerRow.createCell(2).setCellValue("Tipo incidencia");
            headerRow.createCell(3).setCellValue("Descripcion incidencia");
            headerRow.createCell(4).setCellValue("Creacion Incidencia");
            headerRow.createCell(5).setCellValue("Resolucion Incidencia");

            int rowNum = 1;
            for (Map<String, Object> row : rows) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue((String) row.get("admin_name"));
                dataRow.createCell(1).setCellValue(row.get("incident_id").toString());
                dataRow.createCell(2).setCellValue((String) row.get("incident_type"));
                dataRow.createCell(3).setCellValue((String) row.get("incident_description"));
                dataRow.createCell(4).setCellValue((String) row.get("creation_date"));
                dataRow.createCell(5).setCellValue((String) row.get("resolution_date"));
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=incidents_assigned_to_admin.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

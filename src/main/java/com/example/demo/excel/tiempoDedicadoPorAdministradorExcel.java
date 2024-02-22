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
public class tiempoDedicadoPorAdministradorExcel extends AbstractXlsView {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @GetMapping("/export/tiempoPorAdministrador")
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String sql = "SELECT p.nombre AS admin_name, " +
                "SUM(TIMESTAMPDIFF(MINUTE, i.fecha_creacion, i.fecha_cierre)) AS total_time_spent " +
                "FROM incidencias i " +
                "JOIN personal p ON i.responsable_id = p.id " +
                "WHERE i.estado = 'resuelta' " +
                "GROUP BY admin_name";

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Tiempo Administrador");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Nombre Admin");
            headerRow.createCell(1).setCellValue("Total minutos");

            int rowNum = 1;
            for (Map<String, Object> row : rows) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue((String) row.get("admin_name"));
                Long totalTimeSpent = (Long) row.get("total_time_spent");
                dataRow.createCell(1).setCellValue(totalTimeSpent != null ? totalTimeSpent : 0);
            }

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=TiempoAdministrador.xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

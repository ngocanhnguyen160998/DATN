package com.util;

import com.dto.OrderDetailDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportExcel {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<OrderDetailDTO> lstOrderDetailDTO;

    public ExportExcel(List<OrderDetailDTO> lstOrderDetailDTO) {
        this.lstOrderDetailDTO = lstOrderDetailDTO;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("List Order");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Mã ĐH", style);
        createCell(row, 1, "Tài Khoản", style);
        createCell(row, 2, "Họ Tên", style);
        createCell(row, 3, "SĐT", style);
        createCell(row, 4, "Email", style);
        createCell(row, 5, "Tỉnh/TP", style);
        createCell(row, 6, "Quận/Huyện", style);
        createCell(row, 7, "Phường/Xã", style);
        createCell(row, 8, "Ghi Chú", style);
        createCell(row, 9, "Ngày Lập", style);
        createCell(row, 10, "Thành Tiền", style);
        createCell(row, 11, "Tình Trạng", style);
        createCell(row, 12, "Phương Thức Thanh Toán", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
        sheet.autoSizeColumn(columnCount);
    }

    private void writeDataLines() {
        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String status = "";
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (OrderDetailDTO orderDetailDTO : lstOrderDetailDTO) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, orderDetailDTO.getId(), style);
            createCell(row, columnCount++, orderDetailDTO.getUserName(), style);
            createCell(row, columnCount++, orderDetailDTO.getFirstName() + " " + orderDetailDTO.getLastName(), style);
            createCell(row, columnCount++, orderDetailDTO.getPhone(), style);
            createCell(row, columnCount++, orderDetailDTO.getEmail(), style);
            createCell(row, columnCount++, orderDetailDTO.getProvince(), style);
            createCell(row, columnCount++, orderDetailDTO.getDistrict(), style);
            createCell(row, columnCount++, orderDetailDTO.getCommune(), style);
            createCell(row, columnCount++, orderDetailDTO.getSpecialNotes(), style);
            String modefinedDate = dateFormatter.format(orderDetailDTO.getModefinedDate());
            createCell(row, columnCount++, modefinedDate, style);
            createCell(row, columnCount++, orderDetailDTO.getTotalPrice(), style);
            if(orderDetailDTO.getStatus() == 0) {
                status = "Chưa xác nhận";
            } else if(orderDetailDTO.getStatus() == 1) {
                status = "Đã xác nhận";
            } else if(orderDetailDTO.getStatus() == 2) {
                status = "Đã hủy";
            } else if(orderDetailDTO.getStatus() == 3) {
                status = "Hoàn thành";
            }
            createCell(row, columnCount++, status, style);
            createCell(row, columnCount++, orderDetailDTO.getPaymentMethod(), style);

        }
    }

    public void export(HttpServletResponse response) {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

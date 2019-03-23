package com.aust.first.util;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtil {

    public static final String CELL_COLOR_BLUE = "blue";
    public static final String CELL_COLOR_ORANGE = "orange";
    public static final String CELL_COLOR_GREY = "grey";

    // 定制日期格式
    private static String DATE_FORMAT = "m/d/yy"; // "m/d/yy h:mm"
    // 定制浮点数格式
    private static String NUMBER_FORMAT = " #,##0.00 ";

    private String xlsFileName;
    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private HSSFRow row;

    /**
     * 初始化Excel
     * 
     * @param fileName
     *            导出文件名
     */
    public ExcelUtil(String fileName) {
        this.xlsFileName = fileName;
        this.workbook = new HSSFWorkbook();
        this.sheet = workbook.createSheet();
    }

    /**
     * 初始化Excel
     * 
     * @param fileName
     *            导出文件名
     * @param sheetName
     *            第一个sheet的名字
     */
    public ExcelUtil(String fileName, String sheetName) {
        this.xlsFileName = fileName;
        this.workbook = new HSSFWorkbook();
        if (StringUtil.isNullStr(sheetName)) {
            this.sheet = workbook.createSheet();
        } else {
            this.sheet = workbook.createSheet(sheetName);
        }
    }

    public void createSheet(String sheetName) {
        if (StringUtil.isNullStr(sheetName)) {
            this.sheet = workbook.createSheet();
        } else {
            this.sheet = workbook.createSheet(sheetName);
        }
    }

    /**
     * 导出Excel文件
     * 
     * @throws XLSException
     */
    public void exportXLS() throws Exception {
        try {
            FileOutputStream fOut = new FileOutputStream(xlsFileName);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 设置单元格(指定颜色)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     * @param color
     *            形如HSSFColor.LIGHT_ORANGE.index
     */
    public void setCell(int index, String value) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellValue(value);
    }

    /**
     * 设置单元格(指定颜色，暂时只有)(少用 CellStyle太多数据就可能有问题，尽量用String的)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     * @param color
     *            "blue","orange","grey";
     */
    public void setCell(int index, String value, String color) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellStyle(this.createCellStyle(color));
        cell.setCellValue(value);
    }

    /**
     * 设置单元格(指定颜色)(少用 CellStyle太多数据就可能有问题，尽量用String的)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     * @param color
     *            形如HSSFColor.LIGHT_ORANGE.index
     */
    public void setCell(int index, String value, short color) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellStyle(this.createCellStyle(color, HSSFCellStyle.ALIGN_CENTER, HSSFCellStyle.VERTICAL_CENTER, null));
        cell.setCellValue(value);
    }

    /**
     * 设置单元格(时间类型)(少用 CellStyle太多数据就可能有问题，可自己转成String类型的时间)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     */
    public void setCell(int index, Calendar value) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellValue(value.getTime());
        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
        cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
    }

    /**
     * 设置单元格(时间类型)(少用 CellStyle太多数据就可能有问题，可自己转成String类型的时间)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     */
    public void setCell(int index, Date value) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellValue(value);
        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
        cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
    }

    /**
     * 设置单元格(数字类型)
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     */
    public void setCell(int index, int value) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(value);
    }

    /**
     * 设置单元格(浮点类型(*.00))
     * 
     * @param index
     *            列号
     * @param value
     *            单元格填充值
     */
    public void setCell(int index, double value) {
        HSSFCell cell = this.row.createCell(index);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(value);
        HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
        HSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // 设置cell样式为定制的浮点数格式
        cell.setCellStyle(cellStyle); // 设置该cell浮点数的显示格式
    }

    /**
     * 功能：创建CellStyle样式
     * 
     * @return CellStyle
     */
    public HSSFCellStyle createCellStyle(String color) {
        HSSFCellStyle style = this.workbook.createCellStyle();
        if (color.equals(CELL_COLOR_BLUE))
            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        else if (color.equals(CELL_COLOR_ORANGE))
            style.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
        else if (color.equals(CELL_COLOR_GREY))
            style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        else
            style.setFillForegroundColor(HSSFColor.WHITE.index);

        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        return style;
    }

    /**
     * 创建指定样式
     * 
     * @param color
     *            形如：HSSFColor.LIGHT_ORANGE.index
     * @param align
     *            形如 :HSSFCellStyle.ALIGN_CENTER
     * @param verticalAlign
     *            形如：HSSFCellStyle.VERTICAL_BOTTOM
     * @param font
     *            调用 createFont()
     * @return
     */
    public HSSFCellStyle createCellStyle(short color, short align, short verticalAlign, HSSFFont font) {
        HSSFCellStyle style = this.workbook.createCellStyle();
        style.setFillForegroundColor(color);
        style.setAlignment(align);
        style.setVerticalAlignment(verticalAlign);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        if (font != null) {
            style.setFont(font);
        }
        return style;
    }

    /**
     * 功能：创建字体
     * 
     * @param size
     *            字体大小
     * @return Font
     */
    public HSSFFont createFont(short size) {
        HSSFFont font = this.workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints(size);
        return font;
    }

    /**
     * 创建字体 (大小、颜色)
     * 
     * @param size
     *            字体大小
     * @param boldWeight
     *            形如:HSSFFont.BOLDWEIGHT_BOLD以及HSSFFont.BOLDWEIGHT_NORMAL
     * @param color
     *            形如:HSSFColor.LIGHT_ORANGE.index
     * @return
     */
    public HSSFFont createFont(short size, short boldWeight, short color) {
        HSSFFont font = this.workbook.createFont();
        font.setBoldweight(boldWeight);
        font.setColor(color);
        font.setFontHeightInPoints(size);
        return font;
    }

    /**
     * 功能：合并单元格
     * 
     * @param sheet
     *            HSSFSheet
     * @param firstRow
     *            int
     * @param lastRow
     *            int
     * @param firstColumn
     *            int
     * @param lastColumn
     *            int
     * @return int 合并区域号码
     */
    public static int mergeCell(HSSFSheet sheet, int firstRow, int lastRow, int firstColumn, int lastColumn) {
        return sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn));
    }

    /**
     * 功能：合并单元格
     * 
     * @param sheet
     *            HSSFSheet
     * @param firstRow
     *            int
     * @param lastRow
     *            int
     * @param firstColumn
     *            int
     * @param lastColumn
     *            int
     * @return int 合并区域号码
     */
    public int mergeCell(int firstRow, int lastRow, int firstColumn, int lastColumn) {
        return this.sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn));
    }

    /**
     * 新增指定样式的列数据
     * 
     * @param index
     * @param value
     * @param style
     */
    public void mergeCellStyle(int index, String value, HSSFCellStyle style) {
        HSSFCell cell = this.row.createCell(index);
        if (style != null) {
            cell.setCellStyle(style);
        }
        cell.setCellValue(value);
    }

    /**
     * 增加一行
     * 
     * @param index
     *            行号
     */
    public void createRow(int index) {
        this.row = this.sheet.createRow(index);
    }

    public int getRowNum() {
        return this.row.getRowNum();
    }

    public int getNextRowNum() {
        return this.row.getRowNum() + 1;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public HSSFSheet getSheet() {
        return sheet;
    }

    public HSSFRow getRow() {
        return row;
    }

    public void setRow(HSSFRow row) {
        this.row = row;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public void setSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }

}

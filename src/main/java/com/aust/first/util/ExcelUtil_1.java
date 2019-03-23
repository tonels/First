package com.aust.first.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

/**
 * 导出Excel工具类
 */
public class ExcelUtil_1 {
	
	public static void main(String[] args) {
		
	}
   /** 
    * sheetֵ
    * @param sheet:窗栏
    * @param rowNum:行数
    * @param startColNum:起始列
    * @param cellStyle:cell格式
    * @param values
    */
	public static void setLineValue(HSSFSheet sheet, int rowNum, int startColNum,
			HSSFCellStyle cs, String[] values) {
		for(int i=0;i<values.length ;i++){
			//��Ԫ��ֵ�����ֵ
			setCellValue(sheet,rowNum,startColNum++,cs, values[i]);
		}		
	}
    /**
     * ����sheet��ÿ����Ԫ��ֵ
     * @param sheet��
     * @param rowNum������
     * @param cloNum:����
     * @param cs����Ԫ����ʽ
     * @param value����Ԫ��ֵ����ֵvalues[i]
     */
    private static void setCellValue(HSSFSheet sheet, int rowNum, int colNum,
		HSSFCellStyle cs, String value) {
	    //��ȡrowNum��row
    	HSSFRow row=sheet.getRow(rowNum);
    	if(row==null){
    		//����һ��
    		row=sheet.createRow(rowNum);
    	}
    	HSSFCell cell=row.getCell(colNum);
    	if(cell==null){
    		//����colNum�ĵ�Ԫ��
    		cell=row.createCell(colNum);
    	}
    	//���õ�Ԫ��ֵ����
    	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
    	if(cs!=null){
    		cell.setCellStyle(cs);
    	}
    	if(value==null){
    		cell.setCellValue(new HSSFRichTextString(""));//���ÿ�ֵ
    	}else{
    		cell.setCellValue(new HSSFRichTextString(value));
    	} 	
	
    }
    /**
     * ���õ�Ԫ��ֵ
     * @param sheet:������
     * @param rowNum������
     * @param startColNum:��ʼ����
     * @param cs:��ʽ
     * @param values:ֵ����,�˴��������list<?>����
     */
	public static void setLineValue(HSSFSheet sheet, int rowNum,
			int startColNum, HSSFCellStyle cs, List<String> values) {
		//Ƕ��ѭ������������
		for(int i=0;i<values.size();i++){
			setCellValue(sheet, rowNum, startColNum++, cs, values.get(i));
		}
	}
    /**
     * ��ȡ��Ԫ��ֵ
     * @param sheet��������
     * @param rownum������
     * @param colnum:����
     * @return
     */
	public static String getCellValue(HSSFSheet sheet, int rownum, int colnum) {
		HSSFRow row=sheet.getRow(rownum);//���sheet���rownum��
		return getCellValue(row,colnum);
	}
	/**
	 * @param row����row��
	 * @param colnum������
	 * @return
	 */
	private static String getCellValue(HSSFRow row, int colnum) {
		String cellValue = "";
		HSSFCell cell = row.getCell(colnum);
		if (cell != null) {
			if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				cellValue = cell.getRichStringCellValue().toString().trim();
			} 
			//��ֵ����
			else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
					double val = cell.getNumericCellValue();
					int val2 = (int)val;
					if (val - val2 == 0) {
						cellValue = String.valueOf(val2);
					} else {
						cellValue = String.valueOf(val);
					}
				}
			}

		return cellValue.trim();
	}
}


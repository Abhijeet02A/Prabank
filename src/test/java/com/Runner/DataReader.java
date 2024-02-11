package com.Runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader{
	//create method to read data from excel
	//create method to write data to excel
	
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private String excelPath;
	private int lastRowNumber;
	
	/**
	 * reading data from excel for given field like firstName, lastName, etc.
	 * @param key
	 * @return value read from excel
	 */
	public DataReader() {
		System.out.println("Happy to read data");
		excelPath = "src/test/resources/ParabankData.xlsx";
	}
	public String readValueForGivenkey(String key) {
		String value = "";
		try {
			FileInputStream excelFile = new FileInputStream(excelPath);
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet("UserData");		
			lastRowNumber = excelWSheet.getLastRowNum();
			
			for (int i = 0; i <= lastRowNumber; i++) {
				String cellValue = excelWSheet.getRow(i).getCell(0).getStringCellValue();
				if (cellValue.equals(key)) {
					value = excelWSheet.getRow(i).getCell(1).getStringCellValue();
					break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return value;
	}
	
	public void writeValueToKey(String key, String value) {
		try {
			FileInputStream excelFile = new FileInputStream(excelPath);
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet("UserData");		
			lastRowNumber = excelWSheet.getLastRowNum();
			
			for (int i = 0; i <= lastRowNumber; i++) {
				String cellValue = excelWSheet.getRow(i).getCell(0).getStringCellValue();
				if (cellValue.equals(key)) {
					System.out.println(key + " ---" + value);
					excelWSheet.getRow(i).getCell(1).setCellValue(value);
					break;
				}
			}
			FileOutputStream out = new FileOutputStream(
		            new File(excelPath));
			excelWBook.write(out);
	        out.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

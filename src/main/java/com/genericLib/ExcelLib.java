package com.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	public String getExceldata(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
	    String data=rw.getCell(colnum).getStringCellValue();
		System.out.println("come1");
	    return data;
		}
	public int countofdata(String filepath,String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException{
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetname);
		int rowcount=	sh.getLastRowNum();
		return rowcount;
	}
	public void ReadExceldata(String filepath,String sheetname,int rownum,int colnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(cel.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(filepath);
		cel.setCellValue(data);
		wb.write(fos);
		wb.close();
	
	
	}
	
	public double getExceldatanum(String filepath,String sheetname,int rownum,int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
	    double data=rw.getCell(colnum).getNumericCellValue();
	    return data;
		}
	public void ReadExceldatanum(String filepath,String sheetname,int rownum,int colnum,double data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row rw=sh.getRow(rownum);
		Cell cel=rw.createCell(colnum);
		cel.setCellType(cel.CELL_TYPE_NUMERIC);
		FileOutputStream fos=new FileOutputStream(filepath);
		int e=(int)data;
	    cel.setCellValue(e);
		wb.write(fos);
		wb.close();
	
	
	}
	
}

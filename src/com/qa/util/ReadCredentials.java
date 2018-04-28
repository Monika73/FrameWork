package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadCredentials {
	public String CropID;
	public String Username;
	public String Password;
	public String TestCase;
	public String RunMode;
	
	@SuppressWarnings("rawtypes")
	public HashMap hm;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ReadCredentials() throws BiffException, IOException {
		hm =new HashMap();

	FileInputStream File=new FileInputStream("Input_Folder//TestCases.xls");
	Workbook wb =Workbook.getWorkbook(File);
	Sheet shCredentials=wb.getSheet("Credentials");
	CropID=shCredentials.getCell(0,1).getContents();
	Username=shCredentials.getCell(1,1).getContents();
	Password=shCredentials.getCell(2,1).getContents();
	
	Sheet shTestCase=wb.getSheet("TestCase");
	int rowSize = shTestCase.getRows();
	for(int i=1;i<rowSize;i++) {
	TestCase=shTestCase.getCell(0,i).getContents();
	RunMode=shTestCase.getCell(1,i).getContents();
	hm.put(TestCase, RunMode);
	}
	}
	
	
}

package com.ebay.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.LandingPage;
import com.ebay.page.resultsPage;

public class resultsTest extends TestBase{
	
	LandingPage lp;
	resultsPage rt;
	
	public resultsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		FileInputStream fis = null;
		Workbook wb = null;
		try
		{
			fis = new FileInputStream("C:\\Users\\Nachiya\\eclipse-workspace\\eBay\\src\\main\\java\\com\\ebay\\testdata\\TestData.xlsx");
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			wb = WorkbookFactory.create(fis);
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Sheet sheet = wb.getSheet("Sheet1");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void test1(String prod, String cat)
	{
		rt = lp.results(prod, cat);
		boolean res = rt.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.ElectronicsPage;
import com.ebay.page.LandingPage;

public class ElectronicsTest extends TestBase{
	
	LandingPage lp;
	ElectronicsPage ep;
	
	public ElectronicsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		ep = lp.navigate_Electronics();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = ep.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

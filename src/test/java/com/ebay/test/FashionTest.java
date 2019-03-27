package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.FashionPage;
import com.ebay.page.LandingPage;

public class FashionTest extends TestBase{
	
	LandingPage lp;
	FashionPage fp;
	
	public FashionTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		fp = lp.navigate_Fashion();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = fp.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

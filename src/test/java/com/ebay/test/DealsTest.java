package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.DealsPage;
import com.ebay.page.LandingPage;

public class DealsTest extends TestBase{
	
	LandingPage lp;
	DealsPage dp;
	
	public DealsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		dp = lp.naviagte_deals();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = dp.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

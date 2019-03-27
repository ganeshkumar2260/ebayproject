package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.LandingPage;

public class LandingTest extends TestBase{
	
	LandingPage lp;
	
	public LandingTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
	}
	
	@Test(priority=1)
	public void test()
	{
		String res = lp.pageTitle();
		Assert.assertEquals(res, "Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

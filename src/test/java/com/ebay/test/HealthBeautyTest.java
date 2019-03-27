package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.HealthBeautyPage;
import com.ebay.page.LandingPage;

public class HealthBeautyTest extends TestBase{
	
	LandingPage lp;
	HealthBeautyPage hb;
	public HealthBeautyTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		hb = lp.naviagte_HealthBeauty();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = hb.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

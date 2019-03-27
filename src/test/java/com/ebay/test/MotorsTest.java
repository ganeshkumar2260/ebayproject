package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.LandingPage;
import com.ebay.page.MotorsPage;

public class MotorsTest extends TestBase{
	LandingPage lp;
	MotorsPage mp;
	public MotorsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		mp = lp.naviagte_Motors();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = mp.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.LandingPage;
import com.ebay.page.SportsPage;

public class SportsTest extends TestBase{
	
	LandingPage lp;
	SportsPage sp;
	public SportsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		sp = lp.navigate_Sports();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = sp.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

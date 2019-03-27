package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.HomeGardenPage;
import com.ebay.page.LandingPage;

public class HomeGardenTest extends TestBase{
	
	LandingPage lp;
	HomeGardenPage hg;
	public HomeGardenTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		hg = lp.navigate_HomeGarden();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = hg.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}

}

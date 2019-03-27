package com.ebay.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ebay.base.TestBase;
import com.ebay.page.CollectiblesPage;
import com.ebay.page.LandingPage;

public class CollectiblesTest extends TestBase {
	
	LandingPage lp;
	CollectiblesPage ct;
	
	public CollectiblesTest()
	{
		super();
	}
	
	@BeforeMethod
	public void init()
	{
		initialization();
		lp = new LandingPage();
		ct = lp.naviagte_Collect();
	}
	
	@Test(priority=1)
	public void test()
	{
		boolean res = ct.validate_level();
		Assert.assertTrue(res, "Incorrect Page is Displayed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}
}

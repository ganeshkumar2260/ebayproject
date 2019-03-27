package com.ebay.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.base.TestBase;
import com.ebay.page.LandingPage;

public class BrokenLinksTest extends TestBase {

	LandingPage lp;

	public BrokenLinksTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LandingPage();
	}
	
	@Test
	public void brokenlinksTest() throws IOException
	{
		List<WebElement> e = driver.findElements(By.tagName("a"));
		e.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> f = new ArrayList<WebElement>();
		
		for (WebElement q:e)
		{
			if (q.getAttribute("href") != null)
			{
				if(!q.getAttribute("href").contains("javascript"))
				{
					f.add(q);
				}
			}
		}
		
		for (WebElement l:f)
		{
			URL u = new URL(l.getAttribute("href"));
			HttpURLConnection c = (HttpURLConnection)u.openConnection();
			if (c.getResponseCode() !=200)
			{
				System.out.println(u.toString());
			}
			c.disconnect();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		close_method();
	}
}

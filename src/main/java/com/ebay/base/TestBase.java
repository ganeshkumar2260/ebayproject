package com.ebay.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ebay.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public WebEventListener lrnr;
	public EventFiringWebDriver e_driver;
	
	public TestBase()
	{
		prop = new Properties();
		try
		{
			FileInputStream pf = new FileInputStream("C:\\Users\\Nachiya\\eclipse-workspace\\eBay\\src\\main\\java\\com\\ebay\\config\\config.properties");
			prop.load(pf);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\qspiders\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "D:\\qspiders\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		lrnr = new WebEventListener();
		e_driver.register(lrnr);
		driver = e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("page_time_out")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicit_wait")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void close_method()
	{
		driver.close();
	}

}

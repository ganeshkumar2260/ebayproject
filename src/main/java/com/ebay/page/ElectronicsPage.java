package com.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.base.TestBase;

public class ElectronicsPage extends TestBase{
	public ElectronicsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ol//li//a[text()='eBay']")
	WebElement first_Level;
	
	@FindBy(xpath = "//ol//li//span[text()='Electronics']")
	WebElement curr_Level;
	
	public boolean validate_level()
	{
		if (first_Level.getText().equals("eBay") && curr_Level.getText().equals("Electronics"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

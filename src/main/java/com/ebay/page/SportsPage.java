package com.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.base.TestBase;

public class SportsPage extends TestBase{
	public SportsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ol//li//a[text()='eBay']")
	WebElement first_Level;
	
	@FindBy(xpath = "//ol//li//span[text()='Sporting Goods']")
	WebElement curr_Level;
	
	public boolean validate_level()
	{
		if (first_Level.getText().equals("eBay") && curr_Level.getText().equals("Sporting Goods"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

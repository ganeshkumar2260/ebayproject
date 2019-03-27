package com.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.base.TestBase;

public class DealsPage extends TestBase{
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(linkText="Deals")
	WebElement curr_Level;
	
	public boolean validate_level()
	{
		if (curr_Level.getText().equals("Deals"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

package com.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.base.TestBase;

public class MotorsPage extends TestBase{
	public MotorsPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//h1[text()='Parts and Accessories']")
	WebElement curr_Level;
	
	public boolean validate_level()
	{
		if (curr_Level.getText().equals("Parts and Accessories"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

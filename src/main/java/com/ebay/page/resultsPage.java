package com.ebay.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ebay.base.TestBase;

public class resultsPage extends TestBase{
	public resultsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(), 'results')]")
	WebElement first_level;

	@FindBy(id = "w4-w3-follow-follow-faux-btn")
	WebElement curr_Level;
	
	public boolean validate_level()
	{
		WebDriverWait w = new WebDriverWait(driver, 40);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("w4-w3-follow-follow-faux-btn")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'results')]")));
		if (first_level.getText().contains("results") && curr_Level.getText().equals("Save this search"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

package com.ebay.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ebay.base.TestBase;

public class LandingPage extends TestBase{

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gh-ac")
	WebElement sInput;
	
	@FindBy(id ="gh-btn")
	WebElement sBtn;
	
	@FindBy(id = "gh-cat")
	WebElement catDrop;
	
	@FindBy(linkText = "Electronics")
	WebElement elec_Link;
	
	@FindBy(linkText = "Fashion")
	WebElement Fash_Link;
	
	@FindBy(linkText = "Health & Beauty")
	WebElement Health_Beauty_Link;
	
	@FindBy(linkText = "Motors")
	WebElement Motor_Link;
	
	@FindBy(linkText = "Collectibles")
	WebElement collect_Link;
	
	@FindBy(linkText = "Sports")
	WebElement sport_Link;
	
	@FindBy(linkText = "Home & Garden")
	WebElement HG_Link;
	
	@FindBy(linkText = "Deals")
	WebElement Deal_Link;
	
	public String pageTitle()
	{
		return driver.getTitle();
	}
	
	public ElectronicsPage navigate_Electronics()
	{
		elec_Link.click();
		return new ElectronicsPage();
	}
	
	public FashionPage navigate_Fashion()
	{
		Fash_Link.click();
		return new FashionPage();
	}
	
	public HealthBeautyPage naviagte_HealthBeauty()
	{
		Health_Beauty_Link.click();
		return new HealthBeautyPage();
	}
	
	public MotorsPage naviagte_Motors()
	{
		Motor_Link.click();
		return new MotorsPage();
	}
	
	public CollectiblesPage naviagte_Collect()
	{
		collect_Link.click();
		return new CollectiblesPage();
	}
	
	public SportsPage navigate_Sports()
	{
		sport_Link.click();
		return new SportsPage();
	}
	
	public HomeGardenPage navigate_HomeGarden()
	{
		HG_Link.click();
		return new HomeGardenPage();
	}
	
	public DealsPage naviagte_deals()
	{
		Deal_Link.click();
		return new DealsPage();
	}
	
	public resultsPage results(String srText, String srCat)
	{
		sInput.sendKeys(srText);
		Select s = new Select(catDrop);
		s.selectByVisibleText(srCat);
		sBtn.click();
		return new resultsPage();
	}

}

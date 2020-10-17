package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class TimelinePage extends BaseClass{
	public void loadAllElements() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath="//span[@class='_1qv9']")
	WebElement btn_profile;
	
	@FindBy(xpath="//div[@class='_5_jv _58jw']")
	WebElement allposts;
	
	public void clickProfileButton() {
		btn_profile.click();
	} 
}

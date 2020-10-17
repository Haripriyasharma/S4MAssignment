package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class FindFriendsPage extends BaseClass{
	public void loadAllElements() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath="//div[@class='_cy7']")
	WebElement btn_findfriends;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement txt_entername;
	
	@FindBy(xpath="//button[@class='_42ft _4jy0 _4w98 _4jy3 _517h _51sy _4w97']")
	WebElement btn_search;
	
	public void clickFindFriendsButton() {
		btn_findfriends.click();
	}
	public void enterFriendNameToSearch(String text) {
		txt_entername.sendKeys(text);
	}
	public void clickSearchButton() {
		btn_search.click();
	}
}

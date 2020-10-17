package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class ProfilePage extends BaseClass{
	@FindBy(xpath = "//span[@class='_1qv9']")
	WebElement btn_profile;

	@FindBy(linkText = "Add Cover Photo")
	WebElement btn_addPhoto;

	@FindBy(id = "js_s")
	WebElement btn_uploadPhoto;

	@FindBy(xpath = "(//button[@value='1'])[11]")
	WebElement btn_savePhoto;

	public void loadAllElements() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickAddPhotoButton() {
		btn_profile.click();
	}
	public void clickUploadPhotoButton() {
		btn_addPhoto.click();
	}
	public void clickUploadButton(String text) {
		btn_uploadPhoto.click();
		btn_uploadPhoto.sendKeys(text);
	}
	public void clickSavePhotoButton() {
		btn_savePhoto.click();
		
	}
	
}

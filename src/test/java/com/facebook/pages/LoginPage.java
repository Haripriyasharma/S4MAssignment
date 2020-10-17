package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;

public class LoginPage extends BaseClass {
	@FindBy(id="email")
	WebElement txt_email;

	@FindBy(id="pass")
	WebElement txt_password;

	@FindBy(name="login")
	WebElement button_login;

	public void loadAllElements(){
		PageFactory.initElements(getDriver(), this);
	}
	public void uname_input(String text){
		txt_email.clear();
		txt_email.sendKeys(text);
	}
	public void password_input(String text){
		txt_password.clear();
		txt_password.sendKeys(text);
	}
	public void click_loginbutton(){
		button_login.click();
	}
}

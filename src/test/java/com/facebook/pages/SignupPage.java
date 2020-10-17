package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import TestBase.BaseClass;

public class SignupPage extends BaseClass {

	@FindBy(xpath = "//a[@id='u_0_2']")
	WebElement btn_createNewAccount;

	@FindBy(xpath = "//input[@id='u_1_b']") 
	WebElement txt_firstName;

	@FindBy(xpath = "//input[@id='u_1_d']")
	WebElement txt_surName;

	@FindBy(xpath = "//input[@id='u_1_g']")
	WebElement txt_mobile;

	@FindBy(xpath = "//input[@id='password_step_input']")
	WebElement txt_newPassword;

	@FindBy(xpath = "//select[@id='day']")
	WebElement txt_day;

	@FindBy(xpath = "//select[@id='month']")
	WebElement txt_month;

	@FindBy(xpath = "//select[@id='year']")
	WebElement txt_year;

	@FindBy(xpath = "//input[@value='1']")
	WebElement gender_female;

	@FindBy(xpath = "//input[@value='2']")
	WebElement gender_male;

	@FindBy(xpath = "//input[@value='-1']")
	WebElement gender_custom;

	@FindBy(xpath = "//button[@id='u_1_s']")
	WebElement btn_signUp;

	@FindBy(xpath = "//img[@id='u_1_9']")
	WebElement btn_close;
	
	/*@FindBy(xpath = "//div[@id='userNavigationLabel']")
	WebElement btn_userNavigation;
	
	@FindBy(xpath = "//span[@class='_54nh']")
	WebElement btn_logout;*/

	public void loadAllElements() {
		PageFactory.initElements(getDriver(), this);
	}
	public void clickSignupButton() {
		btn_createNewAccount.isDisplayed();
		btn_createNewAccount.click();
	}
	public void firstname_input(String text){
		txt_firstName.clear();
		System.out.println("hvh");
		txt_firstName.sendKeys(text);
	}
	public void surname_input(String text){
		txt_surName.isDisplayed();
		txt_surName.clear();
		txt_surName.sendKeys(text);
	}
	public void mobile_input(String text){
		txt_mobile.isDisplayed();
		txt_mobile.clear();
		txt_mobile.sendKeys(text);
	}
	public void newpassword_input(String text){
		txt_newPassword.isDisplayed();
		txt_newPassword.clear();
		txt_newPassword.sendKeys(text);
	}
	public void day_input(String text){
		txt_day.isDisplayed();
		Select day = new Select(txt_day);
		day.selectByVisibleText(text);
	}
	public void month_input(String text){
		txt_month.isDisplayed();
		Select month = new Select(txt_month);
		month.selectByVisibleText(text);
	}
	public void year_input(String text){
		txt_year.isDisplayed();
		Select year = new Select(txt_year);
		year.selectByVisibleText(text);
	}
	public void select_female(){
		gender_female.isDisplayed();
		gender_female.click();
	}
	public void select_male(){
		gender_male.isDisplayed();
		gender_male.click();
	}
	public void select_custom(){
		gender_custom.isDisplayed();
		gender_custom.click();
	}
	public void click_signupButton() {
		btn_signUp.isDisplayed();
		btn_signUp.click();
	}
	public void click_closeSignup() {
		btn_close.click();
	}
	/*public void click_userNavigation() {
		btn_userNavigation.click();
	}
	public void click_logout() {
		btn_logout.click();
	}*/
}

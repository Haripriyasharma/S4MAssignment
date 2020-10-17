package com.facebook.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;
import com.facebook.pages.SignupPage;

import Utils.Utils;

public class SignupTest extends SignupPage {
	SoftAssert softAssertion= new SoftAssert();
	HSSFSheet sheet = Utils.getSheetFromExcel("\\TestData\\TestInputData.xls", "signup");

	@Test
	public void invalidPasswordTest() throws InterruptedException {
		test = getExtentReports().createTest("sign up with invalid password",
				"PASSED test case");
		loadAllElements();
		clickSignupButton();
		Thread.sleep(5000);
		HSSFRow row = sheet.getRow(2);
		setValues(row);
		String error = row.getCell(8).getStringCellValue();
		softAssertion.assertEquals(getDriver().findElement(By.xpath("//img[@id='u_1_9']")).getText(), error);
		Thread.sleep(10000);
	}

	@Test
	public void oneNumberMultipleTimesTest() throws InterruptedException {
		test = getExtentReports().createTest("Sign up multiple times with one number",
				"PASSED test case");
		Thread.sleep(15000);
		switchToActiveElements();
		HSSFRow row = sheet.getRow(1);
		setValues(row);
		String error = row.getCell(8).getStringCellValue();
		softAssertion.assertEquals(getDriver().findElement(By.xpath("//img[@id='u_1_9']")).getText(), error);
		Thread.sleep(3000);
	}

	@Test
	public void alreadyExistingAccountTest() throws InterruptedException {
		test = getExtentReports().createTest("Sign up with already existing number",
				"PASSED test case");
		Thread.sleep(5000);
		HSSFRow row = sheet.getRow(3);
		setValues(row);
		String error = row.getCell(8).getStringCellValue();
		softAssertion.assertEquals(getDriver().findElement(By.xpath("//img[@id='u_1_9']")).getText(), error);
		click_closeSignup();
	}

	public void setValues(HSSFRow row) throws InterruptedException {
		String firstname = row.getCell(0).getStringCellValue();
		firstname_input(firstname);
		String surname = row.getCell(1).getStringCellValue();
		surname_input(surname);
		String mobile = row.getCell(2).getStringCellValue();
		mobile_input(mobile);
		String newPassword = row.getCell(3).getStringCellValue();
		newpassword_input(newPassword);
		String day = row.getCell(4).getStringCellValue();
		day_input(day);
		String month = row.getCell(5).getStringCellValue();
		month_input(month);
		String year = row.getCell(6).getStringCellValue();
		year_input(year);
		String gender = row.getCell(7).getStringCellValue();
		if (gender.equalsIgnoreCase("female")) {
			select_female();
		} else if (gender.equalsIgnoreCase("male")) {
			select_male();
		} else {
			select_custom();
		}
		click_signupButton();
		Thread.sleep(5000);
	}
}

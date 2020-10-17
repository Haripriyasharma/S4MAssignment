package com.facebook.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;

import com.facebook.pages.LoginPage;

import Utils.Utils;

public class LoginTest extends LoginPage {
	@Test
	public void verifyUserLogin() {
		loadAllElements();
		test = getExtentReports().createTest("Verify user login", "test executed");
		HSSFSheet sheet = Utils.getSheetFromExcel("\\TestData\\TestInputData.xls","login");
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			HSSFRow row = sheet.getRow(i);
			String username = row.getCell(0).getStringCellValue();
			uname_input(username);
			String password = row.getCell(1).getStringCellValue();
			password_input(password);
			click_loginbutton();
			boolean isValid = row.getCell(3).getBooleanCellValue();
			if(isValid) {
				System.out.println("logged in");
			}else {
				String validationError = row.getCell(2).getStringCellValue();
				String e = getDriver().findElement(By.xpath("//div[@class='_9ay7']")).getText();
				Assert.assertEquals(e, validationError);
				getDriver().navigate().back();
			}
		}
	}
	
	
}

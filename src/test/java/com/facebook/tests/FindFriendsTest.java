package com.facebook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.facebook.pages.FindFriendsPage;

public class FindFriendsTest extends FindFriendsPage {
	SoftAssert softAssertion = new SoftAssert();

	@DataProvider(name = "friendname")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Haripriya", true }, { "Sandeep", false }, };
	}

	@Test(dataProvider = "friendname")
	public void findFriendsTest(String fname, Boolean valid) throws InterruptedException {
		test = getExtentReports().createTest("Find friends", "test executed");
		loadAllElements();
		Thread.sleep(20000);
		clickFindFriendsButton();
		Thread.sleep(5000);
		enterFriendNameToSearch(fname);
		Thread.sleep(2000);
		clickSearchButton();
		ArrayList<WebElement> friends = new ArrayList<WebElement>(
				getDriver().findElements(By.xpath("//div[@class='_6v_0 _4ik4 _4ik5']")));
		int size = friends.size();
		if (valid) {
			softAssertion.assertTrue(size != 0);
			String friendName;
			for (int i = 0; i < size; i++) {
				friendName = friends.get(i).getText().toString();
				System.out.println(friendName);
				;
			}
		} else {
			softAssertion.assertTrue(size == 0);
		}
		softAssertion.assertAll();
	}
}

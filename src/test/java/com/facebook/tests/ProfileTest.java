package com.facebook.tests;

import org.testng.annotations.Test;
import com.facebook.pages.ProfilePage;

public class ProfileTest extends ProfilePage {
	@Test
	public void profilePhotoTest() throws InterruptedException {
		test = getExtentReports().createTest("Upload profile pic", "test case executed");
		loadAllElements();
		Thread.sleep(10000);
		clickAddPhotoButton();
		clickUploadPhotoButton();
	}
}

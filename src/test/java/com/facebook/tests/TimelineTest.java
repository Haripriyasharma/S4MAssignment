package com.facebook.tests;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.facebook.pages.TimelinePage;

public class TimelineTest extends TimelinePage {
	@Test
	public void checkAllPosts() throws InterruptedException {
		loadAllElements();
		test = getExtentReports().createTest("Check all posts", "test executed");
		clickProfileButton();
		Thread.sleep(20000);
		WebElement postContainer = getDriver()
				.findElement(By.xpath("//div[@id='timeline_story_container_100056361833751']"));
		if (postContainer != null) {
			List<WebElement> posts = postContainer.findElements(By.xpath("//div[@class='_5pcb _4b0l _2q8l']"));
			if (posts != null) {
				int size = posts.size();
				System.out.println(size);
			}
		}
	}
}

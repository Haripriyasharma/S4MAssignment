package TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseClass {
	public ExtentTest test;
	private static WebDriver driver;
	private ExtentReports extent;

	// to switch to active element on page
	public void switchToActiveElements() {
		driver.switchTo().activeElement();
	}

	// calling WebdriverInstance class method init() where webdriver is initialized
	@BeforeSuite
	public void setUp() {
		WebdriverInstance.init();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		// write or update test information to reporter
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}

	public ExtentReports getExtentReports() {
		if (extent == null)
			extent = WebdriverInstance.getInstance().getExtentReport();
		return extent;
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = WebdriverInstance.getInstance().getDriver();
		return driver;
	}

	@AfterSuite
	public void closeDriver() {
		driver.close();
	}
}

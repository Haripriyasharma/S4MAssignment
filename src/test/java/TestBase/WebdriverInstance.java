package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverInstance {
	/*
	 * Creating single instance of web driver and extent report
	 */
	private static WebdriverInstance instance = null;
	private static ChromeDriver driver;
	private static ExtentReports extent;

	private WebdriverInstance() {
		// private constructor so that new object cannot be created outside this class
	}

	public static WebdriverInstance getInstance() {
		if (instance == null) {
			instance = new WebdriverInstance();
		}
		return instance;
	}

	public ChromeDriver getDriver() {
		return driver;
	}

	public ExtentReports getExtentReport() {
		return extent;
	}

	/* Initialize web driver and extent report before suite */
	public static void init() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		// 1-Allow, 2-Block, 0-default
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/testReport.html");
		// Initialise ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

		Properties prop;
		try {
			String configFilePath = System.getProperty("user.dir");
			FileInputStream propertyFile = new FileInputStream(
					configFilePath + "\\src\\test\\java\\Configurations\\config.properties");
			prop = new Properties();
			prop.load(propertyFile);
			driver.get(prop.getProperty("url"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
	}
}

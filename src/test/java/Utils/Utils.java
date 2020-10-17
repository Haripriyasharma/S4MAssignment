package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Utils {
	// to get sheet from test data excel file
	public static HSSFSheet getSheetFromExcel(String filePath, String sheetName) {
		HSSFWorkbook workbook;
		HSSFSheet sheet = null;
		String configFilePath = System.getProperty("user.dir");
		FileInputStream fi;
		try {
			fi = new FileInputStream(configFilePath + filePath);
			workbook = new HSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}

	// To create html file in test-outut folder to show test report
	public static void extentReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/testreport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
}

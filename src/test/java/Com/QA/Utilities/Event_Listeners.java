package Com.QA.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Event_Listeners implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public static WebDriver driver; // Must be assigned from your base class

	public void configureReport() {
	    String reportPath = System.getProperty("user.dir") + "//Reports//Swag_Labs_Report.html";
	    
	    htmlReporter = new ExtentSparkReporter(reportPath);
	    reports = new ExtentReports();
	    reports.attachReporter(htmlReporter);

	    reports.setSystemInfo("Machine", "pc1");
	    reports.setSystemInfo("OS", "Windows 11");
	    reports.setSystemInfo("User Name", "Tejas");

	    htmlReporter.config().setDocumentTitle("Extent Listener Report");
	    htmlReporter.config().setReportName("Swag Labs Automation Report");
	    htmlReporter.config().setTheme(Theme.DARK);
	}


	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start method invoked....");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked....");
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test Passed: " + result.getName(), ExtentColor.GREEN));

		String screenshotPath = captureScreenshot(result.getName());
		if (screenshotPath != null) {
			test.pass("Screenshot:",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test Failed: " + result.getName(), ExtentColor.RED));

		String screenshotPath = captureScreenshot(result.getName());
		if (screenshotPath != null) {
			test.fail("Screenshot:",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped: " + result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	public String captureScreenshot(String testName) {
	    if (driver == null) return null;

	    String screenshotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + testName + ".png";

	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);
	    try {
	        FileUtils.copyFile(src, dest);
	        return screenshotPath;
	    } catch (IOException e) {
	        System.out.println("Screenshot capture failed: " + e.getMessage());
	        return null;
	    }
	}

}

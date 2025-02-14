package com.crm.Listeners;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.Dwspage;
import com.crm.FileUtility.ReadProperties;

public class AttachExtentReport extends Dwspage implements ITestListener {

	public static ExtentSparkReporter spark = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
//		Reporter.log("onTestStart for - " + name, true);
		test = report.createTest(name);
		test.log(Status.INFO, name + " is onTestStat.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
//		Reporter.log("onTestSuccess for - " + name, true);
		test.log(Status.PASS, name + " is onTestSuccess.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(':', '-');
		String name = result.getMethod().getMethodName();
		test.log(Status.FAIL, name+" is onTestFaillure");
//		Reporter.log("\033[91monTestFailure\033[0m", true);
//		Reporter.log("onTestFailure for - " + name, true);

		TakesScreenshot ts = (TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
//		Reporter.log("onTestSkipped for - " + name, true);
		test.log(Status.SKIP, name + " is onTestSkipped.");
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart", true);
//		String browser = ReadProperties.getData("browser");
//		browser.
//		String sampleReport = "SampleReport" + (++report);
//	Create ExtentSparkReport
//		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/Reports/" + sampleReport + ".html");
		spark = new ExtentSparkReporter("src/test/resources/Reports/MultipleReport.html");
//	Configure ExtentSparkReport
		spark.config().setDocumentTitle("Demo Web Shop");
		spark.config().setReportName("Anup N. Jaiswal");
		spark.config().setTheme(Theme.DARK);
// Create ExtentReport	
		report = new ExtentReports();
//	Provide System Information
		report.setSystemInfo("OS", "Darwin");
		report.setSystemInfo("Browser", "Chrome-133.0.6943.55");
//	Attach the ExtentSparkReport to ExtentReport
		report.attachReporter(spark);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onTestFinished", true);
		report.flush();
	}

}

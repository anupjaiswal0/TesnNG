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

import com.crm.BaseClass.Dwspage;

public class FailedTestCase extends Dwspage implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestStart for - " + name, true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestSuccess for - " + name, true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(':', '-');
		String name = result.getMethod().getMethodName();
//		Reporter.log("\033[91monTestFailure\033[0m", true);
		Reporter.log("onTestFailure for - " + name, true);

		TakesScreenshot ts = (TakesScreenshot) driver;

		File from = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("src/test/resources/ScreenShots" + name + time + ".png");

		try {
			FileHandler.copy(from, to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		Reporter.log("onTestSkipped for - " + name, true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("onStart", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("onTestFinished", true);
	}


}

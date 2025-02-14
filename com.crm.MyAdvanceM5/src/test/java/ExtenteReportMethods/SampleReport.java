package ExtenteReportMethods;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.FileUtility.ReadProperties;

public class SampleReport {
	public int report = 0;

	@Test
	public void reports() throws IOException {
		String browser = ReadProperties.getData("browser");
//		browser.
		String sampleReport = "SampleReport" + (++report);
//	Create ExtentSparkReport
		ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/Reports/" + sampleReport + ".html");
//	Configure ExtentSparkReport
		spark.config().setDocumentTitle("Demo Web Shop");
		spark.config().setReportName("Anup N. Jaiswal");
		spark.config().setTheme(Theme.DARK);
// Create ExtentReport	
		ExtentReports report = new ExtentReports();
//	Provide System Information
		report.setSystemInfo("OS", "Darwin");
		report.setSystemInfo("Browser", "Chrome-133.0.6943.55");
//	Attach the ExtentSparkReport to ExtentReport
		report.attachReporter(spark);
//	Create ExtentTest
		ExtentTest test = report.createTest("reports");
//	Use Flush
		report.flush();

	}
}

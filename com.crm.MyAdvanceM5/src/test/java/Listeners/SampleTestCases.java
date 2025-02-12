package Listeners;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.Listeners.Sample.class)
public class SampleTestCases {
	@Test
	public void dws() {
		Reporter.log("dws TestCase", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.quit();
	}

	@Test
	public void csk() {
		Reporter.log("csk TestCase", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		driver.quit();
		assertEquals("mani", "money");
//		assertEquals("mani", "mani");
	}

	@Test(dependsOnMethods = "csk")
	public void rcb() {
		Reporter.log("rcb TestCase", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		driver.quit();
//		assertEquals("mani", "money");
	}
}

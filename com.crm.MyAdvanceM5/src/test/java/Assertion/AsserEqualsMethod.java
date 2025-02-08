package Assertion;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AsserEqualsMethod {
	@Test
	public void test() {
		String expected_result = "https://demowebshop.tricentis.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://demowebshop.tricentis.com/");
		String actual_result = driver.getCurrentUrl();

		assertEquals(expected_result, actual_result, "I'm not at the correct Page.");

		Reporter.log("I'm in the Correct Page.",true);
		driver.quit();
	}
}

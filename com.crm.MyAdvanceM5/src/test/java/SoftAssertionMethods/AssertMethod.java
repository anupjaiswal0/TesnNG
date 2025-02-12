package SoftAssertionMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertMethod {
	@Test
	public void test() throws InterruptedException {
//		Basic
		String expected_result = "https://demowebshop.tricentis.com";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://demowebshop.tricentis.com/");
		String actual_result = driver.getCurrentUrl();

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(expected_result, actual_result, "I'm not on the dws page.");
		Reporter.log("I'm on the dws page", true);

		driver.quit();
		soft.assertAll();
	}
}

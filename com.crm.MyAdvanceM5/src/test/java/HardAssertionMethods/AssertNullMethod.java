package HardAssertionMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertNullMethod {
	@Test
	public void test() throws InterruptedException {
		String name = "Awake";
		String expected_result = "https://demowebshop.tricentis.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://demowebshop.tricentis.com/");
		String actual_result = driver.getCurrentUrl();

		assertEquals(expected_result, actual_result, "I'm not at the correct Page.");
		Reporter.log("I'm in the Correct Page.", true);

		driver.findElement(By.id("small-searchterms")).sendKeys("360 Glob Master");
		WebElement search_btn = driver.findElement(By.xpath("//input[@type='submit']"));

		assertTrue(search_btn.isEnabled(), "Search Button is not Enabaled");
		Reporter.log("All things a good", true);
		search_btn.click();
//		Thread.sleep(2000);
		
		assertNull(name);
		driver.quit();
	}
}

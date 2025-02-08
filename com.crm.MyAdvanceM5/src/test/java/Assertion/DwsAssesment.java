package Assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DwsAssesment {
	@Test
	public void test() throws InterruptedException {
//		Basic
		String expected_result = "https://demowebshop.tricentis.com/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://demowebshop.tricentis.com/");
		String actual_result = driver.getCurrentUrl();

//		Home page verification
		assertEquals(expected_result, actual_result, "I'm not at the correct Page.");
		Reporter.log("I'm in the Correct Page.", true);
		
//		Login link verification
		WebElement login = driver.findElement(By.linkText("Log in"));
		assertTrue(login.isDisplayed(),"Login not present");
		Reporter.log("Login button present", true);
		login.click();
		
//		username field
		String email = "admin01@gmail.com";
		WebElement username = driver.findElement(By.id("Email"));
		username.sendKeys(email);
		
		String actual_usr = username.getAttribute("value");
		Reporter.log("Username Passed", true);
		assertEquals(email, actual_usr, "User not matched");
		
		
//		password field
		String pass = "admin01";
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys(pass);
		
		String actual_pass = password.getAttribute("value");
		assertEquals(actual_pass, pass, "Password not matchewd");
		Reporter.log("Password Passed", true);
	
//		Reporter.log("Finding login button", true);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.quit();
		
	}
}

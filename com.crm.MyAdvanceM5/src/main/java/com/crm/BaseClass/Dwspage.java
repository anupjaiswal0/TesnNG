package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.ReadProperties;

public class Dwspage {
	public static String browser = null;
	public static WebDriver driver = null;

	@BeforeClass
	public void preCondition() throws IOException {
		browser = ReadProperties.getData("browser");
		String url = ReadProperties.getData("url");
		if (browser.contentEquals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.contentEquals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.contentEquals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.contentEquals("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(url);
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String username = ReadProperties.getData("username");
		String password = ReadProperties.getData("password");
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
//		System.out.println("login successfull");
	}

	@AfterMethod
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
		System.out.println("logout successfull");
	}

	@AfterClass
	public void postCondtion() {
		driver.quit();
	}
}

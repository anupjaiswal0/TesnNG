package TestNGExe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationsType {
	@Test(priority = 1, invocationCount = 2, threadPoolSize = 5)
	public void dws() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.quit();
	}

	@Test(invocationCount = 2, threadPoolSize = 5)
	public void csk() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chennaisuperkings.com/");
		driver.quit();
	}

	@Test(priority = 0, invocationCount = 2, threadPoolSize = 2)
	public void rcb() {
		int count=0;
		System.out.println(++count);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.royalchallengers.com/");
		driver.quit();
	}
}

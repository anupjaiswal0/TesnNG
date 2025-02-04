package TestNGExe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DependsOnMethod 
{
	@Test(priority = 1)
	public void createAccount()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.quit();

		System.out.println("createAccount");
	}
	
	@Test(priority = 0, dependsOnMethods  = "createAccount")
	public void updateAccount()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chennaisuperkings.com/");
		driver.quit();

		System.out.println("updateAccount");
	}

	@Test(priority = 2, dependsOnMethods = "createAccount")
	public void deleteAccount()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.royalchallengers.com/");
		driver.quit();

		System.out.println("deleteAccount");
	}

}

package Listeners;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.Dwspage;

@Listeners(com.crm.Listeners.FailedTestCase.class)
public class FailedTestCaseScreenShot extends Dwspage {
	@Test
	public void digitalDownload() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("ico-cart")).click();
		Thread.sleep(2000);

		try {
			WebElement album3d = driver.findElement(By.xpath("(//a[text()='3rd Album'])[2]"));
			assertTrue(album3d.isDisplayed(), "Product is not added");
			Reporter.log("Product is successfully added", true);
			driver.findElement(By.name("removefromcart")).click();
			driver.findElement(By.name("updatecart")).click();
		} catch (Exception e) {
			Reporter.log("Product is not present", true);
			assertEquals("m", "n", "Product is not present");
		}
	}
}


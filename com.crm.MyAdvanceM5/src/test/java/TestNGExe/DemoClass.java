package TestNGExe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.BaseClass.Dwspage;

public class DemoClass extends Dwspage {
	@Test
	public void mani() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("small-searchterms")).sendKeys("Mercedes G Wagon");
		driver.findElement(By.cssSelector(".button-1.search-box-button")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void main2() throws InterruptedException {
		String rss_url = "https://demowebshop.tricentis.com/news/rss/1";
		List<WebElement> social_medias = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		for (WebElement ele : social_medias) {
			String actual_url = driver.getCurrentUrl();
			if(rss_url.equals(actual_url)) {
				driver.navigate().back();
			}
			ele.click();
			Thread.sleep(2000);
		}
	}
}

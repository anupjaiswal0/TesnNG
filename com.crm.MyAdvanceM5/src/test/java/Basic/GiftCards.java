package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.BaseClass.Dwspage;

public class GiftCards extends Dwspage{
	@Test
	public void main() {
		driver.findElement(By.xpath("//a[contains(test(), 'Gift Cards']")).click();
		List<WebElement> gifts = driver.findElements(By.className("item-box"));
		for (WebElement gift : gifts) {
			Reporter.log(gift.getText());
			
			driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys("Amisha");
			driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys("amishasayyad92@mgail.com");
			driver.findElement(By.id("giftcard_1_SenderName")).sendKeys("Manikandan");
			driver.findElement(By.id("giftcard_1_SenderEmail")).sendKeys("manij2305@mgail.com");
			driver.findElement(By.id("giftcard_1_Message")).sendKeys("manij2305@mgail.com");
			driver.findElement(By.id("add-to-cart-button-1")).click();
			
		}
	}
}

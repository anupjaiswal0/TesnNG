package Basic;

import org.openqa.selenium.chrome.ChromeDriver;

public class LunchDriver {
	public static void main(String[] args) {
		String expected_url = "https://demowebshop.tricentis.com/";
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		String current_url = driver.getCurrentUrl();
		if(expected_url.equals(current_url)) {
			
		}else {
			System.out.println("URL unmatched.");
		}
	}
}

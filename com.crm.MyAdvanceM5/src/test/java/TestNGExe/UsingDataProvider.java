package TestNGExe;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {
	@DataProvider(name = "login")
	public Object[][] sender() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("/Users/rahul/Documents/DwsLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int colums = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[rows][colums];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<colums; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
//		obj[0][0] = "admin01@gmail.com";
//		obj[0][1] = "admin01";
//		obj[1][0] = "admin01@gmail.com";
//		obj[1][1] = "admin111";
		return obj;
	}

	@Test(dataProvider = "login")
	public void dws(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

		Thread.sleep(3000);
//		WebElement isValidate = driver.findElement(By.partialLinkText("Log out"));
//		if(isValidate.isDisplayed()) {			
//		}
		driver.quit();
		Thread.sleep(2000);
	}
}

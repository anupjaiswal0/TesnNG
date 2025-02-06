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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRM {
	@DataProvider(name = "login")
	public Object[][] sender() throws EncryptedDocumentException, IOException {
//		System.out.println("I'm a data provider");
//		Reporter.log("I'm a data provider");
		Reporter.log("I'm a data provider", true); // to see the message on cosole
		FileInputStream fis = new FileInputStream("/Users/rahul/Downloads/OrangHRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
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
	public void reciever(String username, String password) throws InterruptedException {
//		System.out.println("I'm reciever for login");
		Reporter.log("I'm reciever for login");
		Reporter.log("I'm reciever for login",true); // to see the message on cosole
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15000));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		Thread.sleep(3000);
//		WebElement isValidate = driver.findElement(By.partialLinkText("Log out"));
//		if(isValidate.isDisplayed()) {			
//		}
		driver.quit();
		Thread.sleep(2000);
	}
}

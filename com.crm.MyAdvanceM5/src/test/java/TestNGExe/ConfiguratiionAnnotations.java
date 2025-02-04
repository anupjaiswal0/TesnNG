package TestNGExe;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfiguratiionAnnotations {

	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("before Class");
	}

	@BeforeSuite
	public void beforeSuitMethod() {
		System.out.println("before Suit");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("before Test");
	}

	@BeforeMethod
	public void beforeMethodMethod() {
		System.out.println("before Method");
	}

	@Test
	public void testMethod() {
		System.out.println("Test 1");
	}

	@AfterMethod
	public void afterMethodMethod() {
		System.out.println("after Method");
	}

	@AfterClass
	public void afterClassMethod() {
		System.out.println("after Class");
	}

	@AfterTest
	public void afterTestMethod() {
		System.out.println("after Test");
	}

	@AfterSuite
	public void afterSuitMethod() {
		System.out.println("after Suit");
	}

	@Test
	public void testMethod2() {
		System.out.println("Test 2");
	}

	@Test
	public void testMethod3() {
		System.out.println("Test 3");
	}
}

package ExtenteReportMethods;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.Dwspage;

import TestCaseExecution1.Dws;

//@Listeners(com.crm.Listeners.AttachExtentReport.class)
public class UsingListeners extends Dwspage {
	@Test
	public void main1() {
		Reporter.log("Main1 executed.", true);
	}

	@Test
	public void main2() {
		Reporter.log("Main2 executed.", true);
	}
	@Test
	public void main3() {
		Reporter.log("Main3 executed.", true);
	}

	@Test(timeOut = 1000)
	public void main4() throws InterruptedException {
		Reporter.log("Main4 executed.", true);
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "main4")
	public void main5() {
		Reporter.log("Main5 executed.", true);
	}
	
}

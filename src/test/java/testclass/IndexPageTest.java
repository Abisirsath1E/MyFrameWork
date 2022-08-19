package testclass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.beust.jcommander.Parameters;

import actiondriver.BaseClass;
import pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
    
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	


	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		//Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		AssertJUnit.assertTrue(result);
		//Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
	//	Log.startTestCase("verifyTitle");
		String actTitle=indexPage.getMyStoreTitle();
		AssertJUnit.assertEquals(actTitle, "My Store1");
	//	Log.endTestCase("verifyTitle");
	}

	
}
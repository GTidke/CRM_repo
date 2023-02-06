package testLayer;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseLayer.CRM_baseclass;
import pageLayer.CRM_loginPage;
import utilsLayer.CRM_screenshot;

public class Test_LoginPage extends CRM_baseclass{
	CRM_loginPage log;	
	CRM_screenshot ss;
	//CRM_baseclass baseclass=new CRM_baseclass();
	@BeforeClass
	public void openURL() {
		CRM_baseclass.intialization();
		log=new CRM_loginPage();
	}
	
	@Test
	public void login_cogmento() {
	log.EnterUserName(prop.getProperty("Username"));
	log.EnterPassword(prop.getProperty("Password"));
	log.submitLogin();
	}
	
	@Test(dependsOnMethods={"login_cogmento"})
	public void CaptureTitle() {
		Assert.assertEquals("Cogmento CRM", driver.getTitle());
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
		ss=new CRM_screenshot("/failScreenshot/"+result.getName()+".png");		
	}
		else {
		ss=new CRM_screenshot("/passScreenShot/"+result.getName()+".png");	
		}
		System.out.println("Screenshot Captured");
		//driver.quit();
	}
@AfterClass
	public void teardown() {
		//driver.close();
	}
	
}

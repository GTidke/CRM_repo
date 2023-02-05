package testLayer;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseLayer.CRM_baseclass;
import pageLayer.CRM_loginPage;

public class Test_LoginPage extends CRM_baseclass{
	CRM_loginPage log;
	
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
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}

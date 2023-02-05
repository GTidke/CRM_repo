package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.CRM_baseclass;

public class CRM_loginPage extends CRM_baseclass {

	@FindBy(name = "email")
	WebElement name;
	
	@FindBy(name = "password")
	WebElement passcode;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement submit;

	public CRM_loginPage() {
    PageFactory.initElements(driver,this);
	}
	
	public void EnterUserName(String enterUserName) {
		name.sendKeys(enterUserName);
	}
    
	public void EnterPassword(String enterPassword) {
		passcode.sendKeys(enterPassword);
	}

    public void submitLogin() {
    	submit.click();
    }

}

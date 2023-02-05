package utilsLayer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseLayer.CRM_baseclass;

public class CRM_screenshot extends CRM_baseclass {
	File f;

	public CRM_screenshot() {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File f = ss.getScreenshotAs(OutputType.FILE);
	}

	public void PassScreenshot() {
		File dest = new File(System.getProperty("user.dir") + "passScreenShot/name.png");
		try {
			FileUtils.copyFile(f, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
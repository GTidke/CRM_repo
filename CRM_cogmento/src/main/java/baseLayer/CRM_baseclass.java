package baseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CRM_baseclass {
	public static Properties prop;
	public static WebDriver driver;

	public CRM_baseclass() {
		Properties prop = new Properties();
		try {
			FileInputStream f = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\configLayer\\config.properties");
			prop.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() {
		String Browser = prop.getProperty("BrowserName");
		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Please state correct Browser Name");
		}
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
	}
}

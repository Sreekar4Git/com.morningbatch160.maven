package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInvoke {

	public static WebDriver openBrowser(WebDriver driver, String url) throws Exception {
		
		ExcelUtils b = new ExcelUtils();
		String browser = b.readPropFile(System.getProperty("user.dir")+ "/dataFiles/config.properties", "browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			
		}
		else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		return driver;
	}
}

package baseClasses;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utils.BrowserInvoke;
import utils.ExcelUtils;
import utils.SeleniumHelper;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExcelUtils excel = new ExcelUtils();
	public static XSSFSheet sheet;
	public static SeleniumHelper sh = new SeleniumHelper();
	
	@BeforeSuite
	
	public void suiteStructure() throws Exception
	{
		sheet = excel.loadXlxsFile(System.getProperty("user.dir")+"/datafiles/employee2.xlsx", "Sheet2");
	}
	
	@BeforeTest
	public void browserSetup() throws Exception
	{
		driver=BrowserInvoke.openBrowser(driver, sheet.getRow(2).getCell(1).toString());
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void closeSuite()
	{
		
	}
	
}
package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.LoginPage;
import utils.BrowserInvoke;

public class LoginTest4 extends BaseClass{

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//System.out.println("Test passed");
	}
	@BeforeClass
	public void openBrowser() throws Exception
	{
	    driver=BrowserInvoke.openBrowser(driver, sheet.getRow(2).getCell(1).toString());
		LoginPage lp=new LoginPage(driver);
		lp.Login();
	}
	
	@Test
	public void login() throws Exception
	{
	
		Thread.sleep(3000);
	    WebElement titlePage=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		Assert.assertEquals(titlePage.getText(), "Dashboard");
		
		
	}
	
	
	
	

}

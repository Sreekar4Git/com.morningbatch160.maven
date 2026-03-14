package testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.LoginPage;
import utils.BrowserInvoke;
import utils.SeleniumHelper;

public class LoginTest extends BaseClass {
	
//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
	
//	@BeforeClass
//	public void openBrowser() throws Exception {
		
//		driver = BrowserInvoke.openBrowser(driver, sheet.getRow(2).getCell(1).toString());
//		//LoginPage lp = new LoginPage(driver);
//		//lp.Login();
//	}

	@Test
	public void  login() throws InterruptedException {

		WebElement userNameTB=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement passwordTB=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBTN=driver.findElement(By.xpath("//button[@type='submit']"));
		
		
		SeleniumHelper.sendDataTextBox(userNameTB, sheet.getRow(0).getCell(0).toString());
		SeleniumHelper.sendDataTextBox(passwordTB, sheet.getRow(0).getCell(1).toString());
		SeleniumHelper.clickElement(loginBTN);
		Thread.sleep(3000);
		
		WebElement titlePage=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		Assert.assertEquals(titlePage.getText(), "Dashboard");
		
		//System.out.println("test passed");
		

	}
}

package testClasses;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import utils.SeleniumHelper;

public class DashBoardPageTC extends BaseClass{

	@BeforeClass
	public void login() throws InterruptedException   {
		
		WebElement usernameTB = driver.findElement(By.xpath("//div//input[@name=\"username\"]"));
		WebElement passwordTB = driver.findElement(By.xpath("//div//input[@name=\"password\"]"));
		WebElement loginBTN = driver.findElement(By.xpath("//div//button[@type=\"submit\"]"));
		
		SeleniumHelper.sendDataTextBox(usernameTB, sheet.getRow(0).getCell(0).toString());
		SeleniumHelper.sendDataTextBox(passwordTB, sheet.getRow(0).getCell(1).toString());
		SeleniumHelper.clickElement(loginBTN);
		Thread.sleep(4);
		
	}
	
	@BeforeMethod
	public void beondashboardpage() {
		WebElement db = driver.findElement(By.xpath("//span[text()='Dashboard']"));
		SeleniumHelper.clickElement(db);
		
	}
	
	@Test
	public void textvalidation() {
	String data[] = new String[6];
	    data[0]="Assign Leave";
		data[1]="Leave List";
		data[2]="Timesheets";
		data[3]="Apply Leave";
		data[4]="My Leave";
		data[5]="My Timesheet";
		
		List <WebElement> text = driver.findElements(By.xpath("//p[text()='Assign Leave']/../../..//p"));
		
 //xpath of above elements //p[text()='Assign Leave']/../../..//p	or //div[@class='oxd-grid-3 orangehrm-quick-launch']/div
		
		for(WebElement ele:text) {
			String WebData= ele.getText();
			boolean val=false;
			for(String s:data) {
				if (s.equals(WebData)) {
					val = true;
				break;
		}
			}
			Assert.assertTrue(val);
			//Assert.assertEquals(val, true);
			
			//xpath of above elements //p[text()='Assign Leave']/../../..//p	or //div[@class='oxd-grid-3 orangehrm-quick-launch']/div	
		}
		
		
  }
		
	//	public void textValidation() {
		    // Store expected text in a HashSet for faster lookups
		//    Set<String> expectedTexts = new HashSet<>();
		//    expectedTexts.add("Assign Leave");
		 //   expectedTexts.add("Leave List");
		//    expectedTexts.add("Timesheets");
		//    expectedTexts.add("Apply Leave");
		//    expectedTexts.add("My Leave");
		 //   expectedTexts.add("My Timesheet");

		    // Find elements using XPath
		 //   List<WebElement> textElements = driver.findElements(By.xpath("//p[text()='Assign Leave']/../../..//p"));

		    // Check if elements were found
		 //   Assert.assertFalse(textElements.isEmpty(), "No elements found with the given XPath!");

		 //   for (WebElement ele : textElements) {
		//        String webData = ele.getText().trim();  // Trim whitespace for robustness
		//        Assert.assertTrue(expectedTexts.contains(webData), "Unexpected text found: " + webData);
		//    }
	//	}
		
	@Test
	public void validatetimeatwork() {
		WebElement work = driver.findElement(By.xpath("//p[text()='Time at Work']"));
		Assert.assertEquals(work.getText(), "Time at Work");
		
	}
}

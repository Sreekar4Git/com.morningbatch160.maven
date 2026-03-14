package testClasses;

import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.LoginPage;

public class Logintest5 extends BaseClass {
	
	
   @Test
   public void login() {
	   
	   LoginPage lp = new LoginPage(driver);
	   lp.Login();
   }
	

}

package com.tescase;

import java.time.Duration;

import com.base.BaseDeTest;
import com.pages.LoginPage;
import com.pages.RegisterPage;

import org.testng.ITestResult;
 import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends BaseDeTest {

	@BeforeMethod
	public void setDriver() {
		initialiserDriver();
	}

	LoginPage loginpage;
	
	
    @Test(description="Register Account")
	public void registrationUser() throws InterruptedException
	{
 		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
		LoginPage loginpage = new LoginPage(mobileDriver);
		loginpage.clickregisterbtn();
		RegisterPage registerpage = new RegisterPage(mobileDriver);
		
		registerpage.enterEmail("cust255@yopmail.com");
 		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
		registerpage.enterfirstname("cust255");
		registerpage.enterPassword("123456789");
		registerpage.clickbtnRegister();
	}
	
	 
   // @AfterMethod(alwaysRun=true)
    public void tearDown(ITestResult tearResult) {
        if (mobileDriver != null) {
            mobileDriver.quit();
        }
    }
    
}

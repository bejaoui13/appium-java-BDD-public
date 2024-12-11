package com.base;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
  
public class BaseDeTest {

	public AndroidDriver mobileDriver;

	public AppiumDriverLocalService service;

    protected Properties prop;
	
	public BaseDeTest() { 
		
    }
	
	
	public AndroidDriver initialiserDriver() {
		DesiredCapabilities capabilities = setDesiredCapabilities();
		try {
			mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
		} catch (MalformedURLException e) {
			System.err.println("Error initializing AndroidDriver: " + e.getMessage());
		}

		return mobileDriver;
	}
	
	public DesiredCapabilities setDesiredCapabilities() {
 

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "smart7px");
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("automationName", "uiAutomator2");
		desiredCapabilities.setCapability("app",System.getProperty("user.dir") + "\\app\\application-custumrah.apk");
		desiredCapabilities.setCapability("platformVersion", "15");
 		// desiredCapabilities.setCapability("uiautomator2ServerLaunchTimeout", 60000);
	//	 desiredCapabilities.setCapability("adbExecTimeout", 20000);
	   desiredCapabilities.setCapability("newCommandTimeout", 600);	
		return desiredCapabilities;

	}
	
	 public String takeScreenshot(String testCaseName, AndroidDriver mobileDriver) throws IOException {
	        TakesScreenshot takeScreenshot = (TakesScreenshot) mobileDriver;
	        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
	        String destinationFile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
	        FileUtils.copyFile(source, new File(destinationFile));
	        return destinationFile;
	    }
	

}

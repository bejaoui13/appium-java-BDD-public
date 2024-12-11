package com.utilities;

import java.lang.reflect.Field;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseDeTest;


import io.appium.java_client.android.AndroidDriver;

public class Listener extends BaseDeTest implements ITestListener {
	 
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase Case Execution Started : "+result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase Passed : "+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Testcase Failed: " + result.getName());
	    String testMethodName = result.getMethod().getMethodName();
	    AndroidDriver mobileDriver = null;
	    try {
	        Object testClassInstance = result.getInstance();
	        Field field = result.getTestClass().getRealClass().getDeclaredField("mobileDriver");
	        field.setAccessible(true);
	        mobileDriver = (AndroidDriver) field.get(testClassInstance);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    try {
	        takeScreenshot(testMethodName, mobileDriver);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase Skipped Passed : "+result.getName());
	}
	
}
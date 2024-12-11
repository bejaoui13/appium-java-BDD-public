package com.pages;

import com.base.BaseDeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class RegisterPage  extends BaseDeTest  {
	
	public AndroidDriver mobileDriver;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	@CacheLookup
	WebElement emailregister;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	@CacheLookup
	WebElement firstname;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]")
	@CacheLookup
	WebElement inputpassword;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
	@CacheLookup
	WebElement btnregister;
	
	
	public RegisterPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}
	
	

	public void navigateBack() {
        mobileDriver.navigate().back();
    }
	
	public void enterEmail(String emailreg)
	{
		emailregister.click();
		emailregister.sendKeys(emailreg);
        navigateBack();

	}
	
	public void enterfirstname(String fname)
	{
		firstname.click();
		firstname.sendKeys(fname);
        navigateBack();

	}
	
	public void enterPassword(String password)
	{
		inputpassword.click();
		inputpassword.sendKeys(password);
        navigateBack();

	}
	
	public void clickbtnRegister()
	{
		btnregister.click();
 	}
}

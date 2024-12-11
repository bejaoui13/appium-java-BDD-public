package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageCus {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"text-input-flat\"]")
	WebElement emailLogin;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='button-text']")
	WebElement btnContinuer;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"text-input-flat\"]")
	WebElement emailLoginFil;
	
	public LoginPageCus(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void navigateBack() {
		mobileDriver.navigate().back();
	}

	public void envoyerEmail(String email) {

	 emailLogin.click();
		emailLogin.sendKeys(email);
		btnContinuer.click();

	}
	public void envoyerEmailAfterFailed(String email) {

	 emailLoginFil.click();
		emailLoginFil.sendKeys(email);
		btnContinuer.click();

	}
}

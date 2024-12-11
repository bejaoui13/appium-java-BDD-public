package com.pages;

import com.base.BaseDeTest;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.view.View[@content-desc='New to Urinox? Register']")
	@CacheLookup
	WebElement btnResgietr;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
	WebElement emailLogin;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
	@CacheLookup
	WebElement passwordLogin;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Login']")
	@CacheLookup
	WebElement BtnLogin;

	public LoginPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void navigateBack() {
		mobileDriver.navigate().back();
	}

	public void navigateHome() {
		executeKeyEvent(3); 
	}

	public void showRecentApps() {
		executeKeyEvent(187);  
	}

	private void executeKeyEvent(int keyCode) {
		((RemoteWebDriver) mobileDriver).executeScript("mobile: keyevent", ImmutableMap.of("keycode", keyCode));
	}

	public void clickregisterbtn() {
		btnResgietr.click();
	}

	public void enterLoginEmail(String inputemail) {
		emailLogin.click();
		emailLogin.sendKeys(inputemail);
		navigateBack();
	}

	public void enterLoginPassword(String passwordlog) {
		passwordLogin.click();
		passwordLogin.sendKeys(passwordlog);
		navigateBack();
	}

	public void clickLoginbouton() {
		BtnLogin.click();
	}

}

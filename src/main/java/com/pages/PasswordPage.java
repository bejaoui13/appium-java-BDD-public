package com.pages;

import java.time.Duration;

import com.base.BaseDeTest;
import com.utilities.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PasswordPage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"text-input-flat\"]")
	WebElement inputpassword;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Erreur, Identifiants invalides']")
	WebElement erreurPassword;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"cancel\"]")
	WebElement cancelerreur;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"button-text\"]")
	WebElement buttonpassword;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"goBack\"]")
	public WebElement goBack;

	public PasswordPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void navigateBack() {
		mobileDriver.navigate().back();
	}

	public void envoyerPassword(String passw) {

		inputpassword.click();
		inputpassword.sendKeys(passw);
	//	mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));
		buttonpassword.click();

	}

	public String returnErreurPassword() {
		return erreurPassword.getText();

	}

	public void cancelErreur() {
		cancelerreur.click();

	}

	public void goBack() {
		cancelerreur.click();
        goBack.click();

	

	}

	public boolean verifyElementisdisplayed() {
		Utilities utility = new Utilities(mobileDriver);
		return utility.verifyElementAbsent(cancelerreur);
	}

}

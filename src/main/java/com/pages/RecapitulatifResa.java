package com.pages;

import java.time.Duration;

 
import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class RecapitulatifResa {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.TextView[@text='Récapitulatif de la réservation']")
	WebElement titlePageRecaptitulatif;

	@FindBy(xpath = "(//android.widget.TextView[@text=\"749 €\"])[2]")
	WebElement totalPrix;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirmer et payer\"]")
	WebElement bntConfirmerPayer;

	 
	
	public RecapitulatifResa(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	
	
	public String returnTitleRecaptitulatif() {
		return titlePageRecaptitulatif.getText();
	}

	public String returnPrixRecaptitulatif() {
		//Utilities utility = new Utilities(mobileDriver);
		//utility.scrollToElementById("button-container");

		return totalPrix.getText();
	}

	public void scrollToElementById(String resourceId) { 

		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\"))"));
	}

	
	public void ConfirmerPayerResa() {
		
		scrollToElementById("button-container");
		bntConfirmerPayer.click();
	}
}

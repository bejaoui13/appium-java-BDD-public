package com.pages;

import com.base.BaseDeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Chaque instant de votre Omra\"]") public 
	@CacheLookup
	WebElement titlePageHome;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Omra / Hajj sur mesure\"]")
	@CacheLookup
	WebElement LinkHajjSurMesur;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Logements\"]")
	@CacheLookup
	WebElement LinkLogements;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Transferts Médine - Makkah\"]")
	WebElement LinkTransferts;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Réserver un guide\"]")
	@CacheLookup
	WebElement LinkReserverGuide;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Visites guidées\"]")
	@CacheLookup
	WebElement LinkVisiteGuide;

	
	public HomePage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void navigateBack() {
		mobileDriver.navigate().back();
	}

	public void navigateToHajjSurMesur() {
		LinkHajjSurMesur.click();
	}

	public void navigateToLogements() {
		LinkLogements.click();
	}

	public void navigateToTransferts() {
		LinkTransferts.click();
	}

	public void navigateToReserveGuide() {
		LinkReserverGuide.click();
	}

	public void navigateToVisiteGuide() {
		LinkVisiteGuide.click();
	}

	
	public String returnTitreHome()	{
		return titlePageHome.getText();
		
	}
}

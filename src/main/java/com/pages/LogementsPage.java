
package com.pages;

import com.base.BaseDeTest;
import com.utilities.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LogementsPage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]") WebElement titrelogement;
	@FindBy(xpath="//android.widget.TextView[@text=\"Arrivée\"]") WebElement dateArrive ;
	@FindBy(xpath="//android.widget.TextView[@text=\"Départ\"]") WebElement dateDepart ;
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"Locataire(s) (0), \"]") WebElement participant ;
	@FindBy(xpath="//android.widget.Switch") WebElement activemember ;
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[1]")
	WebElement memberOne;
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[2]")
	WebElement memberTwo;
	
	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"button-container\"])[2]")
	WebElement btnconfirmer;
	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"button-container\"])[1]")
	WebElement btnreserver;
	
	
	public LogementsPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);

	}
	
	public void scrollToElementByText(String text) { 
		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\"))"));
	}
	
	
	public void openLogement(String text)
	{

		scrollToElementByText(text);
		titrelogement.click();
		scrollToElementByText("Arrivée");
			
	}
	    
	public void selectDate(int yearD, int monthD, int dayD,int yearF, int monthF, int dayF )
	{
		dateArrive.click();

		Utilities utilities = new Utilities(mobileDriver);
		utilities.selectDateFromAndroidDatePicker(yearD, monthD, dayD);
		dateDepart.click();
		utilities.selectDateFromAndroidDatePicker(yearF, monthF, dayF);
		

	}
	
	public void selectParticipnat() {
		participant.click();
		activemember.click();
		memberOne.click();
		memberTwo.click();
		btnconfirmer.click();
		btnreserver.click();
	}
	
}

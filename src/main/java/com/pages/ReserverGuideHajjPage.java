package com.pages;

import com.utilities.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReserverGuideHajjPage {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.TextView[@text=\"HAJJ\"]")
	public WebElement btnHajj;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Langues parlées par le guide*, \"]/android.view.ViewGroup")
	WebElement dropdowlangue;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Arabe\"]")
	WebElement langueAR;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Anglais\"]")
	WebElement langueEN;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Français\"]")
	WebElement langueFR;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirmer\"]")
	WebElement BtnConfirmer;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Selectionner une date\"]")
	WebElement selectDate;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Horaires disponibles\"]")
	WebElement selecthoraire;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"surface\"]/android.view.ViewGroup[2]")
	WebElement particiapnt;

	@FindBy(xpath = "//android.widget.Switch")
	WebElement activerMember;

	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[1]")
	WebElement memberOne;
	@FindBy(xpath = "(//android.widget.TextView[@text=\"\"])[2]")
	WebElement memberTwo;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirmer\"]")
	WebElement confirmerPopupMember;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Continuer\"]")
	WebElement btnContinuer;

	@FindBy(xpath = "//android.widget.TextView[@text='749 €']")
	WebElement prixguide;

	public ReserverGuideHajjPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void scrollToElementBytextcontent(String elementsc) {
		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ elementsc + "\"))"));
	}

	public void guideHajj() {
		btnHajj.click();
	}

	public void selectLangue() {
		dropdowlangue.click();
		langueAR.click();
		langueFR.click();
		BtnConfirmer.click();
	}

	public void selectDateReserveGuide(int year, int month, int day) {
		selectDate.click();
		Utilities utilities = new Utilities(mobileDriver);
		utilities.selectDateFromAndroidDatePicker(year, month, day);

	}

	public void horaire() {
		selecthoraire.click();
		mobileDriver.findElement(By.xpath("(//android.view.ViewGroup)[59]")).click();
	}

	public void selectParticipnat() {
		particiapnt.click();
		activerMember.click();
		memberOne.click();
		memberTwo.click();
		scrollToElementBytextcontent("Confirmer");
		confirmerPopupMember.click();
	}

	public void clickContinuer() {
		btnContinuer.click();
	}

	public void returnPrixGuide() {
	//	return prixguide.getText();
	}

}

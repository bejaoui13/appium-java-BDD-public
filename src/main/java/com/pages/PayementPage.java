package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class PayementPage {

	public AndroidDriver mobileDriver;

	
	@FindBy(xpath="//android.view.View[@resource-id=\"PAYMENT_OPTION_CARD_TEST_TAG_+ Add\"]")  WebElement addpayement;
	@FindBy(xpath="//android.view.View[@resource-id=\"PAYMENT_OPTION_CARD_TEST_TAG_····4242\"]")  WebElement saveCarte;
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.rbonecustomrah.app:id/primary_button\"]")  WebElement btnPayer;
	@FindBy(xpath="//android.widget.TextView[@text=\"Merci pour votre paiement\"]")  WebElement succespayement;

	
	
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Card number\"]")  WebElement addcarteBancaire;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.View[2]/android.widget.EditText[2]/android.view.View")  WebElement dateExpirationCB;
	@FindBy(xpath="//android.widget.ScrollView/android.view.View[2]/android.widget.EditText[3]/android.view.View")  WebElement cvcCB;
	
	@FindBy(xpath="//android.widget.ScrollView/android.view.View[3]/android.widget.EditText/android.view.View")  WebElement codep;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Save for future CustOmrah payments\"]")  WebElement saveCB;
	
	@FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"com.rbonecustomrah.app:id/primary_button\"]")  WebElement validerPayement;

	
	public PayementPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}
	
	
	public void addpayementB()
	{
		addpayement.click();
	}
	
	public void addcarteBancaireB(String CarteB, String expdate,String cvc, String codeppostal)
	{
		addcarteBancaire.click();
		addcarteBancaire.sendKeys(CarteB);
		dateExpirationCB.click();
		dateExpirationCB.sendKeys(expdate);
		cvcCB.click();
		cvcCB.sendKeys(cvc);
		codep.sendKeys(codeppostal);
		saveCB.click();
		validerPayement.click();
	}
	
	public void clickSaveCarte()
	{
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

	   saveCarte.click();
		btnPayer.click();
   }
	
	public String  msgSucceesPyement()
	{
		return succespayement.getText();
   }
	
}

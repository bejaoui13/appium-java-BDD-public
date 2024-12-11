package com.pages;

 
import com.base.BaseDeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class languePage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	 
 // @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Suivant']") WebElement btnlangue;
  // @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"button-text\"]") WebElement btndevise;

 //   @FindBy(xpath = "//android.widget.Button[@content-desc='Suivant']") WebElement btnlangue;
 //   @FindBy(xpath = "//android.widget.TextView[@resource-id=\"button-text\"]") WebElement btndevise;

  
    
	public languePage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);

	}

	public void langueSuivant() {
		 WebElement btnlangue = mobileDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Suivant']"));

		btnlangue.click();

		//btndevise.click();
		// Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// clipboard.setContents(new StringSelection(null), null);
		//WebElement btndevise = mobileDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Suivant']"));
 
	}

}

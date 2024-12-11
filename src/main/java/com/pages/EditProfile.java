package com.pages;

import com.base.BaseDeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class EditProfile extends BaseDeTest {

    public	AndroidDriver mobileDriver;
	
	    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Edit\"]")
	    @CacheLookup
	    WebElement editBtn;
	 
	 
		public EditProfile(AndroidDriver mobileDriver) {
			this.mobileDriver = mobileDriver;
			PageFactory.initElements(mobileDriver, this);
		}
	 
	  public void clickEditBtn() {
	    	editBtn.click();
	    }

	  
	
}

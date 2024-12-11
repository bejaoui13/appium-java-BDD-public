package com.tescase;

import java.time.Duration;

import com.base.BaseDeTest;
import com.pages.DevisePage;
import com.pages.HomePage;
import com.pages.LoginPageCus;
import com.pages.PasswordPage;
import com.pages.RecapitulatifResa;
import com.pages.ReserverGuideHajjPage;
import com.pages.languePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AuthentificationTest extends BaseDeTest {
	
 	
	@BeforeClass
	public void setDriver() {
		initialiserDriver();
	}
	
	 
	PasswordPage pagepassword;

	@Test(priority = 0)
	public void testLoginTest() {
		
		
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		languePage languechoos = new languePage(mobileDriver);
		languechoos.langueSuivant();

		DevisePage devisechoos = new DevisePage(mobileDriver);
		devisechoos.deviseSuivant();
		devisechoos.deviseSuivant();

		LoginPageCus loginCustomrah = new LoginPageCus(mobileDriver);
		loginCustomrah.envoyerEmail("test1@yopmail.com");
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		pagepassword = new PasswordPage(mobileDriver);
		pagepassword.envoyerPassword("Sssafa199**");
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
	}
	

	 
}

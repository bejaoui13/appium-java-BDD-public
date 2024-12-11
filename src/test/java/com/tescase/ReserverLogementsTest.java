package com.tescase;

import java.time.Duration;

import com.base.BaseDeTest;
import com.pages.DevisePage;
import com.pages.HomePage;
import com.pages.LogementsPage;
import com.pages.LoginPageCus;
import com.pages.PasswordPage;
import com.pages.PayementPage;
import com.pages.RecapitulatifResa;
import com.pages.languePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class ReserverLogementsTest extends BaseDeTest {

	@BeforeClass
	public void setDriver() {
		initialiserDriver();
	}

	PasswordPage pagepassword;

	@Test(priority = 0)
	public void reserveLogements() {
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		languePage languechoos = new languePage(mobileDriver);
		languechoos.langueSuivant();

		DevisePage devisechoos = new DevisePage(mobileDriver);
		devisechoos.deviseSuivant();
		devisechoos.deviseSuivant();

		LoginPageCus loginCustomrah = new LoginPageCus(mobileDriver);
		loginCustomrah.envoyerEmail("test1@yopmail.com");
		pagepassword = new PasswordPage(mobileDriver);
		pagepassword.envoyerPassword("Sssafa199**");
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		HomePage homepage = new HomePage(mobileDriver);
		String actueltitrehome = homepage.returnTitreHome();
		Assert.assertEquals(actueltitrehome, "Chaque instant de votre Omra");

		homepage.navigateToLogements();

		LogementsPage logement = new LogementsPage(mobileDriver);
		logement.openLogement("MAK");
		logement.selectDate(2024, 10, 25, 2024, 10, 26);
		logement.selectParticipnat();

		RecapitulatifResa pagerecapresa = new RecapitulatifResa(mobileDriver);
		Assert.assertEquals(pagerecapresa.returnTitleRecaptitulatif(), "Récapitulatif de la réservation");
		pagerecapresa.ConfirmerPayerResa();
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		PayementPage ayementpage = new PayementPage(mobileDriver);
		ayementpage.clickSaveCarte();
		Assert.assertEquals(ayementpage.msgSucceesPyement(), "Merci pour votre paiement");

	}
}

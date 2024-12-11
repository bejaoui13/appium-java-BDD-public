package com.tescase;

import java.time.Duration;

import com.base.BaseDeTest;
import com.pages.DevisePage;
import com.pages.HomePage;
import com.pages.LoginPageCus;
import com.pages.PasswordPage;
import com.pages.PayementPage;
import com.pages.RecapitulatifResa;
import com.pages.ReserverGuideHajjPage;
import com.pages.languePage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReserverGuideHajjTest extends BaseDeTest {

	@BeforeClass
	public void setDriver() {
		initialiserDriver();
	}

	PasswordPage pagepassword;

	@Test(priority = 0)
	public void reserveGuideTest() {

		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100000));

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
		homepage.navigateToReserveGuide();
		ReserverGuideHajjPage reserverGuide = new ReserverGuideHajjPage(mobileDriver);
		reserverGuide.scrollToElementBytextcontent("Participant(s) (0)");
		reserverGuide.btnHajj.click();
		reserverGuide.selectLangue();
		reserverGuide.selectDateReserveGuide(2024, 10, 25);
		reserverGuide.horaire();
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		reserverGuide.selectParticipnat();
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		// System.out.println(reserverGuide.returnPrixGuide());
		reserverGuide.clickContinuer();

		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));
		RecapitulatifResa pagerecapresa = new RecapitulatifResa(mobileDriver);
		Assert.assertEquals(pagerecapresa.returnTitleRecaptitulatif(), "Récapitulatif de la réservation");
		// pagerecapresa.returnPrixRecaptitulatif();
		// Assert.assertEquals(reserverGuide.returnPrixGuide(),
		// pagerecapresa.returnPrixRecaptitulatif(), "prix correct");

		pagerecapresa.ConfirmerPayerResa();

		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100000));
		PayementPage ayementpage = new PayementPage(mobileDriver);
		ayementpage.clickSaveCarte();
		Assert.assertEquals(ayementpage.msgSucceesPyement(), "Merci pour votre paiement");

	}

	public void tearDown(ITestResult tearResult) {

		mobileDriver.quit();

	}

}

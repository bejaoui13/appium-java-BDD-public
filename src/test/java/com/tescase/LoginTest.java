package com.tescase;



import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import com.base.BaseDeTest;
import com.pages.OmrasurMesurPage;
import com.pages.DevisePage;
import com.pages.HomePage;
import com.pages.LoginPageCus;
import com.pages.PasswordPage;
import com.pages.languePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseDeTest {

	@BeforeClass
	public void setDriver() {
		initialiserDriver();
	}
	
	PasswordPage pagepassword;
	
	@Test(priority = 0)
	public void testFailedLogin() {
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90000));

		languePage languechoos = new languePage(mobileDriver);
		languechoos.langueSuivant();

		DevisePage devisechoos = new DevisePage(mobileDriver);
		devisechoos.deviseSuivant();
		devisechoos.deviseSuivant();

		LoginPageCus  loginCustomrah = new LoginPageCus(mobileDriver);
		loginCustomrah.envoyerEmail("test123@gmail.com");
	     pagepassword = new PasswordPage(mobileDriver);
	    pagepassword.envoyerPassword("Sssafa199");
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
   	    boolean actuelDisplayelement = pagepassword.verifyElementisdisplayed();
   	   	Assert.assertEquals(actuelDisplayelement, true , "TEST NOK");
    // 	pagepassword.goBack();

	}
	
	@Test(priority = 1)
	public void testSuccesLogin() {
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));

		
	     pagepassword = new PasswordPage(mobileDriver);
	    pagepassword.envoyerPassword("Sssafa199*");
 	    mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));   
 	    HomePage homepage = new HomePage(mobileDriver);
 	    String actueltitrehome = homepage.returnTitreHome();
 	    Assert.assertEquals(actueltitrehome, "Chaque instant de votre Omra");
 	    
	}

//	 
//	public void omraMesurTest() throws InterruptedException, ParseException {
//
//		
//		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
//		OmrasurMesurPage omrasurmesur = new OmrasurMesurPage(mobileDriver);
//		omrasurmesur.testOMrasurMesure();
//		omrasurmesur.clickbtnPartie();
//		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
//		omrasurmesur.scrollToElementBytextcontent("Date de départ");
//		
//		//Depart
//		omrasurmesur.selectdateDepart();
//		omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 12);
//		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
//		omrasurmesur.heureAller(3, 10);
//		omrasurmesur.origineVol("ooooooo");
//		omrasurmesur.sendnumeroVol("55");
//		
//		//depart/arrive
// 		omrasurmesur.selectdateArriveDepart();
//		omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 15);
//		omrasurmesur.selectHeureArriveDepart(4, 15);
//
//		//REtour 
//		omrasurmesur.selectdateRetour();
//		omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 19);
//		omrasurmesur.heureAller(3, 10);
//		omrasurmesur.destinationRetourVol("hhhhh");
//		omrasurmesur.retourNumeroVol("6666");
//		omrasurmesur.scrollToElementById("button"); 
//		System.out.println(omrasurmesur.prix.getText());
//
//		omrasurmesur.clickContinuer();
//		
//	}

  @AfterTest
	public void tearDown() {
 		mobileDriver.quit();

	}

}

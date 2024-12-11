package com.tescase;

import java.text.ParseException;
import java.time.Duration;

import com.base.BaseDeTest;
import com.pages.DevisePage;
import com.pages.LoginPageCus;
import com.pages.OmrasurMesurPage;
import com.pages.PasswordPage;
import com.pages.languePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OmraSurMesureTest extends BaseDeTest {

	
	
	@BeforeMethod
	public void setDriver() {
		initialiserDriver();
	}

	@Test
 		public void omraMesurTest() throws InterruptedException, ParseException {

			
			mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
			OmrasurMesurPage omrasurmesur = new OmrasurMesurPage(mobileDriver);
			omrasurmesur.testOMrasurMesure();
			omrasurmesur.clickbtnPartie();
			mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
			omrasurmesur.scrollToElementBytextcontent("Date de départ");
			
			//Depart
			omrasurmesur.selectdateDepart();
			omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 12);
			mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50000));
			omrasurmesur.heureAller(3, 10);
			omrasurmesur.origineVol("ooooooo");
			omrasurmesur.sendnumeroVol("55");
			
			//depart/arrive
	 		omrasurmesur.selectdateArriveDepart();
			omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 15);
			omrasurmesur.selectHeureArriveDepart(4, 15);

			//REtour 
			omrasurmesur.selectdateRetour();
			omrasurmesur.selectDateFromAndroidDatePicker(2024, 10, 19);
			omrasurmesur.heureAller(3, 10);
			omrasurmesur.destinationRetourVol("hhhhh");
			omrasurmesur.retourNumeroVol("6666");
			omrasurmesur.scrollToElementById("button"); 
			System.out.println(omrasurmesur.prix.getText());

			omrasurmesur.clickContinuer();
			
		}
 
 

    //@AfterTest
	public void tearDown() {
 			mobileDriver.quit();
		
	}
}

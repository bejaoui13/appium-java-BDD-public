package com.pages;

import java.time.format.DateTimeFormatter;

import com.base.BaseDeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormatSymbols;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class OmrasurMesurPage extends BaseDeTest {

	public AndroidDriver mobileDriver;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Omra / Hajj sur mesure\"]")
	WebElement linkOmraMesur;
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"C'est parti !\"]")
	WebElement linkCpartie;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Date de départ\"]")
	WebElement selectDateAfficheCalender;

	// @FindBy(xpath = "//android.widget.Button[@content-desc=\"septembre 2024\"]")
	// WebElement monthAndYear;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Suivant']")
	WebElement increaseMonthButton;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Précédent']")
	WebElement decreaseMonthButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Heure de départ, Champ required\"]")
	WebElement selectheure;

	@FindBy(xpath = "//android.widget.TextView[@text=\"25\"]")
	WebElement popupheure;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"button-text\" and @text=\"OK\"]")
	WebElement OKpopupheure;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Provenance\"]")
	WebElement provenancealler;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Confirmer\"]")
	WebElement provenanceConfirmer;
	@FindBy(xpath = "//android.widget.TextView[@text=\"N° de vol\"]")
	WebElement selectVol;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"button-text\" and @text=\"Confirmer\"]")
	WebElement BtnNumeroVol;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"text-input-flat\"]")
	WebElement sendNumeroVol;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Date d’arrivée prévue']")
	WebElement DateArriprevue;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Heure  d’arrivée prévue\"]")
	WebElement heureArriprevue;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Date de départ, Champ required\"]")
	WebElement retourDate;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Destination\"]")
	WebElement destinationRetour;
	
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\", N° de vol\"])[2]")
	WebElement retourVolNumero;
	
	
	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Continuer\"]")
	WebElement btnContinuer;
	
	@FindBy(xpath ="//android.widget.TextView[@text=\"298 €\"]") public 
	WebElement prix;
	
	
	
	
	
	public OmrasurMesurPage(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}

	public void testOMrasurMesure() {

		linkOmraMesur.click();
	}

	public void clickbtnPartie() {
		linkCpartie.click();
	}



	public void scrollToElementBytextcontent(String elementsc) {

		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+elementsc+"\").instance(0))"));
	}
	
	public void scrollToElementById(String resourceId) { 

		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\"))"));
	}


	public void selectdateDepart() {
		selectDateAfficheCalender.click();

	}

	public void heureAller(int heure, int min) {
		selectheure.click();
		mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='" + heure + "']")).click();
		mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='" + min + "']")).click();
		OKpopupheure.click();
	}

	public void origineVol(String origineV) {
		provenancealler.click();
 		WebElement inputvol = mobileDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='text-input-flat']"));
 		inputvol.sendKeys(origineV);
 		provenanceConfirmer.click();
	}
	
	
	public void sendnumeroVol(String numeroVol) {
 		selectVol.click(); 
 		sendNumeroVol.sendKeys(numeroVol); 
 		BtnNumeroVol.click();
 		
	}
	
	
	public void selectdateArriveDepart() {
		DateArriprevue.click();
	}
	 
	
	public void selectHeureArriveDepart(int heure, int min) {
		heureArriprevue.click();
		mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='" + heure + "']")).click();
		mobileDriver.findElement(By.xpath("//android.widget.TextView[@text='" + min + "']")).click();
		OKpopupheure.click();
	}

		
	public void selectdateRetour() {
		retourDate.click();
	}
  
	public void destinationRetourVol(String destV) {
		destinationRetour.click();
 		WebElement inputvol = mobileDriver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text-input-flat\"]"));
 		inputvol.sendKeys(destV);
 		provenanceConfirmer.click();
	}
	
	
	
	public void retourNumeroVol(String numeroVolR) {
 		selectVol.click(); 
 		sendNumeroVol.sendKeys(numeroVolR); 
 		BtnNumeroVol.click();
 		
	}
	
	public void clickContinuer()
	{
		btnContinuer.click();
	}
	
	
	
	
	public void selectDateFromAndroidDatePicker(int year, int month, int day) throws InterruptedException {
		WebElement monthAndYear = mobileDriver
				.findElement(By.xpath("//android.widget.TextView[@text=\"septembre 2024\"]"));
		int pickerYear = extractYearFromYearPicker(monthAndYear);
		int pickerMonth = extractMonthFromYearPicker(monthAndYear);

		while (year != pickerYear || month != pickerMonth) {
			System.out.println("Finding correct month/year");
			if (pickerYear < year) {
				increaseMonthButton.click();
			} else if (pickerYear > year) {
				decreaseMonthButton.click();
			} else if (pickerMonth < month) {
				increaseMonthButton.click();
			} else if (pickerMonth > month) {
				decreaseMonthButton.click();
			}

			String monthName = new DateFormatSymbols().getMonths()[month - 1];
			monthAndYear = mobileDriver
					.findElement(By.xpath("//android.widget.TextView[@text='" + monthName + " " + year + "']"));
			pickerYear = extractYearFromYearPicker(monthAndYear);
			pickerMonth = extractMonthFromYearPicker(monthAndYear);
		}

		System.out.println("Final picker year and month " + pickerYear + ", " + pickerMonth);
		WebElement dateButton = mobileDriver.findElement(By.xpath("//*[@text='" + day + "']"));
		dateButton.click();	
	}

	private int extractYearFromYearPicker(WebElement yearPicker) {
		String yearPickerValue = yearPicker.getText();
		String pickerYearText = yearPickerValue.replaceAll("[^0-9]", "");
		return Integer.parseInt(pickerYearText);
	}

	private int extractMonthFromYearPicker(WebElement yearPicker) {
		String yearPickerValue = yearPicker.getText();
		String pickerMonthText = yearPickerValue.replaceAll("[^a-zA-Z]", "");
		return java.time.LocalDate.parse(pickerMonthText + " 01 1900", DateTimeFormatter.ofPattern("MMMM dd yyyy"))
				.getMonthValue();
	}
}

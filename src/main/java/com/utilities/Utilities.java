package com.utilities;

import java.text.DateFormatSymbols;
import java.time.format.DateTimeFormatter;

import com.base.BaseDeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Utilities extends BaseDeTest {
	
	public AndroidDriver mobileDriver;

	
	@FindBy(xpath = "//android.widget.Button[@content-desc='Suivant']")
	WebElement increaseMonthButton;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Précédent']")
	WebElement decreaseMonthButton;
	
	
	public Utilities(AndroidDriver mobileDriver) {
		this.mobileDriver = mobileDriver;
		PageFactory.initElements(mobileDriver, this);
	}
	
	
	public boolean verifyElementAbsent(WebElement isDisplay) {

        boolean visible = isDisplay.isDisplayed();
        boolean result = !visible;
        System.out.println(visible);
        return visible;
	}
	
	
	
	public void scrollToElementById(String resourceId) { 

		mobileDriver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\"))"));
	}

	
	public void selectDateFromAndroidDatePicker(int year, int month, int day) {
		WebElement monthAndYear = mobileDriver
				.findElement(By.xpath("//android.widget.TextView[@text=\"octobre 2024\"]"));
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

package com.grubbrr.webautomation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.grubbrr.init.Common;
import com.grubbrr.init.PropertiesFile;

public class WebIndex extends WebObjects {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	PropertiesFile url;

	public WebIndex(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
		action = new Actions(this.driver);
		js = (JavascriptExecutor) driver;
		try {
			url = new PropertiesFile("Data\\url Configuration.properties");
		} catch (Exception e) {
		}
	}

	public void wait_reactjs() {
		JavascriptExecutor js = (JavascriptExecutor) this.driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		for (int i = 0; i < 60; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	public String getTitle() {
		String signupTitle = driver.getTitle();
		return signupTitle;
	}

	public String validateforgotPasswordPageTitle() {
		wait.until(ExpectedConditions.titleContains("Forgot Password | Callhippo.com"));
		return driver.getTitle();
	}

	public void openUrl(String URL) throws IOException {
		driver.get(url.getValue(URL));
	}

	public void clicks_On_Delivery_Button() {
		wait.until(ExpectedConditions.visibilityOf(deliveryButton));
		deliveryButton.click();
	}

	public void clicks_On_Continue_as_Guest_Delivery_Button() {
		wait.until(ExpectedConditions.visibilityOf(Continue_as_Guest_Delivery_Button));
		Continue_as_Guest_Delivery_Button.click();
	}

	public void expand_cakes_section() {
		wait.until(ExpectedConditions.visibilityOf(expand_cakes));
		expand_cakes.click();
	}

	public void add_to_cart_strawberry_Cake() {
		wait.until(ExpectedConditions.visibilityOf(strawberryCake));
		action.moveToElement(strawberryCake).perform();
		strawberryCake.click();

		wait.until(ExpectedConditions.visibilityOf(addToBagButton));
		addToBagButton.click();
	}

	public void clicks_on_Checkout_button() {
		wait.until(ExpectedConditions.elementToBeClickable(btncheckout));
		wait.until(ExpectedConditions.visibilityOf(btncheckout));
		wait_reactjs();
		Common.pause(5);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Common.pause(2);
		btncheckout.click();
	}

	public void enter_address_Line_1(String addressline1) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(AddressLine1)).sendKeys(addressline1);
	}

	public void enter_address_Line_2(String addressline2) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(AddressLin2)).sendKeys(addressline2);
	}

	public void enter_City_name(String city) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(City)).sendKeys(city);
	}

	public void select_state_By_visisble_text(String value) {
		Common.pause(1);
		Select select = new Select(state);
		select.selectByVisibleText(value);
	}

	public void enter_Zip(String zip) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(Zip)).sendKeys(zip);
	}

	public void enter_First_Name(String name) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(name);
	}

	public void enter_Phone_number(String phoneNumber) {
		Common.pause(5);
		wait.until(ExpectedConditions.visibilityOf(this.phoneNumber)).sendKeys(phoneNumber);
	}

	public void enter_Email(String email) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(this.email)).sendKeys(email);
	}

	public void enter_credit_card_holder_name(String credit_card_holder_name) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(this.credit_card_holder_name)).sendKeys(credit_card_holder_name);
	}

	public void enter_credit_card_number(String credit_card_number) throws InterruptedException {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(this.credit_card_number)).click();
		char[] ch = credit_card_number.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
			Actions action = new Actions(driver);
			action.sendKeys(String.valueOf(ch[i])).build().perform();
			Thread.sleep(500);
		}

	}

	public void enter_expiry_date(String expiry_date) throws InterruptedException {
		Common.pause(1);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		wait.until(ExpectedConditions.visibilityOf(this.expiry_date)).click();
		char[] ch = expiry_date.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			System.out.print(ch[i]);
			Actions action = new Actions(driver);
			action.sendKeys(String.valueOf(ch[i])).build().perform();
			Thread.sleep(500);
		}
	}

	public void enter_CVV(String cvv) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(this.cvv)).sendKeys(cvv);
	}

	public void enter_zipcode(String zipcode) {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(this.zipcode)).sendKeys(zipcode);
	}

	public void clicks_On_CompleteOrder_Button() {
		Common.pause(1);
		wait.until(ExpectedConditions.visibilityOf(CompleteOrder));
		js.executeScript("return arguments[0].click();", CompleteOrder);
	}

	public boolean validate_order_process_completed() {

		try {
			wait.until(ExpectedConditions.visibilityOf(printBill));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

}
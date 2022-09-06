package com.grubbrr.webautomation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebObjects {

	
	@FindBy(id = "SubmitDelivey")
	WebElement deliveryButton;

	@FindBy(id = "Continue_as_Guest_Delivery")
	WebElement Continue_as_Guest_Delivery_Button;
	
	@FindBy(xpath = "//h3[text()='Cakes']/..")
	WebElement expand_cakes;
	
	@FindBy(xpath = "//div[@data-product_sku='strawberry cake']/../..//a")
	WebElement strawberryCake;
	
	@FindBy(id = "SingleItemOrder")
	WebElement addToBagButton;
	
	@FindBy(xpath = "//button[@id='btncheckout']")
	WebElement btncheckout;
	
	
	@FindBy(id = "AddressLine1")
	WebElement AddressLine1;
	
	@FindBy(id = "AddressLin2")
	WebElement AddressLin2;
	
	@FindBy(id = "City")
	WebElement City;
	
	@FindBy(id = "state")
	static
	WebElement state;
	
	@FindBy(id = "Zip")
	WebElement Zip;
	
	@FindBy(id = "dFName")
	WebElement firstName;
	
	@FindBy(id = "dPhone")
	WebElement phoneNumber;
	
	@FindBy(id = "dReceiptEmail")
	WebElement email;
	
//	@FindBy(xpath = "//li[@id='Tip1'][1]")
//	WebElement discountCode;
	
	@FindBy(id = "credit_card_holder_name")
	WebElement credit_card_holder_name;
	
	@FindBy(id = "credit_card_number")
	WebElement credit_card_number;
	
	@FindBy(id = "expiry_date")
	WebElement expiry_date;
	
	@FindBy(id = "cvv")
	WebElement cvv;
	
	@FindBy(id = "zipcode")
	WebElement zipcode;
	
	@FindBy(id = "CompleteOrder")
	WebElement CompleteOrder;
	
	
	@FindBy(xpath = "//div[text()='Estimated Delivery Time']")
	WebElement printBill;
	
	
	
}
	
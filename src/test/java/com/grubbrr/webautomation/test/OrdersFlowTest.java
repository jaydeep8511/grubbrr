package com.grubbrr.webautomation.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.grubbrr.init.Common;
import com.grubbrr.init.PropertiesFile;
import com.grubbrr.init.TestBase;
import com.grubbrr.webautomation.WebIndex;

public class OrdersFlowTest {
	WebDriver driver;
	WebIndex homePage;
	
	public OrdersFlowTest() throws Exception {

	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		TestBase testbase = new TestBase();
		driver = testbase.init();
		homePage = PageFactory.initElements(driver, WebIndex.class);

	}

	@AfterMethod
	public void endTestWork(ITestResult result) throws Exception {
		if (ITestResult.FAILURE == result.getStatus()) {
			String testname = "Fail";
			Common.Screenshot(driver, testname, "Test Fail " + result.getMethod().getMethodName());
			System.out.println(testname + " - " + result.getMethod().getMethodName());

		} else {
			String testname = "Pass";
			Common.Screenshot(driver, testname, "Test Pass " + result.getMethod().getMethodName());
			System.out.println(testname + " - " + result.getMethod().getMethodName());

		}

		driver.quit();
	}

	@Test(priority = 1, dataProvider = "Make_Order", retryAnalyzer = com.grubbrr.init.Retry.class)
	public void Make_Order(String name, String email) throws Exception {

		homePage.openUrl("homepage");
		homePage.clicks_On_Delivery_Button();
		homePage.clicks_On_Continue_as_Guest_Delivery_Button();
		homePage.expand_cakes_section();
		homePage.add_to_cart_strawberry_Cake();
		homePage.clicks_on_Checkout_button();
		homePage.enter_address_Line_1("Florida Mall Avenue Orlando Orange Country");
		homePage.enter_address_Line_2("Florida Mall Avenue Orlando");
		homePage.enter_City_name("Florence");
		homePage.select_state_By_visisble_text("Florida");
		homePage.enter_Zip("32244");
		homePage.enter_First_Name(name);
		homePage.enter_Phone_number("1224121212");
		homePage.enter_Email(Common.randomStringNumber() + email);
		homePage.enter_credit_card_holder_name("Sanjay");
		homePage.enter_credit_card_number("4111111111111111");
		homePage.enter_expiry_date("12/22");
		homePage.enter_CVV("212");
		homePage.enter_zipcode("17000");
		homePage.clicks_On_CompleteOrder_Button();
		assertTrue(homePage.validate_order_process_completed(), "Order Placed");

	}

	@DataProvider(name = "Make_Order")
	public Object[][] multiple_orders() {

		return new Object[][] { { "Automationa", "Automation1@auto.com" }, { "Automationb", "Automation2@auto.com" },

				{ "Automationc", "Automation3@auto.com" }, 
				{ "Automationd", "Automation4@auto.com" },
				{ "Automatione", "Automation5@auto.com" }, 
				{ "Automationf", "Automation6@auto.com" },
				{ "Automationg", "Automation7@auto.com" }, 
				{ "Automationh", "Automation8@auto.com" },
				{ "Automationi", "Automation9@auto.com" }, 
				{ "Automationj", "Automation10@auto.com" },
				{ "Automationk", "Automation11@auto.com" }, 
				{ "Automationl", "Automation12@auto.com" },
				{ "Automationm", "Automation13@auto.com" }, 
				{ "Automationn", "Automation14@auto.com" },
				{ "Automationo", "Automation15@auto.com" }, 
				{ "Automationp", "Automation16@auto.com" },
				{ "Automationq", "Automation17@auto.com" }, 
				{ "Automationr", "Automation18@auto.com" },
				{ "Automations", "Automation19@auto.com" }, 
				{ "Automationt", "Automation20@auto.com" },
				{ "Automationu", "Automation21@auto.com" } };
	}

}

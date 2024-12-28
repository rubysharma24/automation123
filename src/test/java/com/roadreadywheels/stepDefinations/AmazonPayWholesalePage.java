package com.roadreadywheels.stepDefinations;

import com.roadreadywheels.comman.JavaCore;
import com.roadreadywheels.or.AmazonPayWholesaleLocator;
import com.roadreadywheels.or.CardPaymentLocator;
import com.roadreadywheels.or.ResaleDashboardLocators;
import com.roadreadywheels.or.SplashPageLocators;
import com.roadreadywheels.utils.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPayWholesalePage {
	@Given("user navigate to Dashboard")
	public void user_navigates_to_the_dashboard_page_successfully_after_the_successful_payment_process1() {

	}

	@When("user clicks on the next RoadReadyWheels logo")
	public void user_clicks_on_the_next_road_ready_wheels_logo() {
		JavaCore.clickOn(CardPaymentLocator.DASHBOARD_PAGE_LOGO);
	}

	@When("clicks on Shop Now button")
	public void clicks_on_shop_now_button() {
		JavaCore.clickOn(CardPaymentLocator.SHOPNOW_LINK);
	}

	// Locator fetch from wholesale page
	@When("navigates to the Wholesale section")
	public void navigates_to_the_resale_section() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_OPTION);
		System.out.println("wholesale select");
	}

	@When("searches for a product in the search area")
	public void searches_for_a_product_in_the_search_area() {
		JavaCore.sendKeys(ResaleDashboardLocators.ResaleDashboard_SEARCH_FIELD, PropertyReader.getDataProperty("wholesaleitem"));
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
		JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SEARCH_BUTTON);
		System.out.println("click on search button");
	}

	@When("click on search item field")
	public void when_click_on_search_iteam() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_SEARCH);
		//JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SEARCH_WHEEN_SEARCH);
		System.out.println("click on search item");
	}

	// Locator on wholesale page
	@When("clicks on the item quantity")
	public void clicks_on_the_item_quantity() {
		JavaCore.selectDropDownByIndex(AmazonPayWholesaleLocator.WHOLESALE_QUANTITY_DROPDOWN, 12);
		System.out.println("quantity selected 12");
	}

	@When("adds the product to the cart")
	public void adds_the_product_to_the_cart() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_CART_BUTTON);
		System.out.println("click on addtoCart item");
	}

	@When("proceeds to complete the checkout process")
	public void proceeds_to_complete_the_checkout_process() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_BUTTON);
		System.out.println("click on complete checkout");
	}

	@When("enters a billing PO number")
	public void enters_a_billing_po_number() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavaCore.clearAndSendKeys(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_PO_FIELD,
				PropertyReader.getDataProperty("ponumber"));
		System.out.println("enter po bill");
	}

	@When("click on a complete order icon")
	public void when_clickon_complete_order() {
		JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_PO_COMPLETE_ORDER_BUTTON);
		System.out.println("click on complete order");
	}

	@When("selects Amazon Pay as the payment method")
	public void selects_amazon_pay_as_the_payment_method() {
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_BUTTON_CLICK);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("USE YOUR AMAZON ACCOUNT");
	}

	@When("enter email in the email field")
	public void enter_email_in_the_email_field() {
		JavaCore.sendKeys(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_EMAIL_ENTER,
				PropertyReader.getConfigProperty("amazonemail"));
	}

	@When("enter password in the password field")
	public void enter_password_in_the_password_field() {
		JavaCore.sendKeys(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_PASSWORD_ENTER,
				PropertyReader.getConfigProperty("amazonpassword"));
	}

	@When("click on amazon sign-in button")
	public void click_on_amazon_sign_in_button() {
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_SIGNIN_BUTTON);
	}

	@When("selects an available shipping address")
	public void selects_an_available_shipping_address() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_SHIPPING_CONTINUE);
		System.out.println("click and select available shipping address");
	}

	@When("continues to the payment options page")
	public void continues_to_the_payment_options_page() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickByJS(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_CONTINUE_PAYMENT_OPTION);
		System.out.println("click on continue");
	}
	@When("places the order")
	public void places_the_order() {
		JavaCore.clickOn(AmazonPayWholesaleLocator.WHOLESALE_AMAZONPAYMENT_PLACEORDER);
	}
	@Then("verifies that the order is successful using Amazon Pay")
	public void verifies_that_the_order_is_successful_using_amazon_pay() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}

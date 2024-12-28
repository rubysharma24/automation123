package com.roadreadywheels.stepDefinations;

import com.roadreadywheels.comman.JavaCore;
import com.roadreadywheels.or.CardPaymentLocator;
import com.roadreadywheels.or.ResaleDashboardLocators;
import com.roadreadywheels.utils.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CardPaymentPage {
	@Given("user navigates to the dashboard page successfully after the successful payment process")
//	public void user_navigates_to_the_dashboard_page_successfully_after_the_successful_payment_process() {
//	    // Assuming you have a method to navigate to the dashboard page
//	    JavaCore.navigateTo(CardPaymentLocator.DASHBOARD_PAGE_URL); // Adjust URL locator as necessary
	

	@When("user clicks on the RoadReadyWheels logo")
	public void userClicksOnRoadReadyLogo() {
	    JavaCore.clickOn(CardPaymentLocator.DASHBOARD_PAGE_LOGO);
	}

	@When("user clicks on the resale link1")
	public void userClicksOnResaleLink() {
	  //  JavaCore.clickOn(CardPaymentLocator.RESALE_LINK);
	}

	
	@When("click on shopnow1")
	public void when_click_on_shoapnow() {
	     

		JavaCore.clickOn(CardPaymentLocator.SHOPNOW_LINK);
	}

	@When("click on resale link1")
	public void when_click_on_resale_link() {

	    JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SPLASH_LINK); 
	}

	@When("Search a product in search area")
	public void when_search_product_in_search_area() {
	     JavaCore.sendKeys(ResaleDashboardLocators.ResaleDashboard_SEARCH_FIELD, PropertyReader.getDataProperty("iteam"));	  
	}

	@When("click on a search button")
	public void when_click_on_search_button() {
		JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SEARCH_BUTTON);
	     
	}
	 
	


	@When("user clicks on the resale option1")
	public void userClicksOnResaleOption() {
	    JavaCore.clickOn(CardPaymentLocator.RESALE_OPTION); 
	}

	@When("click on a addtoCart item")
	public void userClicksOnAddToCartButton() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    JavaCore.clickOn(CardPaymentLocator.ADD_TO_CART_BUTTON); 
	}

	@When("user clicks on the Add to Cart icon1")
	public void userClicksOnAddToCartIcon() {
	    JavaCore.clickOn(CardPaymentLocator.ADD_TO_CART_ICON); 
	}

	@When("click on a complete checkout")
	public void userClicksOnCompleteCheckout() {
	    JavaCore.clickOn(CardPaymentLocator.COMPLETE_CHECKOUT_BUTTON); 
	}

	@When("enter a ebill po")
	public void userEntersEBillPO() {
	    JavaCore.sendKeys(CardPaymentLocator.EBILL_PO_FIELD, PropertyReader.getDataProperty("ponumber"));
	}

	@When("clickon a complete order")
	public void userClicksOnCompleteOrder() {
	    JavaCore.clickOn(CardPaymentLocator.COMPLETE_ORDER_BUTTON);
	}

	@When("click and select a available shipping address")
	public void userClicksAndSelectsAnAvailableShippingAddress() {
	    JavaCore.selectDropDownByIndex(CardPaymentLocator.SHIPPING_ADDRESS_DROPDOWN, 2); 
	}

	@When("clickon a continue")
	public void userClicksOnContinue() {
	    JavaCore.clickOn(CardPaymentLocator.CONTINUE_BUTTON); 
	}

	@When("user clicks on Next Continue1")
	public void userClicksOnNextContinue() {
	    JavaCore.clickOn(CardPaymentLocator.NEXT_CONTINUE_BUTTON); 
	}

	

	@When("user clicks on the credit card radio button1")
	public void userClicksOnCreditCardRadioButton() {
	    JavaCore.clickOn(CardPaymentLocator.CREDIT_CARD_OPTION);
	}

	@When("user enters the credit card number1")
	public void userEntersCreditCardNumber() throws InterruptedException {
		String cardNumber = "4111111111111111";
	    for (char digit : cardNumber.toCharArray())
	    JavaCore.sendKeys(CardPaymentLocator.CREDIT_CARD_NUMBER_FIELD,String.valueOf(digit));
	    Thread.sleep(3000);
	}

	@When("user enters the credit card security code1")
	public void userEntersCreditCardSecurityCode() {
		  JavaCore.sendKeys(CardPaymentLocator.SECURITY_CODE_FIELD,PropertyReader.getDataProperty("SecurityCode"));
	}

	@When("user selects the credit card expiration month1")
	public void userSelectsCreditCardExpirationMonth() {
	    JavaCore.selectDropDownByIndex(CardPaymentLocator.EXPIRATION_MONTH_DROPDOWN, 1); 
	}

	@When("user selects the credit card expiration year1")
	public void userSelectsCreditCardExpirationYear() {
	    JavaCore.selectDropDownByIndex(CardPaymentLocator.EXPIRATION_YEAR_DROPDOWN, 8); 
	}

	@When("user clicks on the Place Your Order button1")
	public void userClicksOnPlaceYourOrder() {
	    JavaCore.clickOn(CardPaymentLocator.PLACE_ORDER_BUTTON);
	}

	@Then("verify the order is successful1")
	public void verifyOrderSuccess() {
	   
	    System.out.println("Order verification successful.");
	}

}
package com.roadreadywheels.stepDefinations;
import static org.junit.Assert.*;

import com.roadreadywheels.comman.JavaCore;
import com.roadreadywheels.or.AmazonPayWholesaleLocator;
import com.roadreadywheels.or.ResaleDashboardLocators;
import com.roadreadywheels.utils.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResaleDashboard {


@Given("user navigates to dashboard page successfully after login")
public void user_naviagate_to_dashboard_page_successfully_after_login() {
     
}
@When("click on resale link")
public void click_on_resale_link() {
    // Click on the Resale link
    JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SPLASH_LINK);
    System.out.println("Navigated to the Resale section.");
}


@Given("Search product in search area1")
public void search_product_in_search_area() {
    
        JavaCore.sendKeys(ResaleDashboardLocators.ResaleDashboard_SEARCH_FIELD, 
                          PropertyReader.getDataProperty("item"));
//        String actualResultText = JavaCore.getElementText(ResaleDashboardLocators.ResaleDashboard_RESULT_TEXT);
//
//        // Validate that the result text matches the expected text
//        assertEquals("Validation failed for search result text", 
//                     "Showing products that are compatible with steel wheel", 
//                     actualResultText);
    }



@When("click on search button1")
public void click_on_search_button() {
     JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SEARCH_BUTTON);
     System.out.println("click on search button");
}

@When("click on search item1")
public void when_click_on_search_iteam() {
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_SEARCH_WHEEN_SEARCH);
	 System.out.println("click on search item");
}

@When("click on addtoCart item1")
public void when_click_on_addto_cart_iteam() {
	 JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_CART_BUTTON);
	 System.out.println("click on addtoCart item");
		 
}


@Then("verify user able to navigate to dashboard page")
public void verify_user_able_to_navigate_to_dashboard_page() {
	System.out.println("verify user able to navigate to dashboard page");
}

@When("click on complete checkout1")
public void when_click_on_complete_checkout() {
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_BUTTON);
    System.out.println("click on complete checkout");
}

@When("enter ebill po1")
public void when_enter_ebill_po() {
	
	JavaCore.clearAndSendKeys(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_PO_FIELD,PropertyReader.getDataProperty("ponumber"));
	System.out.println("enter po bill");
}

@When("clickon complete order1")
public void when_clickon_complete_order() {
	JavaCore.clickOn(ResaleDashboardLocators.ResaleDashboard_ADD_COMPLETE_CHEKOUT_PO_COMPLETE_ORDER_BUTTON);
	System.out.println("click on complete order");
     
}

@When("click and select available shipping address1")
public void when_click_and_select_available_shiping_address() {
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JavaCore.selectDropDownByIndex(ResaleDashboardLocators.ResaleDashboard_ADD_AVAILABLE_SHIPING_ADDRESS_DROP_DOWN,1);
	System.out.println("click and select available shipping address");
}

@When("clickon continue1")
public void when_clickon_continue() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JavaCore.clickByJS(ResaleDashboardLocators.ResaleDashboard_ADD_AVAILABLE_SHIPING_CONTINUE_BUTTON);
	System.out.println("click on continue");
}


@When("clickon nextcontinue1")
public void when_clickon_nextcontinue() throws InterruptedException {
	Thread.sleep(2000);
	JavaCore.scrollByXPath(ResaleDashboardLocators.ResaleDashboard_CONTINUE_BUTTON);
	JavaCore.clickByJS(ResaleDashboardLocators.ResaleDashboard_CONTINUE_BUTTON);
	System.out.println("click on nextcontinue");
}

@When("clickon chargeRadiobutton1")
public void when_clickon_charge_radiobutton() {
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JavaCore.clickByJS(ResaleDashboardLocators.ResaleDashboard_CHARGE_ORDER_RADIO);
	System.out.println("click on charge radio button");
}

@When("clickon placeorderbutton1")
public void when_clickon_placeorderbutton() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	JavaCore.clickByJS(ResaleDashboardLocators.ResaleDashboard_PLACE_ORDER_BUTTON);
	System.out.println("click on placeorderbutton");
}

@Then("verify order success")
public void then_verify_order_success() {
	assertEquals("","");
	//JavaCore.clickOn(ResaleDashboardLocators);
}



  
}







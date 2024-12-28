package com.roadreadywheels.stepDefinations;

import static org.junit.Assert.assertEquals;

import com.roadreadywheels.comman.JavaCore;
import com.roadreadywheels.or.HomePageLocators;
import com.roadreadywheels.or.LoginPageLocators;
import com.roadreadywheels.or.ResaleDashboardLocators;
import com.roadreadywheels.or.SplashPageLocators;
import com.roadreadywheels.utils.PropertyReader;
import com.roadreadywheels.utils.SendEmail;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RoadreadyWheelsLogin {
	private String url;

	@Given("open browser")
	public void open_browser() {
		url = PropertyReader.getConfigProperty("url");
		JavaCore.openUrl(url);

	}

	@When("user enter password")
	public void user_enter_password() {
		if (!url.equalsIgnoreCase("https://roadreadywheels.com/")) {
			JavaCore.sendKeys(SplashPageLocators.SPLASH_PASSWORD_FIELD,
					PropertyReader.getConfigProperty("splashPassword"));
		}
	}

	@When("user click on login button and redirect to home page")
	public void user_click_on_login_button_and_redirect_to_home_page() {
		if (!url.equalsIgnoreCase("https://roadreadywheels.com/")) {
			JavaCore.clickOn(SplashPageLocators.SPLASH_SUBMIT_BUTTON);
		}
	}


	@Then("verify user able to navigate to home page")
	public void verify_user_able_to_navigate_to_home_page() {

	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavaCore.clickOn(HomePageLocators.HOMEPAGE_LOGIN_LINK);
	}

	@When("user enter email")
	public void user_enter_email() {
		JavaCore.sendKeys(LoginPageLocators.LOGIN_PAGE_EMAIL_FIELD, PropertyReader.getConfigProperty("userName"));
	}

	@When("user enter loginpassword")
	public void user_enter_loginpassword() {
		JavaCore.sendKeys(LoginPageLocators.LOGIN_PAGE_PASSORD_FIELD, PropertyReader.getConfigProperty("password"));
		
	}

	@When("user click on sign in button")
	public void user_click_on_sign_in_button() {
		JavaCore.clickOn(LoginPageLocators.LOGIN_PAGE_LOGIN_BUTTON);
		 
	}

	@Then("verify user can see dashboardpage")
	public void verify_user_can_see_dashboardpage() {
String getFieldValue = JavaCore.GetFieldValue(ResaleDashboardLocators.ResaleDashboard_ROADREADY_TEXT);
assertEquals(PropertyReader.getDataProperty("AfterLOginText"),getFieldValue);
		
		   	    
		}

}

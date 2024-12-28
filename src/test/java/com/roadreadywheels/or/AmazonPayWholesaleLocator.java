package com.roadreadywheels.or;

public interface AmazonPayWholesaleLocator {
	 static final String WHOLESALE_OPTION ="//*[@id='select-user-role-modal']/div/div/div/div/div[1]/a[1]";
	 static final String WHOLESALE_SEARCH="//span[@title='Road Ready Aluminum Trailer Wheel 16x7 6-139.7mm Load 3200']";
	 static final String WHOLESALE_QUANTITY_DROPDOWN ="//div[@class='display-block']//select[@id='quantity']";
	 static final String WHOLESALE_AMAZONPAYMENT_BUTTON_CLICK="//*[@id='OffAmazonPaymentsWidgets0']";
	 static final String WHOLESALE_AMAZONPAYMENT_EMAIL_ENTER="//*[@id='ap_email']";
	 static final String WHOLESALE_AMAZONPAYMENT_PASSWORD_ENTER="//*[@id='ap_password']";
	 static final String WHOLESALE_AMAZONPAYMENT_SIGNIN_BUTTON="//*[@id='signInSubmit']";
	 static final String WHOLESALE_AMAZONPAYMENT_SHIPPING_CONTINUE="//input[@id='continue-amazon-delivery']";
	 static final String WHOLESALE_AMAZONPAYMENT_CONTINUE_PAYMENT_OPTION="//div[@class='col-md-12 col-12 amazon_buy']//a[@id='continue-amazon-delivery']";
	 static final String WHOLESALE_AMAZONPAYMENT_PLACEORDER="//header[@class='header']//div[@class='row']";
}

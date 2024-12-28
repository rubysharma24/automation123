package com.roadreadywheels.or;

public interface CardPaymentLocator {

    static final String DASHBOARD_PAGE_LOGO = "//div[@class='logo new_logo display-logo']//a[@href='/']";
    static final String SHOPNOW_LINK = "//*[@id='main-content']/div/span[2]"; 
    static final String RESALE_OPTION = "//div[@class='col-md-3 col-sm-3 col-xs-3 text-center br-1 loader-on-header']//a[@class='fa fa-truck big-icons resale-role cursor-pointer text-softred']";
   // static final String PRODUCT_ADD_BUTTON = "//button[@id='add-to-cart-button']"; 
    static final String ADD_TO_CART_BUTTON = "//div[@id='item_61']//div[@id='product_400']//button[@name='button'][normalize-space()='Add To Cart']"; 
    static final String ADD_TO_CART_ICON = "//span[@class='header-option fa fa-shopping-cart show-floating-cart']";
   
    static final String COMPLETE_CHECKOUT_BUTTON = "//*[@id='test-complete-checkout']"; 
    static final String EBILL_PO_FIELD = "//form[@class='po-form']//input[@id='po']"; 
    static final String COMPLETE_ORDER_BUTTON = "//button[normalize-space()='Complete Order']";
    static final String SHIPPING_ADDRESS_DROPDOWN = "//*[@id='shipping_address_id']"; 
    static final String CONTINUE_BUTTON = "//input[@class='float-right btn btn-lg btn-danger btn-darkred my-button btn-block-in-mobile address-submit-button landscape-width-12']"; 
	public static String NEXT_CONTINUE_BUTTON="//input[@id='test-continue']";

    static final String CREDIT_CARD_OPTION = "//input[@id='order_payments_attributes__payment_method_id_4']"; 
    static final String CREDIT_CARD_NUMBER_FIELD = "//input[@id='card_number']"; 
    static final String SECURITY_CODE_FIELD = "//input[@id='card_code']"; 
    static final String EXPIRATION_MONTH_DROPDOWN = "//select[@id='expiry_month']"; 
    static final String EXPIRATION_YEAR_DROPDOWN = "//select[@id='expiry_year']"; 
    static final String PLACE_ORDER_BUTTON = "//input[@id='test-place-your-order']"; 

   

	
}


	//public static String CardPayment_RADIO_Button="//input[@id='order_payments_attributes__payment_method_id_4']";
	
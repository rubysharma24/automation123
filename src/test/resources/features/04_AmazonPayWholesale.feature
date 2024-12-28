Feature: Verify amazon pay payment method with wholesale functionality.

  @amazonpayment
  Scenario: Handle Amazon Payment Option
    Given user navigate to Dashboard
    When user clicks on the next RoadReadyWheels logo
    And clicks on Shop Now button
    And navigates to the Wholesale section
    And searches for a product in the search area
    And clicks on the search button
    And click on search item field
    And clicks on the item quantity
    And adds the product to the cart
    And proceeds to complete the checkout process
    And enters a billing PO number
    And click on a complete order icon
    And selects Amazon Pay as the payment method
    And enter email in the email field
    And enter password in the password field
    And click on amazon sign-in button
    And selects an available shipping address
    And continues to the payment options page
    And places the order
    Then verifies that the order is successful using Amazon Pay

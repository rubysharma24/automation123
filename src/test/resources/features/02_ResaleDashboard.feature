Feature: Verify ResaleDashboard Shop Functionality

  @dashboard1
  Scenario: Handle Resale Dialog
    Given user navigates to dashboard page successfully after login
    When click on resale link
    Then verify user able to navigate to dashboard page

  @dashboard2
  Scenario: Handle Resale Shop
    Given Search product in search area1
    When click on search button1
    And click on search item1
    And click on addtoCart item1
    And click on complete checkout1
    And enter ebill po1
    And clickon complete order1
    And click and select available shipping address1
    And clickon continue1
    And clickon nextcontinue1
    #And clickon chargeRadiobutton1
    #And clickon placeorderbutton1
    #Then verify order success
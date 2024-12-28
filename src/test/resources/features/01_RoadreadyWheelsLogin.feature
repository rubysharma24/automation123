Feature: Verify Login Functionality

  @splash
  Scenario: Handle Splash Dialog With Login
    Given open browser
    When user enter password
    And user click on login button and redirect to home page
    Then verify user able to navigate to home page

  @login
  Scenario: User Login with Valid Credentials
    Given user click on login button
    When user enter email
    And user enter loginpassword
    And user click on sign in button
    Then verify user can see dashboardpage

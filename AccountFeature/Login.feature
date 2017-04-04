#Author: Vignesh.k
@tags
Feature: Login scenarios

  @Login
  Scenario: Entering valid username and password and login
    Given User is in homepage
    When User able to click Login button
    And User enter valid username and valid password
    And Click Login button
    Then verify user Logged in successfully

  @Logout
  Scenario: User able to log out successfully
    Given User is already logged in
    When user click menu
    And click Log out button
    Then user should logged out successfully

  @Invalidpassword
  Scenario: Verify user unable to login with invalid password
    Given User should be in makemytrip homepage
    When User click menu
    And User enters valid email id
    And User enters invalid password
    And User click continue
    Then Error message should be displayed for invalid password

  @InvalidEmailID
  Scenario: Verify user unable to login with invalid emailid
    Given User is in make my trip homepage
    When User click login menu
    And User enters invalid email
    And User enters valid password
    And User click login
    Then Error message should be displayed for invalid email id

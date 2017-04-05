#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Verify signup

  @Signup
  Scenario: Verify whether user able to sign up successfully
    Given User in MakeMyTrip homepage
    When User click Login button
    And click create new user link
    And User able to enter new email id
    And User able to new password
    And User enters confirm password
    And click i agree option.
    And click create account
    Then Verify user is signed in successfully

  @SignupError
  Scenario: Verify whether error message is displayed while invalid sign up
    Given User should in make my trip home page
    When User click login menu button
    And click create new user account
    And User enters invalid email id
    And User enters new password
    And User enters different password confirm password
    Then Error message should be displayed for password and confirm password doesn't match.
    
    @ForgotPasswordError
    Scenario: Verify error message is displayed while entering invalid email id in forgot password section
    Given User should be in dashboard
    When user click the menu button.
    And click forgot password link.
    And user enters a unregistered emailID in forgot password section.
    And click submit button.
    Then Error message should be displayed for unregistered email ID
    
    @ForgotPassword
    Scenario: Verify user can able to change password using forgot password option
    Given User is in MakeMyTrip Dashboard page.
    When user selects the my account menu button.
    And clicks ForgotPassword option in login section
    And enter the registered email id in email section.
    And user click submit.
    And user navigates to yopmail.
    And user enters the email id in the email textbox
    And user click check for inbox option
    And user click check for new mail button
    And user clicks the password change request link in the inbox
    And user navigate back to MakeMytrip support page.
    And user enter new password in choose a password textbox
    And user enters confirm password in retype password textbox
    Then user click submit button for changing the password
    
    @ResetPasswordAndLogin
    Scenario: Verify user can able to change password using forgot password option and able to login with new password
    Given User should be in MakeMyTrip dashboard
    When user clicks my account menu.
    And user click forgot link in my account menu.
    And user enters registered mail in forgot password section.
    And click submit button in forgot password section
    And user navigate to yopmail dashboard
    And user enters email in the textbox 
    And user select check for inbox button
    And user click new mail button
    And user click the link in the message
    And user will be navigating to MakeMyTrip support page
    And user enters new password in the password textbox
    And user enters retype password in next textbox
    And user click submit option to change the password
    And Enter EmailAddress in the textbox
    And Enter the changed password in the textbox.
    And click login button for the new password 
    Then verify user logged in successfully using new password 

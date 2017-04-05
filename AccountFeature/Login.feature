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
    
    @ChangePassword
    Scenario: Verify user able to change the password using my profile 
    Given user should be in MakeMyTrip dashboard
    And user should be already logged in.
    When user selects MyProfile link from menu.
    And user selects My setting option
    And user enters old password 
    And user enters new password
    And user enters reconfirmed password
    And user click password submit button
    Then Password message message should be displayed 
    
    @InvalidCurrentPassword
    Scenario: Verify Error message is displayed while entering the current password in change password section
    Given user should be in dashboard page
    And user should logged into the makemytrip website
    When user selects My profile option.
    And user clicks the settings option in profile section.
    And user enters incorrect current password
    And user enters new password in the new password textbox
    And user enters reconfirm password in reconfirm textbox
    And user click submit
    Then error message should be displayed for incoorect current password

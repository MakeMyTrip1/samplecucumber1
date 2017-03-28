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
@tags
Feature: User able to enter valid credential and login successfully

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

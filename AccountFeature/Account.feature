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

  @tag1
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

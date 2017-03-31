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
Feature: Domestic Flight Search

  Scenario: Verify user able to search for domestic flight
    Given User is in Homepage and Logged in
    When user selects one way trip
    And user enter Departure city and Destination city
    And user enter Departure date and click search flight
    Then list of Domestic flights should be displayed for the mentioned criteria.

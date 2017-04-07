#Author: Vignesh.k
@tag
Feature: Selecting filters for flights

  @NoOfStops
  Scenario: Verify user able to selects no of stops filter
    Given User is in homepage
    When User selects one way trip
    And user enters from city and to city
    And user enters from date
    And click search flight
    Then List of flights should be displayed
    And user selects no of stops filter

  @SelectDepartureTime
  Scenario: Verify user able to select departure time
    Given user should be in dashboard page.
    When User fills the mandatory search fields
    And clicks search
    Then Flight list should be displayed
    And should be able to select departure time from the fliters section

  @SelectAirlines
  Scenario: Verify user able to select particular airlines to travel
    Given user is in dashboard
    When user enters neccessary details in the dashboard page for searching flight and click search
    Then Available flights will be displayed
    And should be able to select particular airlines to travel.

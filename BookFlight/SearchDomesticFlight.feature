#Author: Vignesh.k
Feature: Domestic Flight Search

  Scenario: Verify user able to search for domestic flight
    Given User is in Homepage and Logged in
    When user selects one way trip
    And user enter Departure city and Destination city
    And user enter Departure date and click search flight
    Then list of Domestic flights should be displayed for the mentioned criteria.
    
    @DomesticFlightSearchRoundTrip
    Scenario: Verify user able to search for domestic flight round trip
    Given User is in makemytrip homepage
    When user selects round trip
    And user enters Dep city and Dest city
    And user enter dep date and return date
    And click search flight link
    Then list of flights is displayed for round trip

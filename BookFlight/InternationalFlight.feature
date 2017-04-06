#Author: Vignesh.k
@tag
Feature: International flight booking

  @SearchInternationalflightOnewayTrip
  Scenario: Verify user able to able search for one way international flight
    Given User should be in homepage.
    And selects one way trip
    When user enters departure city and destination city
    And user enters departure date
    And click search flight button
    Then list of International flights should be displayed for one way
    
    @SearchInternationalFlightRoundTrip
    Scenario: Verify user able to search for round trip international flight
    Given User should be makemytrip homepage
    And select round trip
    When user enters dep city and dest city
    And user enters dep date and return date
    And clicks search button
    Then list of Intertnational flight should be displayed for round trip
    

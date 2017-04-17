#Author: Vignesh.k
@tag
Feature: Hotel and room select

Background:
Given user is in hotels dashboard page
When user enters either domestic or international city
And user selects the in and out date and click search


Scenario: Verify user able to select a particular hotel
And list of hotels is displayed 
Then user selects a particular hotel


Scenario: Verify user able to select a particular room in a hotel.
And list of hotels will be displayed and user selects particular hotel.
Then user selects particular room  
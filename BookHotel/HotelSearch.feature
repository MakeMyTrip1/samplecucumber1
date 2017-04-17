#Author: Vignesh.k
@tag
Feature: Hotel Search

@DomesticHotelSearch
Scenario: Verify user able to search for domestic hotel
Given User is in makemytrip hotel page
When user enter city
And enters checkin and check out date
And click Search hotel link
Then list of domestic hotel should be displayed

@InternationalHotelSearch
Scenario: Verify user able to search for international hotel
Given User is in makemytrip hotels homepage
When user enters the international city
And Enters international checkin and checkout date
And user select search hotel link
Then list of international hotels should be displayed.

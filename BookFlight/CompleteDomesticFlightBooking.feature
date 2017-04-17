#Author: Vignesh.k
@tag
Feature: Complete Booking for domestic flight

@DomesticOneWayCompleteBooking
Scenario: Verify user able to complete the booking for domestic flight one way trip
Given User is in MakeMyTrip page
When User clicks one way trip link
And enters from domestic city and to domestic city
And user enters the from date
And user click search for flights
And user selects book for a required flight
And user enters the detail about email id
And click continue as guest
And user enter first name, lastname and phone number.
Then booking has been completed

@DomesticRoundTripCompleteBooking
Scenario: Verify user able to complete the booking for domestic flight round trip
Given user should be in makemytrip page
When user selects round trip link
And user enters dep and dest city 
And user enters from and to date
And user select search flight button
And user selects book now option 
And user enter the email and continue as guest
And user enters name and number
Then user completed the booking.

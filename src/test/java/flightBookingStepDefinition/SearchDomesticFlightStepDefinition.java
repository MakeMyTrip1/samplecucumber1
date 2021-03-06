package flightBookingStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class SearchDomesticFlightStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights";

	@Given("^User is in Homepage and Logged in$")
	public void user_is_in_Homepage_and_Logged_in() throws Throwable {

		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}		 

	}

	@When("^user selects one way trip$")
	public void user_selects_one_way_trip() throws Throwable {

		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("one_way_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[1]");
		}

	}

	@When("^user enter Departure city and Destination city$")
	public void user_enter_Departure_city_and_Destination_city() throws Throwable {

		// Entering the departure city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='from_typeahead1']", "chennai");
			//driver.findElementByXPath("//input[@id='from_typeahead1']").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}
		else
		{
			enterById("hp-widget__sfrom", "chennai");
			Thread.sleep(2000);
		}

		//entering destination city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='to_typeahead1']", "delhi");
			//driver.findElementByXPath("//input[@id='to_typeahead1']").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}
		else
		{
			enterById("hp-widget__sTo", "delhi");
			//driver.findElementById("hp-widget__sTo").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}

	}

	@When("^user enter Departure date and click search flight$")
	public void user_enter_Departure_date_and_click_search_flight() throws Throwable {
		//entering Departure date
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("start_date_sec");
			clickByXpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
			clickByXpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
			clickByLink("23");
		}else
		{
			//departureDate();
			clickById("hp-widget__depart");
			clickByLink("27");		
		}

		//click search flight

	}

	@Then("^list of Domestic flights should be displayed for the mentioned criteria\\.$")
	public void list_of_Domestic_flights_should_be_displayed_for_the_mentioned_criteria() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}

		try {
			String actual="No. of Stops";
			String expected=driver.findElementByXPath("(//strong[@class='filters_subhead pull-left'])[1]").getText();
			Assert.assertEquals("list of light is displayed", expected, actual);
			APPLICATION_LOGS.debug("list of flight displayed");
		} catch (AssertionError error) {		
			APPLICATION_LOGS.debug("list of flights is not displayed");
			Assert.fail("list of flights is not displayed");
		}
		finally {
			driver.quit();
		}
	}

	@Given("^User is in makemytrip homepage$")
	public void user_is_in_makemytrip_homepage() throws Throwable {
		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	    
	}

	@When("^user selects round trip$")
	public void user_selects_round_trip() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
		APPLICATION_LOGS.debug("round trip selected");
	}

	@When("^user enters Dep city and Dest city$")
	public void user_enters_Dep_city_and_Dest_city() throws Throwable {
		// Entering the departure city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='from_typeahead1']", "chennai");
			driver.findElementByXPath("//input[@id='from_typeahead1']").sendKeys(Keys.TAB);
		}
		else
		{
			enterById("hp-widget__sfrom", "chennai");

		}

		//entering destination city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='to_typeahead1']", "delhi");
			driver.findElementByXPath("//input[@id='to_typeahead1']").sendKeys(Keys.TAB);
		}
		else
		{
			enterById("hp-widget__sTo", "delhi");
			driver.findElementById("hp-widget__sTo").sendKeys(Keys.TAB);
		}
		APPLICATION_LOGS.debug("dep city and dest city has been enterd");
	}

	@When("^user enter dep date and return date$")
	public void user_enter_dep_date_and_return_date() throws Throwable {

		//for entering dep date
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("start_date_sec");
			clickByXpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
			clickByXpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
			clickByLink("23");
		}else
		{
			//departureDate();
			clickById("hp-widget__depart");
			clickByLink("27");		
		}

		//for entering return date
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			driver.findElementById("return_date_sec").click();
			driver.findElementByXPath("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
			driver.findElementByXPath("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
			driver.findElementByLinkText("26").click();
		}else
		{
			clickById("hp-widget__return");
			clickByLink("28");
			//returnDate();
		}
		APPLICATION_LOGS.debug("dep date and return date has been entered");
	}

	@When("^click search flight link$")
	public void click_search_flight_link() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search has been clicked");
	}

	@Then("^list of flights is displayed for round trip$")
	public void list_of_flights_is_displayed_for_round_trip() throws Throwable {
		try {
			verifyTextByXpath("(//strong[@class='filters_subhead pull-left'])[1]", "No. of Stops");
			APPLICATION_LOGS.debug("list of flights has been displayed");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("flight list is not displayed");
		}
		finally {
			driver.quit();	
		}
		
	}
}

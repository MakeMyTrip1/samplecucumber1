package flightBookingStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class InternationalFlightStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights";

	@Given("^User should be in homepage\\.$")
	public void user_should_be_in_homepage() throws Throwable {
		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}		 
	}

	@Given("^selects one way trip$")
	public void selects_one_way_trip() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("one_way_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[1]");
		}
		APPLICATION_LOGS.debug("one way trip is selected");
	}

	@When("^user enters departure city and destination city$")
	public void user_enters_departure_city_and_destination_city() throws Throwable {

		// Entering the departure city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='from_typeahead1']", "Chennai");
			//driver.findElementByXPath("//input[@id='from_typeahead1']").sendKeys(Keys.TAB);
		}
		else
		{
			enterById("hp-widget__sfrom", "Chennai");
			//driver.findElementById("hp-widget__sfrom").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}

		//entering destination city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='to_typeahead1']", "Bangkok, Thailand (BKK)");
			//driver.findElementByXPath("//input[@id='to_typeahead1']").sendKeys(Keys.TAB);
		}
		else
		{
			enterById("hp-widget__sTo", "Bangkok, Thailand (BKK)");
			Thread.sleep(2000);
			//driver.findElementById("hp-widget__sTo").sendKeys(Keys.TAB);
		}
		APPLICATION_LOGS.debug("departure and destination city has been entered");		
	}

	@When("^user enters departure date$")
	public void user_enters_departure_date() throws Throwable {
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
		APPLICATION_LOGS.debug("departure date has been entered");
	}

	@When("^click search flight button$")
	public void click_search_flight_button() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search flight has been clicked");
	}

	@Then("^list of International flights should be displayed for one way$")
	public void list_of_International_flights_should_be_displayed_for_one_way() throws Throwable {
		try {
			verifyTextByXpath("(//p[@class='fli_filter__heading append_bottom9'])[1]", "Stops");
			APPLICATION_LOGS.debug("list of flights has been displayed");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("flight list is not displayed");
		}
		finally {
			driver.quit();	
		}    
	}

	@Given("^User should be makemytrip homepage$")
	public void user_should_be_makemytrip_homepage() throws Throwable {
		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	    
	}

	@Given("^select round trip$")
	public void select_round_trip() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
		APPLICATION_LOGS.debug("round trip selected");
	}

	@When("^user enters dep city and dest city$")
	public void user_enters_dep_city_and_dest_city() throws Throwable {
		// Entering the departure city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='from_typeahead1']", "Chennai (MAA)");
			//driver.findElementByXPath("//input[@id='from_typeahead1']").sendKeys(Keys.TAB);
		}
		else
		{
			enterById("hp-widget__sfrom", "Chennai (MAA)");
			Thread.sleep(2000);
		}

		//entering destination city
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			enterByXpath("//input[@id='to_typeahead1']", "Bangkok, Thailand (BKK)");
			//driver.findElementByXPath("//input[@id='to_typeahead1']").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}
		else
		{
			enterById("hp-widget__sTo", "Bangkok, Thailand (BKK)");
			//driver.findElementById("hp-widget__sTo").sendKeys(Keys.TAB);
			Thread.sleep(2000);
		}
		APPLICATION_LOGS.debug("dep city and dest city has been enterd");
	}

	@When("^user enters dep date and return date$")
	public void user_enters_dep_date_and_return_date() throws Throwable {
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

	@When("^clicks search button$")
	public void clicks_search_button() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search has been clicked");
	}

	@Then("^list of Intertnational flight should be displayed for round trip$")
	public void list_of_Intertnational_flight_should_be_displayed_for_round_trip() throws Throwable {
		try {
			verifyTextByXpath("(//p[@class='fli_filter__heading append_bottom9'])[1]", "Stops");
			APPLICATION_LOGS.debug("list of flights has been displayed");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("flight list is not displayed");
		}
		finally {
			driver.quit();	
		}
	}
}

package flightBookingStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class SelectFiltersStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights";

	@Given("^User is in homepage$")
	public void user_is_in_homepage() throws Throwable {
		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}
	}

	@When("^User selects one way trip$")
	public void user_selects_one_way_trip() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
		APPLICATION_LOGS.debug("round trip selected");
	}

	@When("^user enters from city and to city$")
	public void user_enters_from_city_and_to_city() throws Throwable {
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

	@When("^user enters from date$")
	public void user_enters_from_date() throws Throwable {
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
		APPLICATION_LOGS.debug("dep date has been entered");
	}

	@When("^click search flight$")
	public void click_search_flight() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search has been clicked");
	}

	@Then("^List of flights should be displayed$")
	public void list_of_flights_should_be_displayed() throws Throwable {
		verifyTextByXpath("(//strong[@class='filters_subhead pull-left'])[1]", "No. of Stops");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("list of flights has been displayed");
	}

	@Then("^user selects no of stops filter$")
	public void user_selects_no_of_stops_filter() throws Throwable {
		clickByClassName("stop_text_stops");
		driver.quit();
	}
	
	
	@Given("^user should be in dashboard page\\.$")
	public void user_should_be_in_dashboard_page() throws Throwable {
		invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	    
	}

	@When("^User fills the mandatory search fields$")
	public void user_fills_the_mandatory_search_fields() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
		APPLICATION_LOGS.debug("round trip selected");
		
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
				APPLICATION_LOGS.debug("dep date has been entered");	    
	}

	@When("^clicks search$")
	public void clicks_search() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search has been clicked");	    
	}

	@Then("^Flight list should be displayed$")
	public void flight_list_should_be_displayed() throws Throwable {
		verifyTextByXpath("(//strong[@class='filters_subhead pull-left'])[1]", "No. of Stops");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("list of flights has been displayed");	    
	}

	@Then("^should be able to select departure time from the fliters section$")
	public void should_be_able_to_select_departure_time_from_the_fliters_section() throws Throwable {
		clickById("buckets_night_dep");
	    APPLICATION_LOGS.debug("");
	    driver.quit();
	}
	
	
	@Given("^user is in dashboard$")
	public void user_is_in_dashboard() throws Throwable {
	    invokeApp("chrome", url, false);	

		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	    
	}

	@When("^user enters neccessary details in the dashboard page for searching flight and click search$")
	public void user_enters_neccessary_details_in_the_dashboard_page_for_searching_flight_and_click_search() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
		APPLICATION_LOGS.debug("round trip selected");
		
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
				APPLICATION_LOGS.debug("dep date has been entered");
				if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
					clickById("flights_submit");
					Thread.sleep(3000);
				}else{

					clickById("searchBtn");
					Thread.sleep(3000);
				}
				APPLICATION_LOGS.debug("search has been clicked");	 
	}

	@Then("^Available flights will be displayed$")
	public void available_flights_will_be_displayed() throws Throwable {
		verifyTextByXpath("(//strong[@class='filters_subhead pull-left'])[1]", "No. of Stops");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("list of flights has been displayed");	    
	}

	@Then("^should be able to select particular airlines to travel\\.$")
	public void should_be_able_to_select_particular_airlines_to_travel() throws Throwable {
		clickById("aln_6E_dep");
	    APPLICATION_LOGS.debug("Particular airlines has been selected");
	    driver.quit();
	}



}

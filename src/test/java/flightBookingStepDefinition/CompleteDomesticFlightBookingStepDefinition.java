package flightBookingStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.*;
import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class CompleteDomesticFlightBookingStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights";

	@Before
	public void intialise()
	{
		invokeApp("chrome", url, false);
	}

	@After
	public void flush()
	{
		driver.quit();
	}



	@Given("^User is in MakeMyTrip page$")
	public void user_is_in_MakeMyTrip_page() throws Throwable {
		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	   
	}

	@When("^User clicks one way trip link$")
	public void user_clicks_one_way_trip_link() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("one_way_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[1]");
		}
		APPLICATION_LOGS.debug("one way trip has been selected");
	}

	@When("^enters from domestic city and to domestic city$")
	public void enters_from_domestic_city_and_to_domestic_city() throws Throwable {
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

	@When("^user enters the from date$")
	public void user_enters_the_from_date() throws Throwable {
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

	@When("^user click search for flights$")
	public void user_click_search_for_flights() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		verifyTextByXpath("(//strong[@class='filters_subhead pull-left'])[1]", "No. of Stops");
		APPLICATION_LOGS.debug("list of flights has been displayed");
	}

	@When("^user selects book for a required flight$")
	public void user_selects_book_for_a_required_flight() throws Throwable {
		clickByLink("Book");
	}

	@When("^user enters the detail about email id$")
	public void user_enters_the_detail_about_email_id() throws Throwable {
		enterByXpath("//div[@class='col-lg-4 col-md-5 col-sm-6 col-xs-8']/input", "aaavig@yopmail.com");
		driver.findElementByXPath("//div[@class='col-lg-4 col-md-5 col-sm-6 col-xs-8']/input").sendKeys(Keys.TAB);
	}

	@When("^click continue as guest$")
	public void click_continue_as_guest() throws Throwable {
		Thread.sleep(4000);
		driver.findElement(By.linkText("Continue as Guest")).click();
		Thread.sleep(2000);
	}

	@When("^user enter first name, lastname and phone number\\.$")
	public void user_enter_first_name_lastname_and_phone_number() throws Throwable {
		enterByXpath("//span[@class='first_name col-lg-5 col-md-5 col-sm-4 col-xs-12']/input", "aaa");
		enterByXpath("//span[@class='last_name col-lg-5 col-md-5 col-sm-4 col-xs-12 row']/input", "vig");
		clickByLink("MALE");
		enterByXpath("//span[@class='pull-left col-lg-6 col-md-6 col-sm-7 col-xs-8 row phone_number phone_number_row']/input", "1245127589");
		APPLICATION_LOGS.debug("details have been entered");
	}

	@Then("^booking has been completed$")
	public void booking_has_been_completed() throws Throwable {
		APPLICATION_LOGS.debug("booking has been completed");
	}


	@Given("^user should be in makemytrip page$")
	public void user_should_be_in_makemytrip_page() throws Throwable {
		if(!verifyTitle("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			if(!verifyTitle("Cheap Air Tickets, Flight Ticket Booking of Domestic Flights at Lowest Airfare: MakeMyTrip")){
				if(!verifyTitle("Book Cheap Flights Ticket Online, Lowest Air Fares Get Upto 800 OFF with Makemytrip.com")){
					Assert.fail("this is not homepage");
				}
			}
		}	   
	}

	@When("^user selects round trip link$")
	public void user_selects_round_trip_link() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("round_trip_button1");
		}else
		{
			clickByXpath("//div[@id='js-switch__option']/div[2]");
		}
	}

	@When("^user enters dep and dest city$")
	public void user_enters_dep_and_dest_city() throws Throwable {
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

	@When("^user enters from and to date$")
	public void user_enters_from_and_to_date() throws Throwable {
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

	@When("^user select search flight button$")
	public void user_select_search_flight_button() throws Throwable {
		if(driver.getTitle().equalsIgnoreCase("Cheap Flight Ticket Booking Online, Lowest Domestic Air Fares @ 800/- off")){
			clickById("flights_submit");
			Thread.sleep(3000);
		}else{

			clickById("searchBtn");
			Thread.sleep(3000);
		}
		APPLICATION_LOGS.debug("search has been clicked");
	}

	@When("^user selects book now option$")
	public void user_selects_book_now_option() throws Throwable {
		clickByLink("Book");
		APPLICATION_LOGS.debug("book now has been clicked");
	}

	@When("^user enter the email and continue as guest$")
	public void user_enter_the_email_and_continue_as_guest() throws Throwable {
		enterByXpath("//div[@class='col-lg-4 col-md-5 col-sm-6 col-xs-8']/input", "aaavig@yopmail.com");
		driver.findElementByXPath("//div[@class='col-lg-4 col-md-5 col-sm-6 col-xs-8']/input").sendKeys(Keys.TAB);
		Thread.sleep(4000);
		driver.findElement(By.linkText("Continue as Guest")).click();
		Thread.sleep(2000);
	}

	@When("^user enters name and number$")
	public void user_enters_name_and_number() throws Throwable {
		enterByXpath("//span[@class='first_name col-lg-5 col-md-5 col-sm-4 col-xs-12']/input", "aaa");
		enterByXpath("//span[@class='last_name col-lg-5 col-md-5 col-sm-4 col-xs-12 row']/input", "vig");
		clickByLink("MALE");
		enterByXpath("//span[@class='pull-left col-lg-6 col-md-6 col-sm-7 col-xs-8 row phone_number phone_number_row']/input", "1245127589");
		APPLICATION_LOGS.debug("details have been entered");
	}
	
	@Then("^user completed the booking\\.$")
	public void user_completed_the_booking() throws Throwable {
	    APPLICATION_LOGS.debug("booking has been completed");
	}

}

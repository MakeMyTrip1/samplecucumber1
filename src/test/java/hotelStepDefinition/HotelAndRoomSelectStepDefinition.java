package hotelStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class HotelAndRoomSelectStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/hotels";

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

	@Given("^user is in hotels dashboard page$")
	public void user_is_in_hotels_dashboard_page() throws Throwable {
		if(!verifyTitle("Book from Cheap Hotels to Luxury Hotels Online & Get Upto 70% Off")){
			Assert.fail("This is not flight homepage");
		}
	}

	@When("^user enters either domestic or international city$")
	public void user_enters_either_domestic_or_international_city() throws Throwable {
		driver.findElementById("hp-widget__sDest").click();
		enterById("hp-widget__sDest", "New Delhi");
		Thread.sleep(4000);
		driver.findElementById("hp-widget__sDest").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("City has been entered");
	}

	@When("^user selects the in and out date and click search$")
	public void user_selects_the_in_and_out_date_and_click_search() throws Throwable {
		//check in date
		driver.findElementByXPath("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
		driver.findElementByLinkText("10").click();
		Thread.sleep(2000);

		//checkout date
		driver.findElementByLinkText("28").click();

		APPLICATION_LOGS.debug("check in and check out date has been entered");
		
		clickById("searchBtn");
		APPLICATION_LOGS.debug("Search button has been clicked");
	}

	@When("^list of hotels is displayed$")
	public void list_of_hotels_is_displayed() throws Throwable {
		verifyTextByXpath("(//span[@class='o-f-label'])[1]", "Location");
		APPLICATION_LOGS.debug("list of domestic hotel is displayed");
	}

	@Then("^user selects a particular hotel$")
	public void user_selects_a_particular_hotel() throws Throwable {
		clickByXpathNoSnap("(//div[@class='card__BArea'])[1]");
		switchToLastWindow();
		
		if(!verifyURL("hotelz.makemytrip.com")){
			if (!verifyURL("www.makemytrip.com/mmthtl")){
				Assert.fail("This is not hotels details page");	
			}
		}	
	}

	@When("^list of hotels will be displayed and user selects particular hotel\\.$")
	public void list_of_hotels_will_be_displayed_and_user_selects_particular_hotel() throws Throwable {
		verifyTextByXpath("(//span[@class='o-f-label'])[1]", "Location");
		APPLICATION_LOGS.debug("list of domestic hotel is displayed");
		
		clickByXpathNoSnap("(//div[@class='card__BArea'])[1]");
		switchToLastWindow();
		
		if(!verifyURL("hotelz.makemytrip.com")){
			if (!verifyURL("www.makemytrip.com/mmthtl")){
				Assert.fail("This is not hotels details page");	
			}
		}
	}

	@Then("^user selects particular room$")
	public void user_selects_particular_room() throws Throwable {
		try {
			clickByLink("SELECT ROOM");				
		} catch (Exception e) {				
			clickByLink("Select Room");
		}
		
		Thread.sleep(2000);
		clickById("details-select-book1");
		verifyTextByXpath("//li[@class='ch-flL active ch-width166']", "review hotel & room");
	}

}

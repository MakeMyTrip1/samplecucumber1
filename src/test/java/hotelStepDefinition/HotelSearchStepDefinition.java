package hotelStepDefinition;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.preventers.AppContextLeakPreventer;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class HotelSearchStepDefinition extends GenericWrappers{

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

	@Given("^User is in makemytrip hotel page$")
	public void user_is_in_makemytrip_hotel_page() throws Throwable {
		if(!verifyTitle("Book from Cheap Hotels to Luxury Hotels Online & Get Upto 70% Off")){
			Assert.fail("This is not flight homepage");
		}
	}

	@When("^user enter city$")
	public void user_enter_city() throws Throwable {
		driver.findElementById("hp-widget__sDest").click();
		enterById("hp-widget__sDest", "New Delhi");
		Thread.sleep(4000);
		driver.findElementById("hp-widget__sDest").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("City has been entered");
	}

	@When("^enters checkin and check out date$")
	public void enters_checkin_and_check_out_date() throws Throwable {

		//check in date
		driver.findElementByXPath("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
		driver.findElementByLinkText("10").click();
		Thread.sleep(2000);

		//checkout date
		driver.findElementByLinkText("28").click();

		APPLICATION_LOGS.debug("check in and check out date has been entered");
	}

	@When("^click Search hotel link$")
	public void click_Search_hotel_link() throws Throwable {
		clickById("searchBtn");
		APPLICATION_LOGS.debug("Search button has been clicked");
	}

	@Then("^list of domestic hotel should be displayed$")
	public void list_of_domestic_hotel_should_be_displayed() throws Throwable {
		verifyTextByXpath("(//span[@class='o-f-label'])[1]", "Location");
		APPLICATION_LOGS.debug("list of domestic hotel is displayed");
	}


	@Given("^User is in makemytrip hotels homepage$")
	public void user_is_in_makemytrip_hotels_homepage() throws Throwable {
		if(!verifyTitle("Book from Cheap Hotels to Luxury Hotels Online & Get Upto 70% Off")){
			Assert.fail("This is not flight homepage");
		}
	}

	@When("^user enters the international city$")
	public void user_enters_the_international_city() throws Throwable {
		driver.findElementById("hp-widget__sDest").click();
		enterById("hp-widget__sDest", "New york");
		Thread.sleep(4000);
		driver.findElementById("hp-widget__sDest").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("City has been entered");
	}

	@When("^Enters international checkin and checkout date$")
	public void enters_international_checkin_and_checkout_date() throws Throwable {
		//		driver.findElementByXPath("//span[@class='ui-icon ui-icon-circle-triangle-e']").click();
		driver.findElementByLinkText("10").click();
		Thread.sleep(5000);

		//checkout date
		driver.findElementByLinkText("28").click();

		APPLICATION_LOGS.debug("check in and check out date has been entered");
	}

	@When("^user select search hotel link$")
	public void user_select_search_hotel_link() throws Throwable {
		clickById("searchBtn");
		APPLICATION_LOGS.debug("Search button has been clicked");
	}

	@Then("^list of international hotels should be displayed\\.$")
	public void list_of_international_hotels_should_be_displayed() throws Throwable {
		verifyTextByXpath("(//span[@class='o-f-label'])[1]", "Location");
		APPLICATION_LOGS.debug("list of domestic hotel is displayed");
	}

}

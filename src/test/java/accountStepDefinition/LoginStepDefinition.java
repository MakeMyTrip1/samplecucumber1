package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class LoginStepDefinition extends GenericWrappers{
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");
	
	String url="https://www.makemytrip.com/flights-hotels/";
	
	
	@Given("^User is in homepage$")
	public void user_is_in_homepage() throws Throwable {
		invokeApp("chrome",url, false);
		APPLICATION_LOGS.debug("user in homepage");    
	}

	@When("^User able to click Login button$")
	public void user_able_to_click_Login_button() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("user click login button");			  
	}

	@When("^User enter valid username and valid password$")
	public void user_enter_valid_username_and_valid_password() throws Throwable {
		
		enterById("username", "aavicky@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);	  
		enterById("password", "aavicky");
		driver.findElementById("password").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("user enters valid username and password");
	}

	@When("^Click Login button$")
	public void click_Login_button() throws Throwable {
	    APPLICATION_LOGS.debug("click Login");
	    clickByXpath("//input[@id='login_btn']");	    
	}

	@Then("^verify user Logged in successfully$")
	public void verify_user_Logged_in_successfully() throws Throwable {
		verifyTextByXpath("//span[@id='ssologinlink']/strong", "user");
		APPLICATION_LOGS.debug("Login successful");
		driver.quit();
	}
	
	
	@Given("^user should be in MakeMyTrip dashboard$")
	public void user_should_be_in_MakeMyTrip_dashboard() throws Throwable {
		invokeApp("chrome", url, false);
		if(!verifyTitle("Flights + Hotels - Book Flight & Hotel Deals at Discounted Prices | MakeMyTrip India")){
			Assert.fail("This is not dashboard page");
		}
		APPLICATION_LOGS.debug("user in homepage");	  	    
	}

	@Given("^user should be already logged in\\.$")
	public void user_should_be_already_logged_in() throws Throwable {
		clickById("ssologinlink");
		enterById("username", "aaavig@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);	  
		enterById("password", "aaavig");
		driver.findElementById("password").sendKeys(Keys.TAB);
		clickByXpath("//input[@id='login_btn']");
		APPLICATION_LOGS.debug("user enters valid username and password");
	}

	@When("^user selects MyProfile link from menu\\.$")
	public void user_selects_MyProfile_link_from_menu() throws Throwable {
		clickById("ssologinlink");
		clickByLink("My Profile");
		APPLICATION_LOGS.debug("My profile is selected");
		Thread.sleep(3000);
	}

	@When("^user selects My setting option$")
	public void user_selects_My_setting_option() throws Throwable {
		clickByLink("My Settings");
	    APPLICATION_LOGS.debug("My settings is selected");
	}

	@When("^user enters old password$")
	public void user_enters_old_password() throws Throwable {
		enterById("profile_settings_password_oldpass", "aaavig");
		driver.findElementById("profile_settings_password_oldpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("old password has been enetered");
	}

	@When("^user enters new password$")
	public void user_enters_new_password() throws Throwable {
		enterById("profile_settings_password_newpass", "aaavig");
		driver.findElementById("profile_settings_password_newpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("new password is entered");
	}

	@When("^user enters reconfirmed password$")
	public void user_enters_reconfirmed_password() throws Throwable {
		enterById("profile_settings_password_reconfirmnewpass", "aaavig");
		driver.findElementById("profile_settings_password_reconfirmnewpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("re confirm password is entered");
	}

	@When("^user click password submit button$")
	public void user_click_password_submit_button() throws Throwable {
		clickById("profile_settings_password_savebutton");
		Thread.sleep(5000);
	    APPLICATION_LOGS.debug("submit button is selected");
	}

	@Then("^Password message message should be displayed$")
	public void password_message_message_should_be_displayed() throws Throwable {
		verifyTextByXpath("//p[contains(text(), 'Your Password has been Changed.')]", " Your Password has been Changed.");
	    APPLICATION_LOGS.debug("password has been changed");
	    driver.quit();
	}
	

	@Given("^user should be in dashboard page$")
	public void user_should_be_in_dashboard_page() throws Throwable {
		invokeApp("chrome", url, false);
		if(!verifyTitle("Flights + Hotels - Book Flight & Hotel Deals at Discounted Prices | MakeMyTrip India")){
			Assert.fail("This is not dashboard page");
		}
		APPLICATION_LOGS.debug("user in homepage");	  		    
	}

	@Given("^user should logged into the makemytrip website$")
	public void user_should_logged_into_the_makemytrip_website() throws Throwable {
		clickById("ssologinlink");
		enterById("username", "aaavig@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);	  
		enterById("password", "aaavig");
		driver.findElementById("password").sendKeys(Keys.TAB);
		clickByXpath("//input[@id='login_btn']");
		APPLICATION_LOGS.debug("user enters valid username and password");	    
	}

	@When("^user selects My profile option\\.$")
	public void user_selects_My_profile_option() throws Throwable {
		clickById("ssologinlink");
		clickByLink("My Profile");
		APPLICATION_LOGS.debug("My profile is selected");
		Thread.sleep(3000);	    
	}

	@When("^user clicks the settings option in profile section\\.$")
	public void user_clicks_the_settings_option_in_profile_section() throws Throwable {
		clickByLink("My Settings");
	    APPLICATION_LOGS.debug("My settings is selected");	    
	}

	@When("^user enters incorrect current password$")
	public void user_enters_incorrect_current_password() throws Throwable {
		enterById("profile_settings_password_oldpass", "aaavig123");
		driver.findElementById("profile_settings_password_oldpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("old password has been enetered");	    
	}

	@When("^user enters new password in the new password textbox$")
	public void user_enters_new_password_in_the_new_password_textbox() throws Throwable {
		enterById("profile_settings_password_newpass", "aaavig");
		driver.findElementById("profile_settings_password_newpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("new password is entered");
	}

	@When("^user enters reconfirm password in reconfirm textbox$")
	public void user_enters_reconfirm_password_in_reconfirm_textbox() throws Throwable {
		enterById("profile_settings_password_reconfirmnewpass", "aaavig");
		driver.findElementById("profile_settings_password_reconfirmnewpass").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("re confirm password is entered");
	}

	@When("^user click submit$")
	public void user_click_submit() throws Throwable {
		clickById("profile_settings_password_savebutton");
		Thread.sleep(5000);
	    APPLICATION_LOGS.debug("submit button is selected");
	}

	@Then("^error message should be displayed for incoorect current password$")
	public void error_message_should_be_displayed_for_incoorect_current_password() throws Throwable {
		verifyTextByXpath("//div[contains(text(), 'The old Password is not correct')]", "The old Password is not correct");
	    APPLICATION_LOGS.debug("error message is displayed");
	    driver.quit();
	}
	
}

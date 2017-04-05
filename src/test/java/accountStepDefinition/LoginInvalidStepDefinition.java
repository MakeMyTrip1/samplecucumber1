package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class LoginInvalidStepDefinition extends GenericWrappers{
	
Logger APPLICATION_LOGS = Logger.getLogger("test");
	
	String url="https://www.makemytrip.com/flights-hotels/";

	@Given("^User should be in makemytrip homepage$")
	public void user_should_be_in_makemytrip_homepage() throws Throwable {
		invokeApp("chrome",url, false);
		APPLICATION_LOGS.debug("user in homepage");  	    
	}

	@When("^User click menu$")
	public void user_click_menu() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("user click login menu button");
	    
	}

	@When("^User enters valid email id$")
	public void user_enters_valid_email_id() throws Throwable {
		enterById("username", "aaavig@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("Valid Email id is entered");
	}

	@When("^User enters invalid password$")
	public void user_enters_invalid_password() throws Throwable {
		enterById("password", "aavicky");
		driver.findElementById("password").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("Invalid password is entered");
	}
	
	@When("^User click continue$")
	public void user_click_continue() throws Throwable {
		clickByXpath("//input[@id='login_btn']");
		APPLICATION_LOGS.debug("Login button is clicked");   
	}

	@Then("^Error message should be displayed for invalid password$")
	public void error_message_should_be_displayed_for_invalid_password() throws Throwable {
		String actual="The Password you entered is incorrect.(Passwords are case sensitive. Is your Caps Lock On? Please check and try again.)";
		verifyTextByXpath("(//span[@id='errormsg_password'])[3]", actual);
		driver.quit();
		/*try {
			String actual="The Password you entered is incorrect.(Passwords are case sensitive. Is your Caps Lock On? Please check and try again.)";
			String expected=driver.findElementByXPath("(//span[@id='errormsg_password'])[3]").getText();
			Assert.assertEquals("invalid password", expected, actual);
		} catch (AssertionError e) {
			APPLICATION_LOGS.debug("valid password");
			Assert.fail("valid password");
		}
	    finally {
			driver.quit();
		}*/
	}
	
	@Given("^User is in make my trip homepage$")
	public void user_is_in_make_my_trip_homepage() throws Throwable {
		invokeApp("chrome",url, false);
		APPLICATION_LOGS.debug("user in homepage"); 	    
	}

	@When("^User click login menu$")
	public void user_click_login_menu() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("user click login menu button");    
	}

	@When("^User enters invalid email$")
	public void user_enters_invalid_email() throws Throwable {
		enterById("username", "aaavig111@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("Invalid Email id is entered");
	    
	}

	@When("^User enters valid password$")
	public void user_enters_valid_password() throws Throwable {
		enterById("password", "aaavig");
		driver.findElementById("password").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("Valid password is entered");	    
	}

	@When("^User click login$")
	public void user_click_login() throws Throwable {
		clickByXpath("//input[@id='login_btn']");
		APPLICATION_LOGS.debug("Login button is clicked");	    
	}

	@Then("^Error message should be displayed for invalid email id$")
	public void error_message_should_be_displayed_for_invalid_email_id() throws Throwable {
		String actual="EMail-ID not registered. Please try a different ID.";
		verifyTextByXpath("(//span[@id='errormsg_password'])[5]", actual);
		driver.quit();
		/*try {
			String actual="EMail-ID not registered. Please try a different ID.";
			String expected=driver.findElementByXPath("(//span[@id='errormsg_password'])[5]").getText();
			Assert.assertEquals("invalid email id", expected, actual);
		} catch (AssertionError e) {
			APPLICATION_LOGS.debug("valid email id");
		}
	    finally {
			driver.quit();
		}*/   
	}
}

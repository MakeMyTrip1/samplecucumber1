package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class SignupErrorStepDefinition extends GenericWrappers{
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights-hotels/";

	@Given("^User should in make my trip home page$")
	public void user_should_in_make_my_trip_home_page() throws Throwable  {
		invokeApp("chrome",url, false);
		APPLICATION_LOGS.debug("user in homepage");	        
	}

	@When("^User click login menu button$")
	public void user_click_login_menu_button() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("Login button");    
	}
	
	@When("^click create new user account$")
	public void click_create_new_user_account() throws Throwable  {
		clickById("openNewUserDivlink");
		APPLICATION_LOGS.debug("Create new user");	    
	}

	@When("^User enters invalid email id$")
	public void user_enters_invalid_email_id() throws Throwable {
		enterById("newusername", "asdasd@yopmail.com");
		driver.findElementById("newusername").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("new email id");
	    
	}

	@When("^User enters new password$")
	public void user_enters_new_password() throws Throwable {
		enterById("newpassword", "aavicky");
		driver.findElementById("newpassword").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("new password");	    
	}

	@When("^User enters different password confirm password$")
	public void user_enters_different_password_confirm_password() throws Throwable {
		enterById("repassword", "aavicky1");
		driver.findElementById("repassword").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("confirm password");
	    
	}

	@Then("^Error message should be displayed for password and confirm password doesn't match\\.$")
	public void error_message_should_be_displayed_for_password_and_confirm_password_doesn_t_match() throws Throwable {
		
		try {
			String actual="The Password and the Confirm Password don't match.";
			String  expected=driver.findElementByXPath("(//span[@id='errormsg_password'])[13]").getText();
			Assert.assertEquals("The Password and the Confirm Password don't match", expected, actual);
		} catch (AssertionError e) {
			APPLICATION_LOGS.debug("password and confirm password is same");
			Assert.fail("password and confirm password is same");
		}
		finally {
			driver.quit();
		}
	    
	}
	
}

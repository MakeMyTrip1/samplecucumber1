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
	    
		APPLICATION_LOGS.debug("Login successful");
		driver.quit();
	/*	if(!driver.findElementById("").isDisplayed())
		{
		APPLICATION_LOGS.debug("Login successful");
		Assert.assertTrue("Login successful", !driver.findElementById("").isDisplayed());
		}
		else
			Assert.fail("User didn't logged in successfully");*/
	}
	
}

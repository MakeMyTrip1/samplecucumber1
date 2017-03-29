package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class LoginStepDefinition extends GenericWrappers{
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");

	public  LoginStepDefinition() {
		// TODO Auto-generated constructor stub
		if (!verifyTitle("")) {
			APPLICATION_LOGS.debug("This is not home page");
			
		}
	}
	
	String url="www.makemytrip.com";
	
	
	@Given("^User is in homepage$")
	public void user_is_in_homepage() throws Throwable {
	    APPLICATION_LOGS.debug("user in homepage");
	    invokeApp("chrome",url, false);
	    
	}

	@When("^User able to click Login button$")
	public void user_able_to_click_Login_button() throws Throwable {
		APPLICATION_LOGS.debug("user click login button");
		clickById("ssologinlink");				  
	}

	@When("^User enter valid username and valid password$")
	public void user_enter_valid_username_and_valid_password() throws Throwable {
		APPLICATION_LOGS.debug("user enters valid username and password");
		enterById("username", "aaavig@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);	  
		enterById("password", "aaavig");
		driver.findElementById("password").sendKeys(Keys.TAB);	    
	}

	@When("^Click Login button$")
	public void click_Login_button() throws Throwable {
	    APPLICATION_LOGS.debug("click Login");
	    clickByXpath("//input[@id='login_btn']");	    
	}

	@Then("^verify user Logged in successfully$")
	public void verify_user_Logged_in_successfully() throws Throwable {
	    
		if(!driver.findElementById("").isDisplayed())
		{
		APPLICATION_LOGS.debug("Login successful");
		Assert.assertTrue("Login successful", !driver.findElementById("").isDisplayed());
		}
		else
			Assert.fail("User didn't logged in successfully");
	}
	
}

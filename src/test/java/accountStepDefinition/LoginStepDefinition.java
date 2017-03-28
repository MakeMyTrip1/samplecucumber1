package accountStepDefinition;

import org.apache.log4j.Logger;

import cucumber.api.java.en.*;

public class LoginStepDefinition {
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");

	@Given("^User is in homepage$")
	public void user_is_in_homepage() throws Throwable {
	    APPLICATION_LOGS.debug("user in homepage");
	    
	}

	@When("^User able to click Login button$")
	public void user_able_to_click_Login_button() throws Throwable {
		APPLICATION_LOGS.debug("user click login button");
	    
	}

	@When("^User enter valid username and valid password$")
	public void user_enter_valid_username_and_valid_password() throws Throwable {
		APPLICATION_LOGS.debug("user enters valid username and password");
	    
	}

	@When("^Click Login button$")
	public void click_Login_button() throws Throwable {
	    APPLICATION_LOGS.debug("click Login");
	    
	}

	@Then("^verify user Logged in successfully$")
	public void verify_user_Logged_in_successfully() throws Throwable {
	    APPLICATION_LOGS.debug("Login successful");	    
	}
	
}

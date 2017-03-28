package accountStepDefinition;

import org.apache.log4j.Logger;

import cucumber.api.java.en.*;

public class LogoutStepDefinition {
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");
	
	@Given("^User is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
	    APPLICATION_LOGS.debug("User is already logged in");
	    
	}

	@When("^user click menu$")
	public void user_click_menu() throws Throwable {
		APPLICATION_LOGS.debug("User clicks menu button");
	    
	}

	@When("^click Log out button$")
	public void click_Log_out_button() throws Throwable {
		APPLICATION_LOGS.debug("User clicks logout button");
	    
	}

	@Then("^user should logged out successfully$")
	public void user_should_logged_out_successfully() throws Throwable {
		APPLICATION_LOGS.debug("User successfully logged out");
	    
	}

}

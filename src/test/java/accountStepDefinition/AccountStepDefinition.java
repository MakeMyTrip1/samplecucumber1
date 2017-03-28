package accountStepDefinition;

import org.apache.log4j.Logger;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class AccountStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	

	@Given("^User in MakeMyTrip homepage$")
	public void user_in_MakeMyTrip_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("Homepage");
	    
	}

	@When("^User click Login button$")
	public void user_click_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("Login button");
	}

	@When("^click create new user link$")
	public void click_create_new_user_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("Create new user");
	}

	@When("^User able to enter new email id$")
	public void user_able_to_enter_new_email_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("new email id");
	}

	@When("^User able to new password$")
	public void user_able_to_new_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("new password");
	}

	@When("^User enters confirm password$")
	public void user_enters_confirm_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("confirm password");
	}

	@When("^click i agree option\\.$")
	public void click_i_agree_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("i agree");
	}

	@When("^click create account$")
	public void click_create_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		APPLICATION_LOGS.debug("create account");
	}

	@Then("^Verify user is signed in successfully$")
	public void verify_user_is_signed_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}

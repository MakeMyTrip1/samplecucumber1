package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class AccountStepDefinition extends GenericWrappers {

	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights-hotels/";

	@Given("^User in MakeMyTrip homepage$")
	public void user_in_MakeMyTrip_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		invokeApp("chrome",url, false);
		APPLICATION_LOGS.debug("user in homepage");	    
	}

	@When("^User click Login button$")
	public void user_click_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("Login button");
	}

	@When("^click create new user link$")
	public void click_create_new_user_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickById("openNewUserDivlink");
		APPLICATION_LOGS.debug("Create new user");
	}

	@When("^User able to enter new email id$")
	public void user_able_to_enter_new_email_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		enterById("newusername", "bevicky@yopmail.com");
		driver.findElementById("newusername").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("new email id");
	}

	@When("^User able to new password$")
	public void user_able_to_new_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		enterById("newpassword", "aavicky");
		driver.findElementById("newpassword").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("new password");
	}

	@When("^User enters confirm password$")
	public void user_enters_confirm_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		enterById("repassword", "aavicky");
		driver.findElementById("repassword").sendKeys(Keys.TAB);
		APPLICATION_LOGS.debug("confirm password");
	}

	@When("^click i agree option\\.$")
	public void click_i_agree_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickById("iagreeSpan");
		APPLICATION_LOGS.debug("i agree");
	}

	@When("^click create account$")
	public void click_create_account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickById("create_act_btn");
		APPLICATION_LOGS.debug("create account");
	}

	@Then("^Verify user is signed in successfully$")
	public void verify_user_is_signed_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
		try {
			String actual="user";
			String expected=driver.findElementByXPath("//span[@id='ssologinlink']/strong").getText();
			Assert.assertEquals("user logged in successfully", expected, actual);
			APPLICATION_LOGS.debug("login successful");
		} catch (AssertionError e) {
			APPLICATION_LOGS.debug("Login unsuccessful");
			Assert.fail("Login unsuccessful");
		}
		/*verifyTextContainsByXpath("//span[@id='ssologinlink']/strong", "user");
		System.out.println(driver.findElementByXPath("//span[@id='ssologinlink']/strong").getText());*/
		//My Account
		finally {
			driver.quit();	
		}    
	}

}

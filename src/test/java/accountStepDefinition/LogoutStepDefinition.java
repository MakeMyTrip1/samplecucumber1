package accountStepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class LogoutStepDefinition extends GenericWrappers{
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");
	String url="https://www.makemytrip.com/flights-hotels/";
	
	@Given("^User is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
		invokeApp("chrome",url, false);
		
		clickById("ssologinlink");
		
		enterById("username", "aavicky@yopmail.com");
		driver.findElementById("username").sendKeys(Keys.TAB);
		
		enterById("password", "aavicky");
		driver.findElementById("password").sendKeys(Keys.TAB);
		
		clickByXpath("//input[@id='login_btn']");
		
		APPLICATION_LOGS.debug("user in homepage");	    
	}

	@When("^user click menu$")
	public void user_click_menu() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("user click login button");	    
	}

	@When("^click Log out button$")
	public void click_Log_out_button() throws Throwable {
		clickByXpath("(//input[@class='sign_out chf_flL'])[1]");
		APPLICATION_LOGS.debug("User clicks logout button");
	    
	}

	@Then("^user should logged out successfully$")
	public void user_should_logged_out_successfully() throws Throwable {
		APPLICATION_LOGS.debug("User successfully logged out");
		driver.quit();
	}

}

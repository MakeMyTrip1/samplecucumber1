package accountStepDefinition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.gargoylesoftware.htmlunit.javascript.host.ApplicationCache;

import cucumber.api.java.en.*;
import wrappers.GenericWrappers;

public class ForgotPasswordStepDefinition extends GenericWrappers{
	
	Logger APPLICATION_LOGS = Logger.getLogger("test");

	String url="https://www.makemytrip.com/flights-hotels/";

	@Given("^User should be in dashboard$")
	public void user_should_be_in_dashboard() throws Throwable {
	    
		invokeApp("chrome", url, false);
		if(!verifyTitle("Flights + Hotels - Book Flight & Hotel Deals at Discounted Prices | MakeMyTrip India")){
			Assert.fail("This is not dashboard page");
		}
		APPLICATION_LOGS.debug("user in homepage");	    
	    
	}

	@When("^user click the menu button\\.$")
	public void user_click_the_menu_button() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("Login button");	    
	}

	@When("^click forgot password link\\.$")
	public void click_forgot_password_link() throws Throwable {

		clickById("openFgrPwdLink");
		APPLICATION_LOGS.debug("Forgot password link is selected");    
	}

	@When("^user enters a unregistered emailID in forgot password section\\.$")
	public void user_enters_a_unregistered_emailID_in_forgot_password_section() throws Throwable {
		enterById("fp_email", "aaavig1234@yopmail.com");
		driver.findElementById("fp_email").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("unregistered email id has entered");
	}

	@When("^click submit button\\.$")
	public void click_submit_button() throws Throwable {
		clickById("fpwd_btn");
		APPLICATION_LOGS.debug("submit button is clicked");    
	}

	@Then("^Error message should be displayed for unregistered email ID$")
	public void error_message_should_be_displayed_for_unregistered_email_ID() throws Throwable {
		
		verifyTextByXpath("(//span[@class='chf_errortext chf_flL chf_error_msg'])[8]", "EmailID provided is not registered with MakeMyTrip.");
		APPLICATION_LOGS.debug("Error message displayed for unregistered email id");
	    driver.quit();
	}
	
	
	@Given("^User is in MakeMyTrip Dashboard page\\.$")
	public void user_is_in_MakeMyTrip_Dashboard_page() throws Throwable {
		invokeApp("chrome", url, false);
		if(!verifyTitle("Flights + Hotels - Book Flight & Hotel Deals at Discounted Prices | MakeMyTrip India")){
			Assert.fail("This is not dashboard page");
		}
		APPLICATION_LOGS.debug("user in homepage");	    	    
	}

	@When("^user selects the my account menu button\\.$")
	public void user_selects_the_my_account_menu_button() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("Login button");	 	    
	}

	@When("^clicks ForgotPassword option in login section$")
	public void clicks_ForgotPassword_option_in_login_section() throws Throwable {
		clickById("openFgrPwdLink");
		APPLICATION_LOGS.debug("Forgot password link is selected");	    
	}

	@When("^enter the registered email id in email section\\.$")
	public void enter_the_registered_email_id_in_email_section() throws Throwable {
		enterById("fp_email", "aaavig@yopmail.com");
		driver.findElementById("fp_email").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("registered mail id has entered");
	}

	@When("^user click submit\\.$")
	public void user_click_submit() throws Throwable {
		clickById("fpwd_btn");
		APPLICATION_LOGS.debug("submit button is clicked");    	    
	}

	@When("^user navigates to yopmail\\.$")
	public void user_navigates_to_yopmail() throws Throwable {
		driver.get("http://www.yopmail.com/en/");
	    APPLICATION_LOGS.debug("user navigates to yopmail");
	}

	@When("^user enters the email id in the email textbox$")
	public void user_enters_the_email_id_in_the_email_textbox() throws Throwable {
		enterById("login", "aaavig");
	    APPLICATION_LOGS.debug("registerd email id has been entered");
	}

	@When("^user click check for inbox option$")
	public void user_click_check_for_inbox_option() throws Throwable {
		clickByXpath("//input[@class='sbut']");
	    APPLICATION_LOGS.debug("check for inbox has been clicked");
	}

	@When("^user click check for new mail button$")
	public void user_click_check_for_new_mail_button() throws Throwable {
		clickByClassName("slientext");
	    APPLICATION_LOGS.debug("check for new mail button is clicked");
	}

	@When("^user clicks the password change request link in the inbox$")
	public void user_clicks_the_password_change_request_link_in_the_inbox() throws Throwable {
		driver.switchTo().frame("ifmail");
		clickByLink("link");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("link has been clicked");
	}

	@When("^user navigate back to MakeMytrip support page\\.$")
	public void user_navigate_back_to_MakeMytrip_support_page() throws Throwable {
		switchToLastWindow();	 
	    APPLICATION_LOGS.debug("user navigated to  make my trip support page");
	}

	@When("^user enter new password in choose a password textbox$")
	public void user_enter_new_password_in_choose_a_password_textbox() throws Throwable {
		Thread.sleep(3000);
		clickById("plainpassword");		
		enterById("txtPassword", "aaavig");
	    APPLICATION_LOGS.debug("new password has been entered");
	}

	@When("^user enters confirm password in retype password textbox$")
	public void user_enters_confirm_password_in_retype_password_textbox() throws Throwable {
		Thread.sleep(3000);
		driver.findElementById("retype_plainpassword").click();
		enterById("retype_password", "aaavig");
	    APPLICATION_LOGS.debug("retype password has been entered");
	}

	@Then("^user click submit button for changing the password$")
	public void user_click_submit_button_for_changing_the_password() throws Throwable {
		clickById("Submit");	
	    APPLICATION_LOGS.debug("submit button has been clicked");
	    driver.quit();
	}
	
	
	
	@Given("^User should be in MakeMyTrip dashboard$")
	public void user_should_be_in_MakeMyTrip_dashboard() throws Throwable {
		invokeApp("chrome", url, false);
		if(!verifyTitle("Flights + Hotels - Book Flight & Hotel Deals at Discounted Prices | MakeMyTrip India")){
			Assert.fail("This is not dashboard page");
		}
		APPLICATION_LOGS.debug("user in homepage");	   	    
	}

	@When("^user clicks my account menu\\.$")
	public void user_clicks_my_account_menu() throws Throwable {
		clickById("ssologinlink");
		APPLICATION_LOGS.debug("Login button");	 	    
	}

	@When("^user click forgot link in my account menu\\.$")
	public void user_click_forgot_link_in_my_account_menu() throws Throwable {
		clickById("openFgrPwdLink");
		APPLICATION_LOGS.debug("Forgot password link is selected");	    	    
	}

	@When("^user enters registered mail in forgot password section\\.$")
	public void user_enters_registered_mail_in_forgot_password_section() throws Throwable {
		enterById("fp_email", "aaavig@yopmail.com");
		driver.findElementById("fp_email").sendKeys(Keys.TAB);
	    APPLICATION_LOGS.debug("registered mail id has entered");	    
	}

	@When("^click submit button in forgot password section$")
	public void click_submit_button_in_forgot_password_section() throws Throwable {
		clickById("fpwd_btn");
		APPLICATION_LOGS.debug("submit button is clicked");    	   	    
	}

	@When("^user navigate to yopmail dashboard$")
	public void user_navigate_to_yopmail_dashboard() throws Throwable {
		driver.get("http://www.yopmail.com/en/");
	    APPLICATION_LOGS.debug("user navigates to yopmail");	    
	}

	@When("^user enters email in the textbox$")
	public void user_enters_email_in_the_textbox() throws Throwable {
		enterById("login", "aaavig");
	    APPLICATION_LOGS.debug("registerd email id has been entered");	    
	}

	@When("^user select check for inbox button$")
	public void user_select_check_for_inbox_button() throws Throwable {
		clickByXpath("//input[@class='sbut']");
	    APPLICATION_LOGS.debug("check for inbox has been clicked");	    
	}

	@When("^user click new mail button$")
	public void user_click_new_mail_button() throws Throwable {
		clickByClassName("slientext");
	    APPLICATION_LOGS.debug("check for new mail button is clicked");	    
	}

	@When("^user click the link in the message$")
	public void user_click_the_link_in_the_message() throws Throwable {
		driver.switchTo().frame("ifmail");
		clickByLink("link");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("link has been clicked");	    
	}

	@When("^user will be navigating to MakeMyTrip support page$")
	public void user_will_be_navigating_to_MakeMyTrip_support_page() throws Throwable {
		switchToLastWindow();	 
	    APPLICATION_LOGS.debug("user navigated to  make my trip support page");	    
	}

	@When("^user enters new password in the password textbox$")
	public void user_enters_new_password_in_the_password_textbox() throws Throwable {
		Thread.sleep(3000);
		clickById("plainpassword");		
		enterById("txtPassword", "aaavig");
	    APPLICATION_LOGS.debug("new password has been entered");	    
	}

	@When("^user enters retype password in next textbox$")
	public void user_enters_retype_password_in_next_textbox() throws Throwable {
		Thread.sleep(3000);
		driver.findElementById("retype_plainpassword").click();
		enterById("retype_password", "aaavig");
	    APPLICATION_LOGS.debug("retype password has been entered");	    
	}

	@When("^user click submit option to change the password$")
	public void user_click_submit_option_to_change_the_password() throws Throwable {
		clickById("Submit");	
	    APPLICATION_LOGS.debug("submit button has been clicked");	    
	}

	@When("^Enter EmailAddress in the textbox$")
	public void enter_EmailAddress_in_the_textbox() throws Throwable {
		enterById("UC1_email", "aaavig@yopmail.com");
	    APPLICATION_LOGS.debug("email id has entered");
	}

	@When("^Enter the changed password in the textbox\\.$")
	public void enter_the_changed_password_in_the_textbox() throws Throwable {
		enterById("UC1_txtPassword", "aaavig");
		APPLICATION_LOGS.debug("password has been entered");
	}

	@When("^click login button for the new password$")
	public void click_login_button_for_the_new_password() throws Throwable {
		clickById("UC1_btnLogin");
		Thread.sleep(3000);
		APPLICATION_LOGS.debug("Login button is clicked");
	}

	@Then("^verify user logged in successfully using new password$")
	public void verify_user_logged_in_successfully_using_new_password() throws Throwable {
		verifyTextByXpath("//span[@id='ssologinlink']/strong", "user");
	    APPLICATION_LOGS.debug("user logged in");
	    driver.quit();
	}
	

}

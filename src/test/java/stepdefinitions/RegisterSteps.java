package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.*;

public class RegisterSteps {
	
	@Steps
	HomePage home;
	@Steps
	LoginPage login;
	@Steps
	RegisterPage register;
	
	@Given("User launches Loblaws url")
	public void user_launches_loblaws_url() {
		
		home.openApplication();
	   
	}
	@When("User clicks on Sign In page")
	public void user_clicks_on_sign_in_page() {
		home.clickSignIn();
	}
	
	@Then("User Clicks on Create PC id")
	public void user_clicks_on_create_pc_id() {
		login.clickCreatePcIdLink();
	}
	
	@Then("User creates an account by providing enter {string},{string} and {string}")
	public void user_creates_an_account_by_providing_enter_and(String email, String password, String ConfirmPassword) {
	    
		register.EnterEmail(email);
		register.EnterPassword(password);
		register.EnterConfirmPassword(ConfirmPassword);
	}
	
	@Then("user clicks on Agree checkbox")
	public void user_clicks_on_agree_checkbox() {
	    
		register.clickTcCheckbox();
	}
	
	
	@Then("user clicks creates PC id button")
	public void user_clicks_creates_pc_id_button() {
	    
		register.clickCreatePcId();
	}



}

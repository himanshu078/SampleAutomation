package stepdefinitions;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
import io.cucumber.java.en.*;


public class LoginSteps {
	
	@Given("Loblaws website is up and running")
	public void loblaws_website_is_up_and_running() {
		System.out.println("Loblaws website is up and running1");
	}
	
	@When("User has a internet connection")
	public void user_has_a_internet_connection() {
		System.out.println("User has a internet connection1");
	    
	}
	
	@Given("user navigates to loblaws website")
	public void user_navigates_to_loblaws_website() {
	   
		System.out.println("user navigates to loblaws website1");
		
	}
	
	@Then("user naviagted to login page")
	public void user_naviagted_to_login_page() {
		
		System.out.println("user naviagted to login page1");
	   
	}
	
	@Then("user enters valid email and password")
	public void user_enters_valid_email_and_password() {
		
		System.out.println("user enters valid email and password1");
	    
	}
	
	@Then("user clicks on sign In button")
	public void user_clicks_on_sign_in_button() {
		
		System.out.println("user clicks on sign In button1");
	    
	}
	
	@Then("user able to do successful login")
	public void user_able_to_do_successful_login() {
		
		System.out.println("user able to do successful login1");
	   
	}
	
	@When("user clicked on Sign In")
	public void user_clicked_on_sign_in() {
		System.out.println("user clicked on Sign In1");
		
	}
	@Then("user enters valid {string} and {string}")
	public void user_enters_valid_and(String email, String password) {
		
		System.out.println("User enters username as " + email);
		System.out.println("User enters password as " + password);
	    
		
	}
	

}

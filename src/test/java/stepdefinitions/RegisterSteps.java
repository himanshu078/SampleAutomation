package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.*;
import utils.CommonMethods;

public class RegisterSteps {
	
	@Steps
	HomePage home;
	@Steps
	LoginPage login;
	@Steps
	RegisterPage register;
	@Steps
	CommonMethods common;
	@Steps
	Product product;
	@Steps
	Action action;
	@Steps
	PopUpsConcepts popUp;
	@Steps
	WindowHandles handle;
	@Steps
	WebTable table;
	
	
	@Given("user launches url {string}")
	public void user_launches_url(String url) {
		
		home.openApplicationAgain(url);
	}
	
	
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
	
	@Then("validates the error message on register page")
	public void validates_the_error_message_on_register_page() {
		register.testErrorMessage();
	}
	
	
	@When("user searched {string} in search for product bar")
	public void user_searched_in_search_for_product_bar(String product) {
	   
		home.searchProduct(product);
		
	}
	
	
	@Then("user clicks on sorting dropdown and validate all values in dropdown are displayed")
	public void user_clicks_on_sorting_dropdown_and_validate_all_values_in_dropdown_are_displayed() {
	    home.sortingdropdown();
	}
	
	@Then("user selects {string} from dropdown")
	public void user_selects_from_dropdown(String option) {
		home.selectSortByOption(option);
	}
	
	@Then("search results are displayed")
	public void search_results_are_displayed() {
			
		home.getListOfProducts();
		
	}
	@Then("user add {string} to the cart")
	public void user_add_to_the_cart(String expectedProduct) {
		
		home.AddToCart(expectedProduct);
	    
	}
	
	@Given("User launches Loblaws url for page navigation")
	public void user_launches_loblaws_url_for_page_navigation() {
		
		home.openApplication();
		home.clickSignIn();
		common.navigateBackward();
		common.navigateForward(); // came back to signIn page
		login.clickCreatePcIdLink();
		common.navigateBackward(); //came back to signIn page
		common.navigateForward(); // went back to register page
		common.refreshPage();
		common.closebrowser();	
	}
	
	
	@Then("user select {string} on the page")
	public void user_select_on_the_page(String filterName) {
	    
	    product.searchFilter(filterName);
	}
	
	@Then("user selects {string} option from the filter")
	public void user_selects_option_from_the_filter(String filterOption) {
		
		product.selectFilterOption(filterOption);
	    
	}
	
	
	@Then("user search for {string} brand in the filter")
	public void user_search_for_brand_in_the_filter(String search) {
		product.searchableDropdownforBrands(search);
	}
	
	@When("user selects one {string} and {string}")
	public void user_selects_one_and(String category, String subcategory) {
		
	//	action.testActions("Grocery", "International Foods");
		action.simpleTestActions();
	    
	}
	
	
	@Given("User launches url to test drag and drop")
	public void user_launches_url_to_test_drag_and_drop() {
	    
		action.testDragAndDrop();
	}
	
	
	@Given("User tests Javascript popup")
	public void user_tests_javascript_popup() {
		popUp.testJavaScriptAlerts();
	}
	
	
	@When("User tests windows popup for {string}")
	public void user_tests_windows_popup_for(String fileName) {
	    	
		popUp.testDesktopPopUp(fileName);
	}
	
	
	@Given("User wanted to test windowhandles")
	public void user_wanted_to_test_windowhandles() {
		
		handle.testWindowHandles();
	    
	}
	@Given("user wanted to test windowhandles for loblaws")
	public void user_wanted_to_test_windowhandles_for_loblaws() {
		
		handle.testWindowHandleForLoblaws();
	    
	}
	
	@Given("user wanted to test web table")
	public void user_wanted_to_test_web_table() {
		
		table.testWebTables();
	   
	}
	
	
	@When("user selects {string} and {string}")
	public void user_selects_grocery_and(String category, String subcategory) {
		//product.categoryProducts(category, subcategory);
		
		action.listOfSubCategories(category);
		action.listOfItems(subcategory);
		
	}
	
	
	@Then("user validates number of subcategories under a category is {string}")
	public void user_validates_number_of_subcategories_under_a_category_is(String noOfSubcategoires) {

		action.noOfCategories(Integer.parseInt(noOfSubcategoires));
	}
	
	
	@Then("user validates number of items under a subcategory is {string}")
	public void user_validates_number_of_items_under_a_subcategory_is(String noOfItems) {
	    
		action.noOfItemsInSubCategory(Integer.parseInt(noOfItems));
	}








}

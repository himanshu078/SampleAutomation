package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import setup.Init;
import utils.ReportLog;

public class HomePage extends PageObject{

	//	Init init1 = new Init();	
	@Steps
	Init init;
	@Steps
	ReportLog report;
	
	// using Web Element Facade
	@FindBy(className = "lds__privacy-policy__btnClose")
	WebElementFacade clearCookiesPopUp;
	
	//a[@data-auid='account-login-button']
	//a[@data-track='headerSignInLink']
	@FindBy(xpath = "//a[@class='sign-in account__login-link']")
	WebElementFacade clickSignInOnHome;
	
	@FindBy(xpath = "//input[@placeholder='Search for product']")
	WebElementFacade searchbar;
	
	
	//button[@aria-label='Submit Search']
	@FindBy(xpath = "//button[@type='submit']")
	WebElementFacade submitSearch;
	
	//html tag name
	
	@FindBy(xpath= "//button[@data-option-value= 'recommended']") 
	WebElementFacade sortByRelevance;

	@FindBy(xpath= "//button[text()= 'Price (Low to High)']") 
	WebElementFacade sortByPriceLowToHigh;

	@FindBy(xpath= "//button[text()= 'Price (High to Low)']") 
	WebElementFacade sortByPriceHighToLow;

	@FindBy(xpath= "//button[text()= 'A-Z (alphabetical)']") 
	WebElementFacade sortByAlphabetical;

	@FindBy(xpath= "//button[text()= 'Newest to Oldest Products']") 
	WebElementFacade sortByNewToOld;
	
	//can use AND to make a unique xpath
	@FindBy(xpath= "//button[@class= 'styled-dropdown__selected-item-link styled-dropdown__selected-item-link--filter' and @data-sort-code= 'recommended']")
	WebElementFacade clickSortDropDown;
	
	
	@FindBy(xpath = "//button[@aria-label='pickup']")
	WebElementFacade pickUpButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElementFacade confirmLocation;

	@FindBy(xpath ="//span[@class = 'cart-item-count__text']")
	WebElementFacade noOfItemsInCart;		

	List <WebElementFacade> productDetails;
	
	
	public void openApplicationAgain(String url) {
		
		getDriver().get(url);
		getDriver().manage().window().maximize();
		report.LOG("Loblaws Url is opened");
		waitABit(4000);
		
	}
	
	
	public void openApplication() {

		//open the url in  browser specified in the file
		//	getDriver().get("https://www.loblaws.ca/");
		//	getDriver().navigate().to("https://www.loblaws.ca/");
		
		

		// from Properties file
		getDriver().get(init.getAppUrl());
		getDriver().manage().window().maximize();
		report.LOG("Loblaws Url is opened");
		waitABit(4000);
		
		
		// to get title of the page
		System.out.println(getDriver().getTitle());
		// to get url of the page
		System.out.println(getDriver().getCurrentUrl());
		
		
		Assert.assertEquals("Loblaws Supermarket | Grocery shop online", getDriver().getTitle());
		//Assert.assertEquals("https://www.lobl", getDriver().getCurrentUrl());
		Assert.assertEquals("https://www.loblaws.ca/", getDriver().getCurrentUrl());
		
		
		// one way of element identification - using WebElement; other way is using - WebElementFacade
		//WebElement cookies = getDriver().findElement(By.className("lds__privacy-policy__btnClose"));
		//cookies.click();
		 
		
		if (clearCookiesPopUp.isCurrentlyVisible()) {
			clearCookies();
		}
		
	}
	
	public void clickSignIn() {
		
		clickSignInOnHome.click();
		waitABit(3000);
	}
	
	
	public void clearCookies() {
		
		clearCookiesPopUp.click();
		report.LOG("Cookies are cleared");
		waitABit(2000);
		
	}
	
	public void searchProduct(String product) {
		
		// to clear data in the search bar
			searchbar.clear();
		
		//when webelement is used
		searchbar.sendKeys(product);
		waitABit(2000);
		submitSearch.click();
		waitABit(2000);
		

		// 2nd option - 1 step - when WebElementfacade is used
	//	searchbar.typeAndEnter(product);
	//	waitABit(2000);
		
	}
	
	public void sortingdropdown() {
		
		sortByDropdown();
		
		Assert.assertEquals("Relevance", sortByRelevance.getText());
		report.LOG( sortByRelevance.getText() +" verified successfully");
		
		Assert.assertEquals("Price (Low to High)", sortByPriceLowToHigh.getText());
		report.LOG( sortByPriceLowToHigh.getText() +" verified successfully");
		
		Assert.assertEquals("Price (High to Low)", sortByPriceHighToLow.getText());
		report.LOG( sortByPriceHighToLow.getText() +" verified successfully");
		
		Assert.assertEquals("A-Z (alphabetical)", sortByAlphabetical.getText());
		report.LOG( sortByAlphabetical.getText() +" verified successfully");
		
		Assert.assertEquals("Newest to Oldest Products", sortByNewToOld.getText());
		report.LOG( sortByNewToOld.getText() +" verified successfully");
	}
	
	
	public void sortByDropdown() {
		clickSortDropDown.click();
		report.LOG("Sort by dropdown is clicked");
	}
	
	public void selectSortByOption(String SortOption) {

		
		waitABit(2000);
		if (SortOption.equalsIgnoreCase(sortByRelevance.getText()))
		{
			sortByRelevance.click();
			report.LOG(sortByRelevance.getText() +" is selected");
		}
		else if (SortOption.equalsIgnoreCase("Price (Low to High)"))
		{
			sortByPriceLowToHigh.click();
			report.LOG("Price (Low to High) is selected");
		}
		else if (SortOption.equalsIgnoreCase("Price (High to Low)"))
		{
			sortByPriceHighToLow.click();
			report.LOG("Price (High to Low) is selected");
		}
		else if (SortOption.equalsIgnoreCase("A-Z (alphabetical)"))
		{
			sortByAlphabetical.click();
			report.LOG("A-Z (alphabetical) is selected");
		}
		else if (SortOption.equalsIgnoreCase("Newest to Oldest Products"))
		{	
			//js.executeScript("arguments[0].scrollIntoView();", sortByNewToOld);
			//	js.executeScript("window.scrollBy(0,350)", "");
			sortByNewToOld.click();
			report.LOG("Newest to Oldest Products is selected");
		}
		else report.LOG(SortOption + " is not a valid input");	
		waitABit(5000);

	}
	
	
	public List<WebElementFacade> getListOfProducts() {

		//	product list -  //span[@class= 'product-name product-name--product-tile']
		//	product brand list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--brand']
		//	product name list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']
		//	product quantity list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--package-size']

		
		
		
		
		
		String productListXpath = "//span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']";
		
		
		productDetails = findAll(By.xpath(productListXpath));
		System.out.println(productDetails.size());
		
		for (int i=0; i<productDetails.size(); i++) {
			System.out.println(productDetails.get(i).getText());
		}
		
		return productDetails;
	}
	
	
	public void AddToCart(String expectedProduct) {

		List<WebElementFacade> listOfProductName = getListOfProducts();
		
		//button[@aria-label= 'Add to cart, Partly Skimmed Milk 2% MF']
		
		//button[@aria-label= 'Add to cart, Partly Skimmed Milk 1% MF']
		//button[@aria-label= 'Add to cart, Homogenized Milk 3.25%']
		
		// way to create dynamic xpath
		String beforeProduct = "//button[@aria-label= 'Add to cart, ";
		String afterProduct = "']";
		String product;
		
		for (int i=0; i <listOfProductName.size(); i++) {
			
			product = listOfProductName.get(i).getText();
			
			if (product.equals(expectedProduct)) {
				
				String fullxpath = beforeProduct+product+afterProduct;
				System.out.println(fullxpath);
				getDriver().findElement(By.xpath(fullxpath)).click();
				
				report.LOG(expectedProduct + " product found");
				System.out.println(expectedProduct + " product found");
				break;
				
			} else System.out.println("Requested product not found");
		}
	
		
		if (pickUpButton.isDisplayed()) {
			pickUpButton.click();
			System.out.println("pickup clicked");
			waitABit(2000);
		}

		if (confirmLocation.isDisplayed()) {
			confirmLocation.click();
			System.out.println("confirm Location clicked");
			waitABit(2000);
		}

		Assert.assertEquals("1", noOfItemsInCart.getText());
		report.LOG("No. of product in cart is " + noOfItemsInCart.getText());
	}


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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


}

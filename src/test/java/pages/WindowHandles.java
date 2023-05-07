package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles extends PageObject {


	@Steps
	HomePage home;

	public void testWindowHandleForLoblaws() {

		home.openApplication();

		Actions action = new Actions(getDriver());

		// to hover on category
		WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Flyers & Deals']"));
		action.moveToElement(categoryName).build().perform();


		// to hover on Subcategory
		WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='Digital Coupons']"));
		action.moveToElement(subCategoryName).build().perform();

		// click on sub category
		subCategoryName.click();
		waitABit(5000);

		//take all the windows which are opened and get the IDs
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		// give the count of Windows
		System.out.println(allWindowHandles.size());
		
		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}


		// iterating and check for windows one by one
		Iterator<String> it = allWindowHandles.iterator();

		String parentWindow = it.next();
		System.out.println("parentWindow  " +   parentWindow);

		String childWindow = it.next();
		System.out.println("childWindow  " +   childWindow);

		// to give control to the child window and perform operations
		getDriver().switchTo().window(childWindow);
		waitABit(6000);
		System.out.println("Child Window details");
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());

		// this will close the current window where driver has control
		getDriver().close();
		// this will close all the windows which are opened by the driver
		//getDriver().quit();

		// Switching back to the main window or to another child window
		getDriver().switchTo().window(parentWindow);
		waitABit(6000);
		System.out.println("Parent Window details");
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());
		getDriver().close();

	}


	public void testWindowHandles() {

		getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		getDriver().manage().window().maximize();
		waitABit(4000);

		//for new windows
			getDriver().findElement(By.id("newWindowsBtn")).click();

		//for new tabs
	//	getDriver().findElement(By.id("newTabsBtn")).click();

		Set<String> allWindowHandles = getDriver().getWindowHandles();
		System.out.println(allWindowHandles.size());

		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}

		Iterator<String> it = allWindowHandles.iterator();

		String parentWindow = it.next();
		System.out.println("Parent window " + parentWindow);

		String childWindow = it.next();
		System.out.println("Child window " + childWindow);
		
		getDriver().switchTo().window(childWindow);
		waitABit(4000);
		
		System.out.println("TitleOfChildWindow " + getDriver().getTitle());
		// fill first name, last name, etc
		getDriver().close();

		String secondChildWindow = it.next();
		System.out.println("Second Child window " + secondChildWindow);
		
		getDriver().switchTo().window(secondChildWindow);
		waitABit(4000);
		
		System.out.println("TitleOfSecondChildWindow " + getDriver().getTitle());
		// fill first name, last name, etc
		getDriver().close();

		getDriver().switchTo().window(parentWindow);
		waitABit(4000);
		
		System.out.println("TitleOfparentWindow" + getDriver().getTitle());
		getDriver().quit();

	}

}

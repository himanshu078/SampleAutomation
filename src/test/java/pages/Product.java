package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class Product extends PageObject{
	
	String filterName;
	String filterOption;
	
	//Click on dropdown - Ailse, brand, price etc.
		public void searchFilter(String filter) {
			
			//button[text()= 'Aisle']
			//button[text()= 'Brand']
			
			String beforeCategory = "//button[text()= '";
			String afterCategory = "']";
			
			String fullXpathforCategory = beforeCategory + filter+ afterCategory; // //button[text()= 'Aisle']
			WebElement filterCategory = getDriver().findElement(By.xpath(fullXpathforCategory));
			
			//to check status of dropdown by getting the attribute value
			String beforeClick = getDriver().findElement(By.xpath(fullXpathforCategory)).getAttribute("data-cruller");
			System.out.println("beforeClick " + beforeClick);
			String afterClick = null;
			
			if (beforeClick.contains("collapsed")) {
				
				filterCategory.click();
				afterClick = getDriver().findElement(By.xpath(fullXpathforCategory)).getAttribute("data-cruller");
				System.out.println("afterClick " + afterClick);
			}
			else filterCategory.click();
			
			waitABit(3000);

		}
		
		
		//Click on options in filter like for Deals - multibuy/price reduction
		public void selectFilterOption(String option) {
			
			filterOption=option;
			
			//to get list of all the options in a dropdown
			//other way of wirting this xpath -                          //ul[@aria-label ='Search for product Deals']/li/label
			List <WebElement> list = getDriver().findElements(By.xpath("//ul[contains(@aria-label,'Search for product Deals')]//li//label"));
			
			System.out.println(list.size());
			
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getText());
				
				if (list.get(i).getText().contains(filterOption)) {
					list.get(i).click();
					System.out.println("status of checkbox for " + filterOption + " is " + getDriver().findElement(By.name(filterOption)).getAttribute("value"));
					break;
				}
			}
		}
		
		public void searchableDropdownforBrands(String search) {
			
			
			String searchBarForBrand = "//input[@placeholder='Search for brands']";
			
			WebElement searchbar = getDriver().findElement(By.xpath(searchBarForBrand));
			searchbar.clear();
			searchbar.sendKeys(search);
			waitABit(2000);
		
			
			//to get list of all the results after searching the brands
			List <WebElement> list = getDriver().findElements(By.xpath("//ul[@aria-label='Search for product Brand']//li//label"));
			
			System.out.println(list.size());
			
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getText());
				
				if (list.get(i).getText().equals(search)) {
					list.get(i).click();
					System.out.println("status of checkbox for is " + getDriver().findElement(By.name(search)).getAttribute("value"));
					Assert.assertEquals("true", getDriver().findElement(By.name(search)).getAttribute("value"));
					break;
				}
			}
			
			waitABit(3000);
			System.out.println(getDriver().getCurrentUrl());
			System.out.println(getDriver().getTitle());
			
		}

}

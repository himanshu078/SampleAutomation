package utils;

import net.serenitybdd.core.pages.PageObject;


public class CommonMethods extends PageObject{
	
	public void navigateForward() {
		
		getDriver().navigate().forward();
		waitABit(3000);
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());
		
	}
	
	public void navigateBackward() {
		getDriver().navigate().back();
		waitABit(3000);
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());
		
	}
	
	
	public void refreshPage() {
		getDriver().navigate().refresh();
		waitABit(3000);
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());
		
	}
	
	public void closebrowser() {
		getDriver().quit();
		
	}

}

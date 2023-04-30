package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;

public class LoginPage extends PageObject{
	
	@Steps
	ReportLog report;
	
	
	//tagname[text() = 'Text of the tag you are referring']
	@FindBy(xpath = "//span[text() = 'Create a ']")
	WebElementFacade clickPcID;
	
	
	
	public void clickCreatePcIdLink() {
		clickPcID.click();
		report.LOG("clicked on CreatePD ID link");
		waitABit(3000);
		
	}

}

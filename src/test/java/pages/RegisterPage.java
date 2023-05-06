package pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;
import utils.CommonMethods;


public class RegisterPage extends PageObject {

	@Steps
	ReportLog report;
	@Steps
	CommonMethods common;


	@FindBy(id = "email")
	WebElementFacade emailId;

	@FindBy(id = "newPassword")
	WebElementFacade password;

	@FindBy(name = "confirmPassword")
	WebElementFacade confirmPassword;

	@FindBy(className = "checkbox-group__input-wrapper")
	WebElementFacade agreeCheckBox;

	@FindBy(id = "termsAndConditions")
	WebElementFacade agreeCheckBoxwithID;

	//button[text() = 'Create a ']
	@FindBy(css = "button[type='submit']")
	WebElementFacade SubmitPCId;

	@FindBy(xpath = "//button[@type='submit']")
	WebElementFacade SubmitPCIdXpath;
	
	//classname = "input-error input-error--error text-group__error error"
	//xpath = //label[@class ='input-error input-error--error text-group__error error']
	//label[@id='confirmPassword__error']
	@FindBy(id = "confirmPassword__error")
	WebElementFacade confirmError;


	public void testErrorMessage() {
		
		waitABit(2000);
		String actualErrorMessage = confirmError.getText();
		System.out.println("actualErrorMessage " + actualErrorMessage);
		
		String ExpectedErrorMessage = "The passwords above don't match.";
		
		System.out.println("ExpectedErrorMessage " + ExpectedErrorMessage);
		waitABit(2000);
		
		boolean flag = false;
		
		if (actualErrorMessage.equals(ExpectedErrorMessage)) {
			
			System.out.println("Password is matching");
			flag = true;
			
		}else System.out.println("Password is not matching");
		
		Assert.assertEquals(ExpectedErrorMessage, actualErrorMessage);
		Assert.assertTrue("confirm password error test case is working ", flag);
		
		//to test negative scenario
	//	Assert.assertEquals("The passwordsss above don't match.", confirmError.getText());
		
		Assert.assertTrue("confirm password error test case is working ", 5>10);
		
	
	}

	public void EnterEmail(String email) {
			
		emailId.sendKeys(email);
		report.LOG("Entered the email");
		waitABit(2000);
		

	}


	public void EnterPassword(String passwrd) {
		password.sendKeys(passwrd);
		report.LOG("Entered the password");
		waitABit(2000);
		
	}


	public void EnterConfirmPassword(String confPassword) {
		confirmPassword.sendKeys(confPassword);
		report.LOG("Entered the confirm password");
		waitABit(2000);
		
	}


	public void clickTcCheckbox(){
		agreeCheckBox.click();
		report.LOG("Clicked on checkbox");
		waitABit(2000);
		
	}
	
	
	public void clickCreatePcId() {
		SubmitPCId.click();
		report.LOG("Clicked on PC ID button");
		waitABit(2000);
		common.closebrowser();
	}




}


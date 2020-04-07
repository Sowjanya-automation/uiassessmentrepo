package com.atmecs.qa.automationassessmentproject.pages;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.utility.AppConstants;
import com.atmecs.qa.automationassessmentproject.utility.CommonUtils;


public class SignInPage {
	
	private ReportLogService report = new ReportLogServiceImpl(SignInPage.class);
	Browser browser;
	public SignInPage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(browser.getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtemailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPassword;
	
	@FindBy(xpath="//p[@class='submit']//span[1]")
	WebElement btnSignin;
	

	public void enterUsername(String username) {
		report.info("Enter Username");
		browser.getWait().implicitWait(10000);
		txtemailAddress.sendKeys(username);		
	}
	
	public void enterPassword(String password) {
		report.info("Enter Password");
		browser.getWait().implicitWait(10000);
		txtPassword.sendKeys(password);
	}
	
	public void clickonSignin() {
		report.info("Click on signin button");
		browser.getWait().implicitWait(10000);
		btnSignin.click();
		browser.getWait().implicitWait(10000);
	}
	
	public void verifyUserAccountName(String firstname, String lastname) {
		String expText = firstname + " " + lastname;
		String text = browser.getDriver().findElement(By.xpath(".//a[@class='account']/span")).getText();		
		if(text.contains(expText)) {
		    System.out.println("1) Expected text '"+expText+"' present in the web page.");
        }else{
            System.out.println("1) Expected text '"+expText+"' is not present in the web page.");
      
		}
	}
	
}

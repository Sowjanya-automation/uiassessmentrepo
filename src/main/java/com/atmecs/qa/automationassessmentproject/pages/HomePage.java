package com.atmecs.qa.automationassessmentproject.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.automationassessmentproject.utility.AppConstants;
import com.atmecs.qa.automationassessmentproject.utility.CommonUtils;

public class HomePage extends SampleTestSuiteBase{
	
	private ReportLogService report = new ReportLogServiceImpl(HomePage.class);

	Browser browser;

	public HomePage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(browser.getDriver(), this);
	}
	
	@FindBy(xpath="//a[@class='login']")
   WebElement btnSignin;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement storeLogo;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement btnSignout;
	
	public boolean validateStoreLogo() {
		report.info("Verify Page Logo");
		browser.getWait().implicitWait(30000);
		return storeLogo.isDisplayed();
	}
	
	public void clickOnSignIn() {
		report.info("Click on Sign in");
		btnSignin.click();
		browser.getWait().HardPause(10000);
		report.info("Scroll page down");
		browser.getPageScroll().down(400);
		browser.getWait().HardPause(10000);
	   
	}
	
	public void clickOnSignout() {
		report.info("Click on Signout");
		browser.getWait().HardPause(30000);
		btnSignout.click();
		browser.getWait().HardPause(30000);
	}
	
	

}

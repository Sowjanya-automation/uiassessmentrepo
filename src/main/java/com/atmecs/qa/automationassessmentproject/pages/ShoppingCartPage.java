package com.atmecs.qa.automationassessmentproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

//Shopping cart page
public class ShoppingCartPage {

	Browser browser;
	private ReportLogService report = new ReportLogServiceImpl(ShoppingCartPage.class);
	
	//Constructor
	public ShoppingCartPage(Browser browser) {
		this.browser = browser;	
		PageFactory.initElements(browser.getDriver(), this);		
	}
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement chkAgree;
	
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement bankwire;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement btnConfirmOrder;
	
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
	WebElement lnkBackToOrders;
	
	@FindBy(xpath="//tr[contains(@class,'first_item')]//span[contains(text(),'Details')]")
	WebElement details;
	
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement btncheckout;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement btnProceedcheckout;
	
	public void clickOnproceedToCheckout() {
		report.info("Click on proceed to checkout");
		browser.getWait().HardPause(5000);
		btnProceedToCheckout.click();		
	}
	
	public void clickOnproceedCheckout() {
		report.info("Click on proceed to checkout");
		browser.getWait().HardPause(5000);
		btnProceedcheckout.click();		
	}
	

	public void clickOnCheckout() {
		report.info("Click on proceed to checkout");
		browser.getWait().HardPause(5000);
		btncheckout.click();		
	}
	
	public void clickPolicyAgreement() {
		report.info("Click on policy agreement");
		browser.getWait().HardPause(5000);
		chkAgree.click();	
	}
	
	public void clickOnBankwire() {
		report.info("Click on Bankwire");
		browser.getWait().HardPause(5000);
		bankwire.click();	
	}
	
	public void clickOnConfirmOrder() {
		report.info("Click on ConfirmOrder");
		browser.getWait().HardPause(5000);
		btnConfirmOrder.click();	
	}
	
	public void clickOnBackToOrders() {
		report.info("Click on Back to orders");
		browser.getWait().HardPause(5000);
		lnkBackToOrders.click();	
	}
	
	public void clickOnDetails() {
		report.info("Click on Details");
		browser.getWait().HardPause(5000);
		details.click();	
	}
	
	
}

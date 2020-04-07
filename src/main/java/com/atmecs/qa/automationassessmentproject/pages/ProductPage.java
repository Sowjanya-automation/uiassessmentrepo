package com.atmecs.qa.automationassessmentproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

import junit.framework.Assert;

public class ProductPage {
	
	private ReportLogService report = new ReportLogServiceImpl(ProductPage.class);
	Browser browser;
	public ProductPage(Browser browser) {
		this.browser = browser;	
		PageFactory.initElements(browser.getDriver(), this);		
	}
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
	WebElement successCartingMessage;
	
	@FindBy(xpath="//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
	WebElement lnkcontinueShopping;
	
	public void enterQuantity() {
		report.info("Enter product quantity");
		browser.getWait().HardPause(5000);
		txtQuantity.clear();
		txtQuantity.sendKeys("1");
	}
	
	public void clickOnAddToCart() {
		report.info("Click on add to cart");
		browser.getWait().HardPause(5000);
		btnAddToCart.click();
	}
	
	public void clickOnProceedToCheckout() {
		report.info("Click on proceed to checkout");
		browser.getWait().HardPause(5000);
		btnProceedToCheckout.click();
	}
	
	public void selectSize() {
		report.info("Enter Size");
		browser.getWait().implicitWait(10000);
		browser.getSelectDropDown().selectByValue(LocatorType.ID, "group_1", "2");	
		browser.getPageScroll().down(300);
	}
	
	public void verifySuccessCartMessage() {
		report.info("Verifying Product successfully added to your shopping cart");
		String actualMessage = browser.getDriver().findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")).getText();
		
		System.out.println(actualMessage);
		
		if(actualMessage.contains("Product successfully added to your shopping cart"))
		{
			System.out.println("Expected text 'product successfully added message' is verified");
		}else {
			System.out.println("Expected text 'product successfully added message' is not verified");
		}	
	}
	
	public void clickOnContinueShopping() {
	report.info("Click on Continue shopping");
	browser.getWait().HardPause(5000);
	lnkcontinueShopping.click();	
	}
	
}

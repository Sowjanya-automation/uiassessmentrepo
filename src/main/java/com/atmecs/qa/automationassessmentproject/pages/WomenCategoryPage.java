package com.atmecs.qa.automationassessmentproject.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.utility.AppConstants;
import com.atmecs.qa.automationassessmentproject.utility.CommonUtils;

public class WomenCategoryPage {

	private ReportLogService report = new ReportLogServiceImpl(WomenCategoryPage.class);
	public static Properties props = CommonUtils.loadProperty(AppConstants.HOMEPAGE_PROPERTIES_FILE);

	Browser browser;
	public WomenCategoryPage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(browser.getDriver(), this);
	}

	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement womenCategory;

	@FindBy(xpath = "//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Tops')]")
	WebElement tops;

	@FindBy(xpath="//input[@id='layered_category_4'")
	WebElement chktopsCategory;

	@FindBy(xpath="/input[@id='layered_id_attribute_group_3']")
	WebElement chkLarge;

	@FindBy(xpath="//input[@id='layered_id_attribute_group_13']")
	WebElement chkOrange;

	@FindBy(xpath = "//input[@id='layered_id_feature_3']")
	WebElement chkViscose;

	@FindBy(xpath="//input[@id='layered_id_feature_11']")
	WebElement chkCasual;

	@FindBy(xpath="//input[@id='layered_id_feature_17']")
	WebElement chkshortSleeves;

	@FindBy(xpath="//input[@id='layered_quantity_1']")
	WebElement chkInstock;
	
	@FindBy(xpath="//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement productName;

	public void clickOnWomenCategory() {
		report.info("Click on women category");
		browser.getWait().implicitWait(20000);
		womenCategory.click();		
	}

	public void clickOnTops() {
		report.info("Click on Tops");
		browser.getWait().implicitWait(20000);
		tops.click();		
	}

	public void clickOnTopsCategory() {
		report.info("Click on Tops category");
		browser.getWait().implicitWait(20000);
		chktopsCategory.click();		
	} 

	public void clickOnLarge() {
		report.info("Click on Large");
		browser.getWait().implicitWait(20000);
		chkLarge.click();		    
	}
	public void clickOnOrange() {
		report.info("Click on Orange");
		browser.getWait().implicitWait(20000);
		chkOrange.click();		    
	} 

	public void clickOnViscose() {
		report.info("Click on Viscose");
		browser.getWait().implicitWait(20000);
		chkViscose.click();		    
	} 

	public void clickOnCasual() {
		report.info("Click on Casual");
		browser.getWait().implicitWait(20000);
		chkCasual.click();		    
	}

	public void clickOnSleeveles() {
		report.info("Click on Sleevelese");
		browser.getWait().implicitWait(20000);
		chkshortSleeves.click();		    
	}

	public void clickOnStock() {
		report.info("Click on In stock");
		browser.getWait().implicitWait(20000);
		chkInstock.click();		    
	}

	public void clickOnProdctName() {
		report.info("Click on product name");
		browser.getWait().implicitWait(20000);
		productName.click();	
	}

}

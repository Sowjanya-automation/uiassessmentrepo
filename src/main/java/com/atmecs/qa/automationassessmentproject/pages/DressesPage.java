package com.atmecs.qa.automationassessmentproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;


public class DressesPage {

	private ReportLogService report = new ReportLogServiceImpl(DressesPage.class);

	Browser browser;
	public DressesPage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(browser.getDriver(), this);
	}
	
	@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	WebElement tabDresses;
	
	@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	WebElement chkDresses;
	
	@FindBy(xpath="//a[contains(text(),'Printed Dress')]")
	WebElement printdress;
	
	@FindBy(xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Dress')]")
	WebElement printedDress;
	
	@FindBy(xpath="//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Casual Dresses')]")
	WebElement casualDresses;
	
	@FindBy(xpath="//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Evening Dresses')]")
	WebElement eveningDresses;
	
	@FindBy(xpath="//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Summer Dresses')]")
	WebElement summerDresses;

@FindBy(xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]")
WebElement printedChiffonDress;


public void clickOnDressesTab() {
	report.info("Click on dressestab ");
	browser.getWait().HardPause(10000);
	tabDresses.click();
}

public void clickOnCasualDressesLink() {
	report.info("Click on casual dresses");
	browser.getWait().HardPause(10000);
	casualDresses.click();
}

public void clickOnEveningDressesLink() {
	report.info("Click on evening dresses");
	browser.getWait().HardPause(10000);
	eveningDresses.click();
}

public void clickOnSummerDressesLink() {
	report.info("Click on summer dresses");
	browser.getWait().HardPause(10000);
	summerDresses.click();
}

public void selectProduct() {
	report.info("Select product");
	browser.getWait().HardPause(10000);
	printdress.click();
}

public void selectDress() {
	report.info("Select Dress");
	browser.getWait().HardPause(10000);
	printedChiffonDress.click();
}

public void selecteveningDress() {
	report.info("Select Dress");
	browser.getWait().HardPause(10000);
	printedDress.click();
}

}

package com.atmecs.qa.automationassessmentproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;



public class OrderDetailsPage {
	
	private ReportLogService report = new ReportLogServiceImpl(OrderDetailsPage.class);

	Browser browser;
	
	//Constructor
	public OrderDetailsPage(Browser browser) {
		this.browser = browser;
		PageFactory.initElements(browser.getDriver(), this);
	}
	
	//Verifying order history
	public void verifyOrderHistory() {
		String firstorder = browser.getDriver().findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[1]/td[2]/label")).getText();
		 System.out.println(firstorder); 
		 
		 if(firstorder.contains("Printed Dress - Color : Orange, Size : M")) {
				report.info("FirstProduct is successfully verified");
			}else {
				report.info("FirstProduct is not successfully verified");
			}
	
		 String secondorder = browser.getDriver().findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[2]/td[2]/label")).getText();
	
		 if(secondorder.contains("Printed Dress - Color : Beige, Size : M")) {
			 report.info("SecondProduct successfully verified");
			}else {
				report.info("SecondProduct is not successfully verified");
			}
		 
		 String thirdorder = browser.getDriver().findElement(By.xpath("//table[@class='table table-bordered']/tbody/tr[3]/td[2]/label")).getText();
			
		 if(thirdorder.contains("Printed Chiffon Dress - Color : Yellow, Size : M")) {
			 report.info("ThirdProduct is successfully verified");
			}else {
				report.info("ThirdProduct is not successfully verified");
			}
	}

}

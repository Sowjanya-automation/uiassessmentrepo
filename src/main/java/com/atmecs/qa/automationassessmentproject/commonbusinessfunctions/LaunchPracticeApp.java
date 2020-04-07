package com.atmecs.qa.automationassessmentproject.commonbusinessfunctions;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class LaunchPracticeApp {

	private ReportLogService report = new ReportLogServiceImpl(LaunchPracticeApp.class);
	public Browser browser;

	public LaunchPracticeApp(Browser browser) {
		this.browser = browser;
	}


	public void launchAppPage(String os, String osVersion, String br, String browserVersion) {
		report.info("Launch shopping page");
		browser.openURL("http://automationpractice.com/index.php ", os, osVersion, br, browserVersion);
		browser.getWait().implicitWait(60000);
		report.info("Maximixe browser window");
		browser.maximizeWindow();
		report.info("Wait for page to load");
		browser.getWait().implicitWait(60000);

	}

}

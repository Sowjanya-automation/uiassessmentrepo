package com.atmecs.qa.automationassessmentproject.testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.commonbusinessfunctions.LaunchPracticeApp;
import com.atmecs.qa.automationassessmentproject.pages.HomePage;
import com.atmecs.qa.automationassessmentproject.pages.SignInPage;
import com.atmecs.qa.automationassessmentproject.testsuite.SampleTestSuiteBase;

public class SigninIntoApplication extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(SigninIntoApplication.class); 
	LaunchPracticeApp alp;	
	HomePage hp;
	SignInPage sip;


	@BeforeClass
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void openShoppingPage(String os, String osVersion, String br, String browserVersion)  {		
		alp= new LaunchPracticeApp(browser);
		alp.launchAppPage(os, osVersion, br, browserVersion);
	}

	@Test
	public void loginIntoApp(String username, String password) throws Throwable {
		report.info("Sign into an application");
		hp= new HomePage(browser);		
		hp.validateStoreLogo();
		hp.clickOnSignIn();
		sip = new SignInPage(browser);
		sip.enterUsername(username);
		sip.enterPassword(password);
		sip.clickonSignin();
	}

}

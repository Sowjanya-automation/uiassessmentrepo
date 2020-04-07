package com.atmecs.qa.automationassessmentproject.testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.commonbusinessfunctions.LaunchPracticeApp;
import com.atmecs.qa.automationassessmentproject.dataprovider.ExcelReader;
import com.atmecs.qa.automationassessmentproject.pages.HomePage;

import com.atmecs.qa.automationassessmentproject.pages.SignInPage;
import com.atmecs.qa.automationassessmentproject.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.automationassessmentproject.utility.AppConstants;


public class NewCustomerRegistration extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(NewCustomerRegistration.class); 
	ExcelReader testData = new ExcelReader();
	LaunchPracticeApp alp;
	HomePage hp;
	SignInPage sip;

	String testDataFilePath = AppConstants.TESTDATA_EXCELFILE_PATH;
	String testDataSheetName = "Registration";

	@BeforeClass
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void openShoppingPage(String os, String osVersion, String br, String browserVersion)  {		
		alp= new LaunchPracticeApp(browser);		
			
		alp.launchAppPage(os, osVersion, br, browserVersion);

	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		Object[][] testdata1=testData.Registrationdata(testDataFilePath, testDataSheetName);
		return testdata1;
	}


	@Test(dataProvider = "testdata")
	public void RegisteraMember(String emailAddress,String firstname, String lastname, String password,String address,String city,String postcode,String mobilenumber) {

		report.info("Register a new customer ");
		hp= new HomePage(browser);
		hp.validateStoreLogo();
		hp.clickOnSignIn();
		
		hp.clickOnSignout();
		

	}		  

}

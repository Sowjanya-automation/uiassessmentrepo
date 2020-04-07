package com.atmecs.qa.automationassessmentproject.testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.qa.automationassessmentproject.commonbusinessfunctions.LaunchPracticeApp;
import com.atmecs.qa.automationassessmentproject.dataprovider.ExcelReader;
import com.atmecs.qa.automationassessmentproject.pages.DressesPage;
import com.atmecs.qa.automationassessmentproject.pages.HomePage;
import com.atmecs.qa.automationassessmentproject.pages.OrderDetailsPage;
import com.atmecs.qa.automationassessmentproject.pages.ProductPage;
import com.atmecs.qa.automationassessmentproject.pages.ShoppingCartPage;
import com.atmecs.qa.automationassessmentproject.pages.SignInPage;
import com.atmecs.qa.automationassessmentproject.testsuite.SampleTestSuiteBase;
import com.atmecs.qa.automationassessmentproject.utility.AppConstants;

public class TC_01_Verify_Order_Details_Of_Dresses_For_Three_Categories extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(TC_01_Verify_Order_Details_Of_Dresses_For_Three_Categories.class); 
	ExcelReader testData = new ExcelReader();
	LaunchPracticeApp alp;
	HomePage hp;
	SignInPage sip;
	DressesPage dp;
	ProductPage pp;
	ShoppingCartPage scp;
	OrderDetailsPage odp;

	//Intializing the Test data path & sheet name
	String testDataFilePath = AppConstants.TESTDATA_EXCELFILE_PATH;
	String testDataSheetName = "Signin";

	//Launching the application
	@BeforeClass
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void openShoppingPage(String os, String osVersion, String br, String browserVersion)  {		
		alp= new LaunchPracticeApp(browser);				
		alp.launchAppPage(os, osVersion, br, browserVersion);
	}

	//Accessing the test data
	@DataProvider(name = "testdata")
	public Object[][] getTestData() {
		Object[][] testdata1=testData.Registrationdata(testDataFilePath, testDataSheetName);
		return testdata1;
	}
	
	//Verifying the order details in the order history
	@Test(dataProvider = "testdata")
	public void verifyOrdersDetailsOfDresses(String username, String password) throws Throwable {
		try {
		//Initializing the homepage object
		hp= new HomePage(browser);
		// Validating the storelogo on web page
		hp.validateStoreLogo();
		// Click on sign in button
		hp.clickOnSignIn();
		//Initializing the signin object
		report.info("Sign into an application");
		sip = new SignInPage(browser);
		//Enter email address
		sip.enterUsername(username);
		//Enter password
		sip.enterPassword(password);
		//Click on submit button
		sip.clickonSignin();
		//Initializing the dressespage object
		dp = new DressesPage(browser);
		//Click on dresses tab
		dp.clickOnDressesTab();
		//Click on casual dresses tab
		dp.clickOnCasualDressesLink();
		//Select product
		dp.selectProduct();
		//Initializing the productpage object
		pp = new ProductPage(browser);
		//Enter quantity of product
		pp.enterQuantity();
		//Select size
		pp.selectSize();
		//click add to cart button
		pp.clickOnAddToCart();
		//Verify success message when product added to cart
		pp.verifySuccessCartMessage();
		//Click on continue shopping link
		pp.clickOnContinueShopping();	
		//Click on dresses tab
		dp.clickOnDressesTab();
		//Click on evening dresses tab
		dp.clickOnEveningDressesLink();
		//Select product
		dp.selecteveningDress();
		//Enter quantity of product
		pp.enterQuantity();
		//Select size
		pp.selectSize();
		//click add to cart button
		pp.clickOnAddToCart();
		//Verify success message when product added to cart
		pp.verifySuccessCartMessage();
		//Click on continue shopping link
		pp.clickOnContinueShopping();
		//Click on dresses tab
		dp.clickOnDressesTab();
		//Click on summer dresses tab
		dp.clickOnSummerDressesLink();
		dp.selectDress();
		//Enter quantity of product
		pp.enterQuantity();
		//Select size
		pp.selectSize();
		//click add to cart button
		pp.clickOnAddToCart();
		//Verify success message when product added to cart
		pp.verifySuccessCartMessage();
		pp.clickOnProceedToCheckout();
		//Initializing the shopping cart page object
		scp = new ShoppingCartPage(browser);
		// Click on proceed to checkout
		scp.clickOnproceedToCheckout();
		scp.clickOnCheckout();
		//Click on checkbox to accept agreement
		scp.clickPolicyAgreement();
		// Click on proceed to checkout
		scp.clickOnproceedCheckout();
		// Click on payment option bank wire
		scp.clickOnBankwire();
		//Conform the order
		scp.clickOnConfirmOrder();
		//Click on back to order
		scp.clickOnBackToOrders();
		//Click on details
		scp.clickOnDetails();
		//Initializing the order details page object
		odp = new OrderDetailsPage(browser);
		//Verify order history
		odp.verifyOrderHistory();
		//click on sign out
		hp.clickOnSignout();
		}catch (Exception ex) {
		ex.printStackTrace();
		}
	}
	
}

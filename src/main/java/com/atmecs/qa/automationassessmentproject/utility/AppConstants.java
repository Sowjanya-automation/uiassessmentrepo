package com.atmecs.qa.automationassessmentproject.utility;

import java.io.File;

public class AppConstants {

	public static final String USER_DIR = System.getProperty("user.dir") + File.separator;

	public static final String RESOURCE_DIR = USER_DIR + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator;
	
	public static final String TESTDATA_FILE_PATH = RESOURCE_DIR + "testdata" + File.separator + "credentials.properties";
	
	public static final String CONFIG_FILE_PATH = RESOURCE_DIR + "config.properties";

	public static final String HOMEPAGE_PROPERTIES_FILE = RESOURCE_DIR + "locators" + File.separator
			+ "homepage.properties";
	
	public static final String SIGNINPAGE_PROPERTIES_FILE = RESOURCE_DIR + "locators" + File.separator
			+ "signin.properties";
	
	public static final String REGISTRATION_PROPERTIES_FILE = RESOURCE_DIR + "locators" + File.separator
			+ "registration.properties";

	public static final String TESTDATA_EXCELFILE_PATH = RESOURCE_DIR + "testdata" + File.separator + "MyOrder.xlsx";
	

}

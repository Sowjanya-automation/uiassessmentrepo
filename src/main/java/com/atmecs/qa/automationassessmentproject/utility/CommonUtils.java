package com.atmecs.qa.automationassessmentproject.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CommonUtils {
	
	public static String getScreenShot(ITestResult result, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + "_" + LocalDate.now()
		+ ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			System.out.println("Captured Failed" + e.getMessage());
		}
		return path;
	}

	public static Properties loadProperty(String filePath) {

		try {
			Properties props = new Properties();
			FileInputStream ip = null;
			ip = new FileInputStream(filePath);
			props.load(ip);
			return props;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

		
	}
	
	public static JSONObject getJSONObjectFromFilePath(String filePath)
			throws FileNotFoundException, IOException, ParseException {
		return (JSONObject) new JSONParser().parse(new FileReader(filePath));
	}


}

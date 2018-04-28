package com.qa.base;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Login.IEmployee_Login;
import com.qa.util.CaptureScreenshot;
import com.qa.util.Mail;
import com.qa.util.OR;
import com.qa.util.ReadCredentials;

import jxl.read.biff.BiffException;


public class IEmployee_Base {

	 WebDriver driver;
	 IEmployee_Login objlogin;
	 Mail objmail;
	 CaptureScreenshot objCaptureScreenshot;
	 OR OR;
	 ReadCredentials objReadCredentials;
	 @SuppressWarnings("rawtypes")
	HashMap hm;
	
	 
	 @BeforeSuite
	 public void setUpFile() throws FileNotFoundException, IOException, BiffException
	 {
		// FileUtils.deleteDirectory(new File("Output_Folder/Screenshots"));
		 System.setOut(new PrintStream(new FileOutputStream("Output_Folder//OutputReport.txt")));
		 OR = new OR();
		 objReadCredentials = new ReadCredentials();
		 hm = objReadCredentials.hm;
	 }
	 
	 @BeforeTest
	 public void setUp() {
		 switch(OR.BROWSER) {
		 case "Firefox":
		 System.setProperty("webdriver.gecko.driver", OR.GECKO);
		 driver =new FirefoxDriver();
		 break;
		 case "Chrome":
		 System.setProperty("webdriver.chrome.driver", OR.CHROMEDRIVER);
		 driver =new ChromeDriver();
		 break;
		 case "IE":
			 System.setProperty("webdriver.IE.driver", OR.IEDRIVER);
			 driver = new InternetExplorerDriver();
		 break;
			

		 }
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	 }
		
	 	 
	 @BeforeClass
	 public void CaptureScreen() {
		 objCaptureScreenshot = new CaptureScreenshot(driver);
	 }
	 
	 @Test(priority=1)
		public void launchUrl() {
			if(hm.containsKey("Launch Url") && hm.get("Launch Url").equals("Yes")){
				driver.get(OR.URL);
			}
			else {
				throw new SkipException("Tese Case is Skipped");
			}
		}
	 
	 @Test(priority=2)
		public void testLogin() throws IOException {
			if(hm.containsKey("Login") && hm.get("Login").equals("Yes")){
				objlogin = new IEmployee_Login(driver);
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				objlogin.BaseMethod(objReadCredentials.CropID, objReadCredentials.Username, objReadCredentials.Password);
				
			}
			else {
				throw new SkipException("Tese Case is Skipped");
			}
	 }
	 
	 @Test(priority=3)
		public void testLogout() {
			if(hm.containsKey("Logout") && hm.get("Logout").equals("Yes")){
				System.out.println("Logout method");
			}
			else {
				throw new SkipException("Tese Case is Skipped");
			}
		}

	 @SuppressWarnings("static-access")
	 @AfterMethod
	 public void screenShots(ITestResult mResult) throws IOException {
	 	if(mResult.FAILURE==mResult.getStatus()) {
	 		objCaptureScreenshot.TakeScreensot(driver,mResult);
	 	}
	 		
	 }

 @AfterSuite
	 public void tearDown() {
	 	//driver.quit();
	 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 
	 
	 }

	 }


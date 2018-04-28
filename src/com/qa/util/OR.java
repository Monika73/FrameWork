package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class OR {

	public String GECKO;
	public String URL;
	public String CHROMEDRIVER;
	public String IEDRIVER;
	public String BROWSER;
	
	public By CORPID;
	public By USERNAME;
	public By PASSWORD;
	public By LOGIN;
	public By Logout;
	
	public OR() throws FileNotFoundException, IOException
	{
		Properties prob = new Properties();
		prob.load(new FileInputStream("Input_Folder/Details.properties"));
		
		GECKO =prob.getProperty("GECKO");
		CHROMEDRIVER = prob.getProperty("CHROMEDRIVER");
		BROWSER = prob.getProperty("BROWSER");
		URL =prob.getProperty("URL");
		CORPID =By.xpath(prob.getProperty("CORPID"));
		USERNAME =By.xpath(prob.getProperty("USERNAME"));
		PASSWORD =By.xpath(prob.getProperty("PASSWORD"));
		LOGIN =By.xpath(prob.getProperty("LOGIN"));
		Logout =By.xpath(prob.getProperty("LOGOUT"));
	
		
	}
	
	
}

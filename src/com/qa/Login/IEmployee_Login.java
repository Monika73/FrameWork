package com.qa.Login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.util.ActionKeyword;
import com.qa.util.OR;

public class IEmployee_Login {
	ActionKeyword KeyMethod;
	WebDriver driver;		
	OR OR;
	
	public IEmployee_Login(WebDriver driver) throws FileNotFoundException, IOException{
	this.driver = driver;
	OR = new OR();
	}	

	
	public void sendcropid(String CropID){
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(OR.CORPID).sendKeys(CropID);
		KeyMethod.text(OR.CORPID, CropID);
	}
	
	public void sendUserName(String Username){
		//driver.findElement(OR.USERNAME).sendKeys(Username);
		KeyMethod.text(OR.USERNAME, Username);
	}
	
	public void sendPassword(String Password){
		//driver.findElement(OR.PASSWORD).sendKeys(Password);
		KeyMethod.text(OR.PASSWORD, Password);
	}
	

	public void clickLogin(){
		//driver.findElement(OR.LOGIN).click();
		KeyMethod.click(OR.LOGIN);
		}
	
	public void clickLogout(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(OR.Logout).click();
		KeyMethod.click(OR.Logout);
		}
	
	
		
		public void BaseMethod(String CropID, String Username, String Password) throws FileNotFoundException, IOException
		{
			this.sendcropid(CropID);
			this.sendUserName(Username);
			this.sendPassword(Password);
			this.clickLogin();
			this.clickLogout();
		}
		
	}
	


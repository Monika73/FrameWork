package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeyword {
	
	WebDriver driver;
	
	public ActionKeyword(WebDriver driver) {
		this.driver= driver;
		
	}
public void text(By locator, String text) {
	driver.findElement(locator).sendKeys(text);
	
}
	public void text(String locator_1, int variable, String locator_2, String text) {
		driver.findElement(By.xpath(locator_1+variable+locator_2)).sendKeys(text);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void click(String locator_1, int variable, String Locator_2) {
		driver.findElement(By.xpath(locator_1+variable+Locator_2)).click();
	}
	
	public void JSclick(By locator) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", locator);
	}
	
	public void eWaitClick(By locator) {
		WebDriverWait Wait = new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	public String getAttribute(By locator, String param) {
		String attribute = driver.findElement(locator).getAttribute(param);
		return attribute;
	}

	
	

}


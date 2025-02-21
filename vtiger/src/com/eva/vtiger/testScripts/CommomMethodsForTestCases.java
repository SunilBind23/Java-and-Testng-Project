package com.eva.vtiger.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;

public class CommomMethodsForTestCases  {
public void WebElement(WebDriver driver,String xpathvalue,ExtentReports extTest) {
	try {
		driver.findElement(By.xpath(xpathvalue));
	}catch(NoSuchElementException e) {
		String rightXpath="";
		driver.findElement(By.xpath(rightXpath));
		
	}catch(InvalidSelectorException e) {
		String validXpath="";
		driver.findElement(By.xpath(validXpath));
		
	}catch(NullPointerException e) {
		String validXpath="";
		driver.findElement(By.xpath(validXpath));
		
	}catch(Exception e) {
		
	}
	
	
}

public void Myclick(WebDriver driver) {
	try {
		
	}
	
	catch(ElementClickInterceptedException e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", weElement);
		
	}catch (ElementNotInteractableException e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", weElement);
		
	}catch(InvalidSelectorException e) {
		
	}
	
	catch(InvalidElementStateException e) {
		
	}
		
	}catch(StaleElementReferenceException e) {
		
	
}
}

package com.eva.vtiger.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericMethod {
public static WebDriver driver;
public static WebDriver launchBrowser(String browserName) {
	  
	switch (browserName) {
	
	case "chrome":
		driver=new ChromeDriver();
		break;
	case "edge":
		driver=new EdgeDriver();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
		default:
			System.out.println("browser not found ");
	}
	return driver;
	
}
}

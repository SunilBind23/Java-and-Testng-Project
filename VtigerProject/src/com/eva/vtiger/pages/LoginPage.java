package com.eva.vtiger.pages;

import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class LoginPage {
	
	private WebUtil gm;
	public LoginPage(WebUtil webUtil) {
		gm=webUtil;
	}

	// ======================= launch browser and hit URL ==============

	public void OpenVTigerLoginPage() {
		
		gm.launchBrowser("chrome", 15);
		gm.openURL("http://localhost:8888/");
		gm.WindowMaximise();
		
	}
	
	
//	======================= Login VTiger ============================

	public void validLogin(WebUtil gm) {

		WebElement uName = gm.getWebElement(By.xpath("//input[@name='user_name']"), "Username text box");
		gm.type(uName, "admin", "Username text box");

		WebElement uPassword = gm.getWebElement(By.xpath("//input[@name='user_password']"), "User Password Text Box");
		gm.type(uPassword, "admin", "User Password Text Box");

		WebElement loginButton = gm.getWebElement(By.xpath("//input[@id='submitButton']"), "Login Button");
		gm.click(loginButton, "Login Button");

	}
	
	
	
}

package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eva.vtiger.utils.WebUtil;

public class LoginPage {

	// ======================= launch browser and hit URL ==============

	public void OpenVTigerLoginPage(WebUtil gm) {
		
		gm.launchBrowser("chrome", 15);
		gm.openURL("http://localhost:8888/");
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

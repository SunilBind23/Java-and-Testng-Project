package com.eva.OpenCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eva.OpenCart.Webutils.Webutils;

public class OpenApplication {

	private Webutils wt;
	public OpenApplication(Webutils webUtils) {
		wt=webUtils;
	}
	
	public void OpenApp() {
		wt.launchBrowser("chrome");
		wt.hitURl("http://localhost/Opencart");
		wt.maxiMise();

	}

	public void ClickOnRegisterAccount() {
////
		WebElement element = wt.getWebElement(By.xpath("//a[@title='My Account']"));
		wt.Click(element, "Account ");

		WebElement Register = wt.getWebElement(By.xpath("//a[text()='Register']"));
		wt.Click(Register, "Register");
	}
}

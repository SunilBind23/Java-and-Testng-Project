package com.eva.OpenCart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eva.OpenCart.Webutils.Webutils;

public class RegisterAccountPage {

	private Webutils wt;

	public RegisterAccountPage(Webutils webUtil) {
		wt = webUtil;
	}

	public void EnterFirstName(String Fname) {

		wt.InputData(wt.getWebElement(By.name("firstname")), Fname, "Firstname input box");
	}

	public void EnterLasttName(String Lname) {

		wt.InputData(wt.getWebElement(By.name("lastname")), Lname, "laststname input box");
	}

	public void EnterEmail(String Email) {

		wt.InputData(wt.getWebElement(By.name("email")), Email, "lastname input box");
	}

	public void EnterTelephone(String telephone) {

		wt.InputData(wt.getWebElement(By.name("telephone")), telephone, "telephone input box");
	}

	public void EnterPassword(String Password) {

		wt.InputData(wt.getWebElement(By.name("password")), Password, "Password input box");
	}

	public void EnterConfirmPassword(String CPassword) {

		wt.InputData(wt.getWebElement(By.name("confirm")), CPassword, "CPassword input box");
	}

	public void SubscribeYes() {

		wt.Click(wt.getWebElement(By.name("newsletter")), "Subcribe");
	}

	public void PrivencyPolicyCkeck() {
		wt.Click(wt.getWebElement(By.name("agree")), "Privency Policy");
	}

	public void Continue() {
		wt.Click(wt.getWebElement(By.xpath("//input[@value='Continue']")), "Continue");
	}

	public void warningMsg(String Expectedtext) {
		WebElement element = wt.getWebElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

		wt.verifyInnerText(element, Expectedtext);
		
	}

	public void allRequiredMsg() {
		wt.getWebElements(By.xpath("//div[@class='text-danger']"));
		

	}

}

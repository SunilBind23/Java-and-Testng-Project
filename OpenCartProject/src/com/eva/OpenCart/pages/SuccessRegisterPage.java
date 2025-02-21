package com.eva.OpenCart.pages;

import org.openqa.selenium.By;

import com.eva.OpenCart.Webutils.Webutils;

public class SuccessRegisterPage {
	private Webutils wt;

	public SuccessRegisterPage(Webutils webutil) {
		wt = webutil;
	}

	public void checkSuccessMassage(String ExpectedMassage) {
		wt.verifyInnerText(wt.getWebElement(By.xpath("//h1[text()='Your Account Has Been Created!']")),
				ExpectedMassage);
	}

	public void clickOnCOntinue() {

		wt.Click(wt.getWebElement(By.linkText("Continue")), "Cotinue");
	}

}

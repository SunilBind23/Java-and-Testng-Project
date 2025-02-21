package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eva.vtiger.utils.WebUtil;

public class LeadsPage {

	public void clickCreateLeadPlusButton(WebUtil wu) {
		WebElement weCreateLeadBT=wu.getWebElement(By.xpath("//img[@title='Create Lead...']"), "Create Lead Button");
		wu.click(weCreateLeadBT, "Create Lead Button");
	}
	
	
}

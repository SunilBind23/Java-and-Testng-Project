package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class LeadsPage {

	private WebUtil wu;

	public LeadsPage(WebUtil webutil) {
		wu = webutil;
	}

	public void clickCreateLeadPlusButton() {
		WebElement weCreateLeadBT = wu.getWebElement(By.xpath("//img[@title='Create Lead...']"), "Create Lead Button");
		wu.click(weCreateLeadBT, "Create Lead Button");

	}

	public void searchLeads(String searchLeadsValue) {
		
		wu.type(wu.getWebElement(By.name("search_text"), "search"), searchLeadsValue, "search");
		}
	
	public void selectLeadBy() {
		wu.selectByIndex(wu.getWebElement(By.name("bas_searchfield"), "select lead by "), "select lead by", 0);
	}
	public void clickonSearchLead() {
		
	}
}

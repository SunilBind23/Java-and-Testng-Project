package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eva.vtiger.utils.WebUtil;

public class HomePage {

	
	public void gotoLeadsPage(WebUtil wu) {
		WebElement weLeadsLink=wu.getWebElement(By.xpath("//a[text()='Leads']"), "Leads Module");
		wu.click(weLeadsLink, "Leads Module");
	}
	
	public void gotoOrganizationPage(WebUtil wu) {
		WebElement weOrganizationsLink=wu.getWebElement(By.xpath("//a[text()='Organizations']"), "Organizations Module");
		wu.click(weOrganizationsLink, "Organizations Module");
	}
	
	public void gotoCampaignsPage(WebUtil wu) {
		WebElement weMoreLink=wu.getWebElement(By.xpath("//a[text()='More']"), "More Link");
        wu.mouseOverActions(weMoreLink, "More Link");
		
		WebElement weCampaignsLink=wu.getWebElement(By.xpath("//a[text()='Campaigns']"), "Campaigns Module");
		wu.click(weCampaignsLink, "Campaigns Module");
	}	
	
	
}

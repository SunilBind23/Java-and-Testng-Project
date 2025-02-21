package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class HomePage {
	private WebUtil wu;

	public HomePage(WebUtil webUtil) {
		wu = webUtil;
	}

	public void gotoLeadsPage() {
		WebElement weLeadsLink = wu.getWebElement(By.xpath("//a[text()='Leads']"), "Leads Module");
		wu.click(weLeadsLink, "Leads Module");
	}

	public void gotoOrganizationPage() {
		WebElement weOrganizationsLink = wu.getWebElement(By.xpath("//a[text()='Organizations']"),
				"Organizations Module");
		wu.click(weOrganizationsLink, "Organizations Module");
	}

	public void gotoCampaignsPage() {
		WebElement weMoreLink = wu.getWebElement(By.xpath("//a[text()='More']"), "More Link");
		wu.mouseOverActions(weMoreLink, "More Link");

		WebElement weCampaignsLink = wu.getWebElement(By.xpath("//a[text()='Campaigns']"), "Campaigns Module");
		wu.click(weCampaignsLink, "Campaigns Module");
	}

	public void goTOCalanderPage() {
		WebElement weMoreLink = wu.getWebElement(By.xpath("//a[text()='Calendar']"), "Calendar");
		wu.click(weMoreLink, "Calendar");

		
	}

}

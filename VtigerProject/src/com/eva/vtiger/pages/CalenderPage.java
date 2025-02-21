package com.eva.vtiger.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class CalenderPage {
	private WebUtil wu;

	public CalenderPage(WebUtil webUtils) {
		wu = webUtils;
	}

	public void MouseOverOnAdd() {
		WebElement el = wu.getWebElement(By.xpath("//td[@class='calAddButton']"), "Add over");
		wu.mouseOverActions(el, el.getText());
	}

	public void GetAllOverdElement() {
		List<WebElement> elments = wu.getWebElementsList(By.xpath("//a[@class='drop_down']"), "All Options");

		for (WebElement el : elments) {
			wu.mouseOverActions(el, el.getText());
		}
	}

	public void ClickCall() {
		WebElement el = wu.getWebElement(By.xpath("//a[@id='addcall']"), "Call");
		wu.click(el, el.getText());
	}

	public void verifyCalanderViewCreated() {
		WebElement element = wu.getWebElement(By.xpath("//span[@class='orgTab']"), "Testing");

		wu.verifyVisible(element, "Testing");
	}

	public void deleteCalenderRecords() {

		wu.mouseOverActions(wu.getWebElement(By.xpath("//div[@class='event']"), "Container"), "Container");

		wu.click(wu.getWebElement(By.xpath("//img[@src='themes/images/cal_event.jpg']"), "Arrow"), "Cursor");

		wu.click(wu.getWebElement(By.id("actdelete"), "actdelete"), "actdelete");
		
		wu.acceptAlert();
	}

}

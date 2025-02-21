package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class AddEventPageInCalender {

	private WebUtil wu;

	public AddEventPageInCalender(WebUtil webUtil) {
		wu = webUtil;
	}

	public void selectEventType(int index) {

		wu.selectByIndex(wu.getWebElement(By.id("activitytype"), "activitytype"), "activitytype", index);
	}

	public void enterEventName(String EventName) {
		WebElement el = wu.getWebElement(By.name("subject"), "EventName");
		wu.type(el, EventName, "Event fields");
	}

	public void selectStatus(int index) {
		wu.selectByIndex(wu.getWebElement(By.id("eventstatus"), "eventstatus"), "eventstatus", index);
	}

	public void selectPrivorty(int index) {
		wu.selectByIndex(wu.getWebElement(By.xpath("(//select[@id='taskpriority'])[1]"), "taskpriority"),
				"taskpriority", index);
	}

	public void sendEndDate(String EndDate) {
		WebElement element = wu.getWebElement(By.xpath("//input[@name='due_date']"), "End date");
		element.clear();
		wu.staticWait(2);
		wu.type(element, EndDate, "End date");

	}

	public void clickOnReletedTo() {
		// Related To
		WebElement element = wu.getWebElement(By.linkText("Related To"), "Related To");
		wu.click(element, "Releted");
	}

	public void clickOnRepeat() {

		WebElement element = wu.getWebElement(By.linkText("Repeat"), "Repeat");
		wu.click(element, "Repeat");
	}

	public void clickOnReminder() {

		WebElement element = wu.getWebElement(By.linkText("Reminder"), "Reminder");
		wu.click(element, "Reminder");
	}

	
	public void goONReletedSelectPage() {
		wu.switchToWindow_WithoutcloseRemainingTab("http://localhost:8888/index.php?module=Accounts&action=Popup");
		wu.getCurrentWindowTitle();
		wu.click(wu.getWebElement(By.linkText("EDFG Group Limited"), "Link"), "link selected");
	}
	
	
	
	public void clickOnInvite() {

		WebElement element = wu.getWebElement(By.linkText("Invite"), "Invite");
		wu.click(element, "Invite");
	}

	public void selectRelatedByValue(String value) {
		WebElement element = wu.getWebElement(By.name("parent_type"), "Releted");
		wu.selectByValue(element, wu.getInnerText(element, value), value);
	}
	public void selectParent(String value) {
		//(//input[@name='selectparent'])[1]
		WebElement element = wu.getWebElement(By.xpath("(//input[@name='selectparent'])[1]"), "selectparent");
		wu.click(element, value);
	}
	
	public void ClickOnSave() {
		
	WebElement el=	wu.getWebElement(By.xpath("(//input[@alt='Save [Alt+S]'])[1]"), "save");
	wu.click(el, "Save");
	
	}

}

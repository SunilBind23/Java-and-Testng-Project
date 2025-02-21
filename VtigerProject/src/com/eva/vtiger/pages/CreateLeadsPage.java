package com.eva.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebUtil;

public class CreateLeadsPage {

	private WebUtil wu;

	public CreateLeadsPage(WebUtil webUtil) {
		wu = webUtil;
	}

	public void selectValue(String SelectValue) {
		WebElement WeselectEl = wu.getWebElement(By.xpath("//select[@name='salutationtype']"), "Fname");
		wu.selectByValue(WeselectEl, "selectBox", SelectValue);
	}

	public void enterFirstName(String firstname) {
		wu.type(wu.getWebElement(By.name("firstname"), "firstname"), firstname, "Fname");
	}

	public void enterLastName(String lastname) {

		wu.type(wu.getWebElement(By.name("lastname"), "lastname"), lastname, "Lname");

		// "company");

	}

	public void enterCompany(String companyName) {
		wu.type(wu.getWebElement(By.name("company"), "company"), companyName, "comoany tblbox");
	}

	public void enterTitle(String designation) {
		wu.type(wu.getWebElement(By.id("designation"), "designation"), designation, "Title tblbox");
	}

	public void SelectLeadsource(String leadsourcevalue) {
		wu.selectByValue(wu.getWebElement(By.name("leadsource"), "leadsource"), leadsourcevalue, "LeadSource tblbox");
	}

	public void SelectIndustry(String Industryvalue) {
		wu.selectByValue(wu.getWebElement(By.name("industry"), "industry"), Industryvalue, "Industry tblbox");
	}

	public void SelectLeadStatus(String selectLeadStatus) {
		wu.selectByValue(wu.getWebElement(By.name("leadstatus"), "leadstatus"), selectLeadStatus, "LeadStatus tblbox");
	}

	public void SelectRating(String selectRatingValue) {
		wu.selectByValue(wu.getWebElement(By.name("rating"), "Rating"), selectRatingValue, "Rating tblbox");
	}

	public void enterPhone(String phoneNumber) {
		wu.selectByValue(wu.getWebElement(By.id("phone"), "phoneNumber"), phoneNumber, "phoneNumber tblbox");
	}

	public void enterMobile(String mobileNumber) {
		wu.selectByValue(wu.getWebElement(By.id("mobile"), "mobileNumber"), mobileNumber, "mobileNumber tblbox");
	}

	public void clickOnSaveButton() {

		wu.click(wu.getWebElement(By.xpath("//input[@title='Save [Alt+S]']"), "save"), "save");
		////
	}

	public void openCalander() {
		wu.click(wu.getWebElement(By.xpath("//img[@alt='Open Calendar...']"), "open calendar"), "open calendar");
	}

	public void openCaluculator() {

		wu.click(wu.getWebElement(By.xpath("//img[@alt='Open Calculator...']"), "open Calculator"), "open Calculator");
	}

	public void openChat() {

		wu.click(wu.getWebElement(By.xpath("//img[@alt='Chat...']"), "open chat"), "open chat");
	}

	public void openLastViewed() {

		wu.click(wu.getWebElement(By.xpath("//img[@alt='Last Viewed']"), "LastViewed"), "LastViewed");
	}

	public void openImportLeads() {

		wu.click(wu.getWebElement(By.xpath("//img[@alt='Import Leads']"), "Import Leads"), "Import Leads");
	}

	public void openExportLeads() {

		wu.click(wu.getWebElement(By.xpath("//img[@alt='Export Leads']"), "ExportLeads"), "ExportLeads");
	}

	public void openLeadsSettings() {
		
		wu.click(wu.getWebElement(By.xpath("//img[@alt='Leads Settings']"), "Leads Settings"), "Leads Settings");
	}

}

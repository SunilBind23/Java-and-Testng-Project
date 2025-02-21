package com.eva.vtiger.testcases;

import com.eva.vtiger.pages.AddEventPageInCalender;
import com.eva.vtiger.pages.CalenderPage;
import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LoginPage;

import utils.WebUtil;

public class CalendarTestScript {
@Test
	public void verifyCalanderPage() {
		WebUtil wu = new WebUtil();
		LoginPage lp = new LoginPage(wu);
		lp.OpenVTigerLoginPage();
		lp.validLogin(wu);

		HomePage hp = new HomePage(wu);
		hp.goTOCalanderPage();

		CalenderPage clP = new CalenderPage(wu);
		
		clP.MouseOverOnAdd();
		clP.GetAllOverdElement();
		clP.ClickCall();
		

		AddEventPageInCalender addEvent = new AddEventPageInCalender(wu);
		addEvent.selectEventType(0);
		addEvent.enterEventName("Testing");
		addEvent.selectStatus(1);
		addEvent.sendEndDate("2025-11-14");
		addEvent.clickOnReletedTo();
		
		
		
		
		addEvent.selectRelatedByValue("Accounts");
		addEvent.selectParent("selected");
		addEvent.goONReletedSelectPage();
		///addEvent.ClickOnSave();
//	
//		clP.verifyCalanderViewCreated();
//		clP.deleteCalenderRecords();
//		clP.verifyCalanderViewCreated();
		
	}
}

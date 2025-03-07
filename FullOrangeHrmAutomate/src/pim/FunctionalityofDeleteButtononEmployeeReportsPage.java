package pim;

package com.hrm.testcases.PIMTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PIMPage;
import com.hrm.pages.ReportPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class FunctionalityofDeleteButtononEmployeeReportsPage extends TestBase {
	
	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Reports
	4.Select any Reports you want to Delete by clicking on Checkbox
	5.Click On Delete Button
	6.OrangeHRM - Confirmation Required window should be opens*/
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Delete Button on Employee Reports Page Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}
	
	@Test(description="HRMS-39:Functionality of Delete Button on Employee Reports Page")
	public void FunctionalityofDeleteButtononEmployeeReportsPage()  {
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			takeScreenShot("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnReports();
			ReportPage reportpage=new ReportPage();
			reportpage.clickOnAddButton();
			Thread.sleep(1000);
			reportpage.clickOnSaveButton();
			reportpage.clickDeleteButton(TestConfig.ReportName);
			Assert.assertEquals(true, reportpage.isDeleterecordsTextDisplayed());
			Log.info("Test Case Pass");
			takeScreenShot("Test Case Pass");
			reportpage.clickOnOKButton();
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Test Case Fail.");
		}	

	}
	@AfterMethod
	public void tearDown(){
		topnevigationmenupage.ClickOnUserName();
		Log.endTestCase();
		driver.quit();
		
	}





}
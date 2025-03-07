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

public class FunctionalityofSearchButtononEmployeeReportsPage extends TestBase {
	
	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Reports
	4.Enter Report name in Report name Text box
	5.Click On Search Button
	6.Verify Search Reports Should be Displayed*/
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Search Button on Employee Reports Page Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}
	
	@Test(description="HRMS-42:Functionality of Search Button on Employee Reports Page")
	public void FunctionalityofSearchButtononEmployeeReportsPage()  {
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
			reportpage.clickOnSearchButton(TestConfig.ReportName);
			Assert.assertEquals(true, reportpage.verifyCreatedsReportisDisplayed(TestConfig.ReportName));
			Log.info("Test Case Pass");
			takeScreenShot("Test Case Pass");
			reportpage.DeleteReport(TestConfig.ReportName);
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

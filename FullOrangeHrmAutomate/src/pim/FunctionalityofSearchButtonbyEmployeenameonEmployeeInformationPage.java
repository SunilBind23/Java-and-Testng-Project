package pim;

package com.hrm.testcases.PIMTab;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmployeeListPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PIMPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;
import com.hrm.util.TestConfig;

public class FunctionalityofSearchButtonbyEmployeenameonEmployeeInformationPage extends TestBase {

	/*1:Login  to HRMS with proper Credentials 
	2.Click On PIM tab 
	3.Click On Employee List
	4.Enter Employee name in Employee Name text box
	5.Click on Search Button*/

	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PIMPage pimpageobjects=null;
	TopNevigationMenuPage topnevigationmenupage;
	EmployeeListPage employeelistpage;

	@BeforeMethod
	public void setUp() {
		initialization();
		topnevigationmenupage=new TopNevigationMenuPage();
		Log.startTestCase("-------Functionality of Search Button by Employee name on Employee Information Page Stated-----------");
		LoginPage loginPage =new LoginPage();
		dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
		Log.info("Login Successfully");
	}

	@Test(description="HRMS-19:Functionality of Search Button by Employee name on Employee Information Page")
	public void FunctionalityofSearchButtonbyEmployeenameonEmployeeInformationPage(){
		try{
			pimpageobjects=dashboardPage.clickOnPIMTab();
			Log.info("PIM tab Clicked");
			Thread.sleep(1000);
			pimpageobjects.clickOnEmployeeList();
			Thread.sleep(1000);
			EmployeeListPage employeelist=new EmployeeListPage();
			Thread.sleep(1000);
			employeelist.clickOnSearchButton(TestConfig.Employee_Frist_Name);
			Thread.sleep(1000);
			Assert.assertEquals(true, employeelist.isAddedEmployeeDisplayed(TestConfig.Employee_Frist_Name));
			Log.info("Test Case pass");
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Test Case Fail.");
		}	
	}

	@AfterMethod
	public void tearDown(){
		topnevigationmenupage.ClickOnUserName();
		driver.quit();
		Log.endTestCase();
	}
}

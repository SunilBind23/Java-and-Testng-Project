package PerformancePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.PerformancePage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class Trackers_DeleteRecords extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage=null;
	PerformancePage performancePage=null;
	TopNevigationMenuPage topnevigationmenupage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dashboardPage=new DashboardPage();
		performancePage=new PerformancePage();
		topnevigationmenupage=new TopNevigationMenuPage();
	}
	
	@Test(description=" HRMS-100:Delete record from Performance Tracker table")
	public void DeleteRecordFromPerformanceTracker (){
		try{
			Log.startTestCase("-------Verify Performance Tab Test Case Stated-----------");			
			dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			takeScreenShot("Login Successfully");			
			Log.info("Performance Tab is Present");
			performancePage.hoverOnPerformanceTab();
			Log.info("Hover on Performance Tab");
			takeScreenShot("Test Case Pass");				
			performancePage.hoverOnConfigureTab();
			Log.info("Hover on Configure Tab");
			performancePage.clickTrackersTab();
			Log.info("Click on Trackers Subtab");
			performancePage.clickAddBtn();	
			performancePage.enterTrackerNameTextBox("Automation Tester");
			performancePage.enterEmployeeNameTextBox("Pallavi Yadav");
			//String AssignedReviewverName=performancePage.getFristOptionAvailableReviewvers();
			performancePage.AddAvailableReviewertoAssignedReviewver();
			performancePage.enterEmployeeNameTextBox("Pallavi Yadav");
			performancePage.clickTrackersSaveBtn();
			performancePage.clickTrackerchkSelectAll();
			performancePage.clickTrackersDeleteBtn();
			performancePage.clickTrackersDialogDeleteBtn();
			Assert.assertEquals(true,performancePage.DeleteSuccessMessage());			
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.assertFalse(true, "Could not login.");
		}	
		finally{
			topnevigationmenupage.ClickOnUserName();
			Log.info("-------Verify Performance Tab Test Case Finished-----------");
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
package admintab;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.TestBase;
import com.hrm.pages.AdminPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.TopNevigationMenuPage;
import com.hrm.util.Config;
import com.hrm.util.Log;

public class DeleteWorkShift extends TestBase{
	AdminPage usermgmtpage=null;
	LoginPage loginPage=null;
	DashboardPage dashboardPage;
	TopNevigationMenuPage topnevigationmenupage;
	    
	    @BeforeMethod
	    public void setUp() {
		    initialization();
		    topnevigationmenupage=new TopNevigationMenuPage();
		    
	    }
		
		@Test(description="HRMS-25:Deleting Work Shift")
		public void DeletingWorkShift() {
			try {
				Log.startTestCase("-------Functionality of Deleting Work Shift-----------");
				LoginPage loginPage =new LoginPage();
			    dashboardPage=loginPage.loginToApp(Config.getProperty("username"), Config.getProperty("password"));
			    takeScreenShot("Login Successfully");
			    usermgmtpage=dashboardPage.clickOnAdminTab();
			    Log.info("Admin tab Clicked");
			    takeScreenShot("Admin tab Clicked");
			    usermgmtpage.dleteWorkShift("nightShift1");
			    Log.info("Work Shift Deleted Successfully");
			    Assert.assertEquals(true, usermgmtpage.DeletingWorkShiftSuccess());
			    Log.info("Test Case Pass");
			    takeScreenShot("Test Case Pass");
			}
			catch(Exception e){
				e.printStackTrace();
			}	
			finally{
				topnevigationmenupage.ClickOnUserName();
			}
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}

}

package com.eva.vtiger.testcases;

	import java.net.SocketException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeOptions;

import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LeadsPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.pages.ReusableMethod;
import com.eva.vtiger.utils.WebUtil;


	public class LeadsTestScripts {
		
		public void vt001VerifyLeadWithRequiredFields() throws SocketException {
			
			WebUtil wu = new WebUtil();
			LoginPage lp=new LoginPage();
		    lp.OpenVTigerLoginPage(wu);
		    lp.validLogin(wu);
		    
		    HomePage hp=new HomePage(); 
		    hp.gotoLeadsPage(wu);
		    LeadsPage leadsPage= new LeadsPage();
		    leadsPage.clickCreateLeadPlusButton(wu);
			wu.closeAllBrowser();
			
			
		}
		
	

	}


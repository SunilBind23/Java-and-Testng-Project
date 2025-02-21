package com.eva.vtiger.testcases;

	import java.net.SocketException;

import com.eva.vtiger.pages.CreateLeadsPage;
import com.eva.vtiger.pages.HomePage;
import com.eva.vtiger.pages.LeadsPage;
import com.eva.vtiger.pages.LoginPage;
import com.eva.vtiger.utils.Webutils;


	public class LeadsTestScripts {
		
		public void vt001VerifyLeadWithRequiredFields() throws SocketException {
			
			Webutils wu = new Webutils();
			
			LoginPage lp=new LoginPage(wu);
		    lp.OpenVTigerLoginPage();
		    lp.validLogin(wu);
		    
		    HomePage hp=new HomePage(wu); 
		    hp.gotoLeadsPage();
		    LeadsPage leadsPage= new LeadsPage(wu);
		    leadsPage.clickCreateLeadPlusButton();
		    
		    CreateLeadsPage Createlead=    new CreateLeadsPage(wu);
		    Createlead.selectValue("Mr.");
		    Createlead.enterLastName("sujal");
		    Createlead.enterCompany("MVS");
		    Createlead.clickOnSaveButton();
			wu.closeAllBrowser();
			
			
		}
		
		
		public void vt001VerifyLeadWithoutRequiredFields() {
			
		}
		
	

	}


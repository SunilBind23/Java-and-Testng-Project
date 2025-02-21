package com.eva.vtiger.runner;

import org.openqa.selenium.By;

import java.net.SocketException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eva.vtiger.testcases.CalendarTestScript;
import com.eva.vtiger.testcases.LeadsTestScripts;

import utils.WebUtil;

public class Runner {

	public static void main(String[] args) throws SocketException {

		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter esr = new ExtentSparkReporter("D:\\AutomationReportsVtiger\\VTigerReportLeads.html");
		extReport.attachReporter(esr);

		ExtentTest et = null;
//		et = extReport.createTest("vt001VerifyLeadScriptWithRequiredFields");
//		WebUtil.setExtentest(et);
//
//		LeadsTestScripts vts = new LeadsTestScripts();
//		vts.vt001VerifyLeadWithRequiredFields();
//		extReport.flush();

		et = extReport.createTest("VerifyCalanderPageTestScript");
		WebUtil.setExtentest(et);
		CalendarTestScript runC = new CalendarTestScript();
		runC.verifyCalanderPage();

		extReport.flush();
		
		
		

	}

}

package com.eva.vtiger.runner;

import org.openqa.selenium.By;

import java.net.SocketException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.eva.vtiger.testcases.LeadsTestScripts;
import com.eva.vtiger.utils.WebUtil;

public class Runner {

	public static void main(String[] args) throws SocketException {

		ExtentReports extReport = new ExtentReports();
		ExtentSparkReporter esr = new ExtentSparkReporter("C:\\Users\\DELL\\Desktop\\all report\\VTigerReport.html");
		extReport.attachReporter(esr);
		ExtentTest et = extReport.createTest("vt001VerifyLeadScriptWithRequiredFields");
		WebUtil.setExtentest(et);

		LeadsTestScripts vts = new LeadsTestScripts();

		vts.vt001VerifyLeadWithRequiredFields();

		
		extReport.flush();

	}

}

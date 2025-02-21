package com.eva.OpenCart;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Demo {
	public static void main(String[] args) {
		ExtentReports ext = new ExtentReports();
		ExtentSparkReporter extSpark = new ExtentSparkReporter("D:\\AllTemple\\Demo.html");
		ext.attachReporter(extSpark);
		ExtentTest extReport = ext.createTest("Demo");
		extReport.log(Status.PASS, "hello report");
		
		ext.flush();
	}
}

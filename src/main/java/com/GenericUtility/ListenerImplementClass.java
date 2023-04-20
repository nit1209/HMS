package com.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

               


public class ListenerImplementClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//Execution starts from here
		String methodname = result.getMethod().getMethodName();
		test=report.createTest(methodname);
		Reporter.log(methodname+"----> test Execution Started");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"---->PASSED");
		Reporter.log(methodname+"-------->test Execution is SUCCESSFUL");
		
		
		
	}

	public void onTestFailure(ITestResult result) {
	/*	String res = result.getName();
		TakesScreenshot t=(TakesScreenshot) BaseClass.edriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dst= new File("./Screenshot/"+res+".png");
		try 
		{
			FileUtils.copyFile(src, dst);
		} 
		catch (IOException e) 
		{
			
		}*/
		
		try {
			WebDriverUtility.getScreenShot(BaseClass.edriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Test Execution Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"--->SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("TestScript Execution Skipped");
		
	}

	public void onStart(ITestContext context) {
		//create empty html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("HMS-report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("hms_project");
		
		//give info to report
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base_url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter_name", "npm");
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

	
	
	
}

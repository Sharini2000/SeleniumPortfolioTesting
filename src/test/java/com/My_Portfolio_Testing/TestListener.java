package com.My_Portfolio_Testing;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class TestListener implements ITestListener {
	

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Before starting all tests, below method runs.
	@Override
	public void onStart(ITestContext iTestContext) {
		
		System.out.println("onStart method - Starting all the tests run: " + iTestContext.getName());
		// iTestContext.setAttribute("WebDriver", this.getWebDriver());
	}

	// After ending all tests, below method runs.
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("onFinish method - Status of all tests run: " + iTestContext.getName());
		ReportManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		
		System.out.println(iTestResult.getTestName());
		String description = iTestResult.getMethod().getDescription();
		System.out.println("onTestSuccess method - Is the test successful? - " + getTestMethodName(iTestResult) + " succeed");
		if (iTestResult.getTestName() != null) {
			ReportTestManager.startTest(iTestResult.getTestName(),
					iTestResult.getInstance().getClass().getCanonicalName());
		}else if (description != null)
			ReportTestManager.startTest(iTestResult.getMethod().getMethodName() + "( " + description + ")",
					iTestResult.getInstance().getClass().getCanonicalName());
		else {
			ReportTestManager.startTest(iTestResult.getMethod().getMethodName(),
					iTestResult.getInstance().getClass().getCanonicalName());
		}
		System.out.println("onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		
		ReportTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		
		System.out.println("onTestFailure method - Did the test fail? - " + getTestMethodName(iTestResult) + " Yes, failed");

		/*Object testClass = iTestResult.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getWebDriver();

		// Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"
				+ ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);*/

		ReportTestManager.getTest().log(Status.FAIL, iTestResult.getThrowable());
		/*ReportTestManager.getTest().fail("details",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());*/
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("onTestSkipped method - Did the test skipped? - " + getTestMethodName(iTestResult) + " Yes, skipped");

		// Extentreports log operation for skipped tests.
		ReportTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}
package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationcore.BaseClass;
import utilities.ExtentReportUtility;

public class Listeners extends BaseClass implements ITestListener {
	ExtentTest test; // represents a single test in the report.
	ExtentReports extent = ExtentReportUtility.createExtentReports();// Calls createExtentReports() from
																		// ExtentReportUtility
																		// to get a configured ExtentReports instance.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Prevents concurrency issues in parallel execution.

	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);// Calls the default implementation of onTestStart.
		test = extent.createTest(result.getMethod().getMethodName());// create new entry in the report
		extentTest.set(test);// stores the test instance in ThreadLocal for thread safety.

	}

	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult result) { // Called when a test is skipped.
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		// String testMethodName = result.getMethod().getMethodName();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {// rarely used
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {// failed due to time out
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {// call on start
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {// call on fininsh @end

		ITestListener.super.onFinish(context);
		extent.flush();// save and write all collected log and test details saved into final report
	}

}

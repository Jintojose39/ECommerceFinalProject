package EcommerceTestCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import resources.ECBase;

import resources.ExtentReportEcommerce;

public class Listeners extends ECBase implements ITestListener {
	
	
	ExtentTest test;
	ExtentReports extent=ExtentReportEcommerce.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		/*WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();*/
		/*try {
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block}
			e.printStackTrace();
		}
		*/
		
		try {
			getScreenShotPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case failed due to below issues ",ExtentColor.RED));
		test.fail(result.getThrowable());
	//extentTest.get().addScreenCaptureFromPath(result.getMethod().getMethodName());
	
	}
		
	public void onTestSkipped(ITestResult result) {
		
		extentTest.get().log(Status.SKIP, "Test Skipped");
		
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
		
		
	}
	public void onFinish(ITestContext context) {
	
		extent.flush();
		
	}
	
	
 }

/*
WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		 
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	
		String filePath=null;
		try {
			//filePath=getScreenShotPath(testMethodName, driver);
			
			filePath = getScreenShotPath(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	
	
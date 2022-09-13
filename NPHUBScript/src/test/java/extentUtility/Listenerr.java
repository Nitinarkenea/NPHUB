package extentUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testjava.BaseTest;

public class Listenerr extends BaseTest implements ITestListener{
	ExtentReports extent = CustomReportersss.extentReporterGenrator();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
	}

	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test is Passed");
	}
	
	@Override
    public void onTestFailure(ITestResult result) {
    	// TODO Auto-generated method stub
    	test.log(Status.FAIL, "Test is Failed");
    }
    
   
   @Override
    public void onTestSkipped(ITestResult result) {
    	// TODO Auto-generated method stub
	   test.log(Status.SKIP, "Test is Skipped");
    }
   
   
     @Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
     

}

package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution Started");
		Reporter.log(methodName+" Execution Started");
		
		test = report.startTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution success");
		Reporter.log(methodName+" Execution success");
		
		test.log(LogStatus.PASS, methodName+" Execution success");
		
		report.endTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution Failure");
		Reporter.log(methodName+" Execution Failure");
		
		
		GenericUtilities gu = new GenericUtilities();
		String path = "./src/test/resources/defectImages/"+methodName+"_"+gu.currentDate()+".jpg";
		
		
		test.log(LogStatus.FAIL, test.addScreenCapture(gu.captureScreenShot(BaseClass.sdriver, path)), methodName+" Execution Failure");
		
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" Execution skipped");
		Reporter.log(methodName+" Execution skipped");
		
		test.log(LogStatus.SKIP, methodName+" Execution skipped");
		
		report.endTest(test);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Execution Started---");
		
		report = new ExtentReports("./reports/VtigerExtentReport.html");
		
		report.addSystemInfo("OS", "Windows 11");
		report.addSystemInfo("User Name", "Kavya");
		report.addSystemInfo("Project", "Vtiger");
		report.addSystemInfo("Browser", "Edge");
		report.addSystemInfo("URL", "http://localhost:8888/");
		report.addSystemInfo("username", "admin");
		report.addSystemInfo("password", "admin");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Execution Finished---");
		report.flush();
	}

	
}

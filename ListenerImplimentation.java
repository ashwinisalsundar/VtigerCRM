package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript execution is passed",true);//html
		test.log(Status.PASS, "Testscript execution is passed");//extent report
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is failed"+message,true);
		test.log(Status.FAIL, "Testscript execution is Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution skipped",true);
		test.log(Status.SKIP, "Testscript execution is skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//Reporter.log("Testscript execution is started",true);
		
		//Use ExtentSparkReporter class just to configure(Create an folder) extent report. 
		JavaUtil jUtil= new JavaUtil();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Orgnization");
		
		//Use ExtentReports to generate extentreport 
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "121");
		report.setSystemInfo("Author", "Ashwini");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		//Reporter.log("Testscript execution is finished",true);
		report.flush();
		
		
	}

}

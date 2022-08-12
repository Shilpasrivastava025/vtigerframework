package comcast.vtiger.genericUtility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements  ITestListener{

	public void onTestFailure(ITestResult result) {
		
		String testname=result.getMethod().getMethodName();
		System.out.println(testname+"-----execute--------");
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			File destFile = new File("./sdet/screenshots"+testname+".png");
			
		}
		catch(Throwable e)

		{
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
	
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
	
	}

	public void onFinish(ITestContext context) {
		
	}
	
 
}

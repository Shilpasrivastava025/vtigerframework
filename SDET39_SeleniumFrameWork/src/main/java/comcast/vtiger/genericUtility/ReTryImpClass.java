package comcast.vtiger.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTryImpClass implements IRetryAnalyzer
{
	int count =0;
	int retryLimit =3;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}

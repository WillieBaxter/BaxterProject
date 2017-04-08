package ProfessionalTesting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println(" ******* ****** Test start successful and details are:" + result.getName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		System.out.println(" ******* ****** Test successful and details are:" + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		System.out.println(" ******* ****** Test case has failed and details are:" + result.getName());
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		System.out.println("Test case has skipped and details are:" + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		System.out.println("Test case has failed with success percentage and details are:" + result.getName());
		
	}

	@Override
	public void onStart(ITestContext context) {
	
		System.out.println("Test case has started and details are:" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
	
		System.out.println("Test case has finised and details are:" + context.getName());
	
	}
	
}



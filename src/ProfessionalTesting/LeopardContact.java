package ProfessionalTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.testing.tools.*;

import ProfessionalTesting.LeadLeopard.utils;
@Listeners(ProfessionalTesting.Listeners.class)
public class LeopardContact implements ITestListener{
	
	public static WebDriver driver = null;
	public static String path = System.getProperty("user.dir");
	public static String pathName = "\\src\\Resource";
	public static String Chromepath = "webdriver.chrome.driver";
	public static String ChromeExe = "\\chromedriverNew.exe";
	public static String FireFoxpath = "webdriver.gecko.driver";
	public static String FireFoxExe = "\\geckodriver.exe";
	public static String IEpath = "webdriver.ie.driver";
	public static String IEexe = "\\IEDriverServer32bit.exe";
	DriversPath web = new DriversPath();
	public DesiredCapabilities DesiredCapabilites;
	public static String FirefoxSource = System.setProperty(FireFoxpath,path+pathName+FireFoxExe);
	public static String ChromeSource = System.setProperty(Chromepath,path+pathName+ChromeExe);
	public static String IESource = System.setProperty(IEpath, path+pathName+ IEexe);
	public static String Source;
	public static final boolean highlight = true;
	public static String ScreenshotPath = "C:\\Users\\admin\\Pictures\\Screenshots\\PGL\\";
	
@BeforeTest
public void OpenBrowser() throws Exception{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Professional WorkSpace\\Pro WorkSpace\\src\\ProfessionalTesting\\LeadleapoardData");
		prop.load(fis);
		
		Logger logg = Logger.getLogger("LeadLeopard");
		PropertyConfigurator.configure("C:\\Users\\admin\\Professional WorkSpace\\Pro WorkSpace\\LOG4JPROPERTIES");
		
		if(prop.getProperty("browser").equals("FireFox")){
			
			web.FIREFOX();
		}
		
		else if (prop.getProperty("browser").equals("chrome")){
			web.CHROME();
			
		}
		
		else if (prop.getProperty("browser").equals("IE")){
			web.IE();
		}
		
		logg.info("Browser Opened: Chrome");
		driver.get(prop.getProperty("URL"));
		logg.info("Web Page Selected");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		((JavascriptExecutor)driver).executeScript("scroll(0,1000)");

	}

	@Test
	public static void contactSelection(){
		
		Logger logg = Logger.getLogger("LeadLeopard");
		try {
			utils.ActionClass(By.cssSelector("[id='et_pb_contact_name_1']"));
			logg.info("CONTACT SELECTION COMPLETE");
		} catch (Exception e) {
			System.out.println("Error on Element");
			e.printStackTrace();
		}
		
		
		try {
			utils.Click(By.cssSelector("[id='et_pb_contact_name_1']"));
			logg.info("CLICK COMPLETE");
		} catch (Exception e) {
			System.out.println("Error on Element");
			e.printStackTrace();
		}
	}

	@Test
	public static void name(){

		Logger logg = Logger.getLogger("LeadLeopard");
		try {
			utils.EnterText(By.cssSelector("[id='et_pb_contact_name_1']"), "@#4weft45@$4 ");
			logg.info("Name Complete");
		} catch (Exception e) {
			System.out.println("Error on Name Element");
			e.printStackTrace();
		}
		
		utils.Click(By.cssSelector("[type='submit']"));
	}


static class utils{
	

	public static void Selection(By x){
		
		driver.findElement(x).click();
		System.out.println("Element Selected: "+ driver.findElement(x).isSelected());
		
	}
	
	public static void ActionClass(By x){
		Actions ele = new Actions(driver);
		WebElement move = driver.findElement(x);
		ele.moveToElement(move).build().perform();
		
	}
	
	
	public static void EnterText(By selectTextBox, String TypeWords){
		driver.findElement(selectTextBox).sendKeys(TypeWords);
	}
	
	public static void Click(By ElementToClick){
		driver.findElement(ElementToClick).click();
	}
	
	public static void CheckBoxConfirmed(By x){
		driver.findElement(x).isSelected();
	}

	public static void ScreenShots(String picName) throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(picName));
	}

	public static void highLightElement(WebElement element)throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i =0; i < 1; i++){
	
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"color: blue; border: 5px solid red;");
			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"");
		}
		
		
	}
	
	public static void LogIN(By selectTextBox, String Username, By selectTextBox2, String Password, By LoginButton ) throws IOException{
		
		
		try {
			
			utils.EnterText(selectTextBox, Username);
		
		} catch (Exception e) {
			e.printStackTrace();
			utils.ScreenShots(ScreenshotPath+"Username.png");
			
		}
		
		
		try {
			
			utils.EnterText(selectTextBox2, Password);
		
		} catch (Exception e) {
			e.printStackTrace();
			utils.ScreenShots(ScreenshotPath+"Password.png");
			
		}
		

		utils.Click(LoginButton);
		
	}
	
	public static void columnsAndRows(By x, By y, By z){
		
		WebElement tableElement = driver.findElement(x);
		tableElement.findElement(y);
		List<WebElement> rowCount = tableElement.findElements(z); 
		System.out.println("Amount Of Rows: " + rowCount);
		
	}

}


	

class DriversPath{
	 
		
		public void CHROME(){
			
			Source = ChromeSource;
			driver = new ChromeDriver();
			
		}
		
		public void FIREFOX(){
			
			Source = FirefoxSource;
			// To get Info on FireFox setting go to Firefox and type about:config in the browser
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setAcceptUntrustedCertificates(true);
			firefoxProfile.setAssumeUntrustedCertificateIssuer(true);		
			driver = new FirefoxDriver();
		
		}

		public void IE()throws Exception{
			
			Source = IESource;
			driver = new InternetExplorerDriver();
		
		}
	}




@Override
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}




@Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}




@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	
}




@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}




@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}




@Override
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}




@Override
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
	

}






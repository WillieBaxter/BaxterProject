package com.testing.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.Select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Utilities {
	
	public static WebDriver driver = null;
	public static String actualText = null;
	
	public static Select dropdown = null;
	public static String path = System.getProperty("user.dir");
	public static String pathName = "\\src\\Resource";
	public static String Chromepath = "webdriver.chrome.driver";
	public static String ChromeExe = "\\chromedriverNew.exe";
	public static String FireFoxpath = "webdriver.gecko.driver";
	public static String FireFoxExe = "\\geckodriver.exe";
	public static String IEpath = "webdriver.ie.driver";
	public static String IEexe = "\\IEDriverServer32bit.exe";

	static DesiredCapabilities cap;
	public DesiredCapabilities DesiredCapabilites;
	public static String FirefoxSource = System.setProperty(FireFoxpath,path+pathName+FireFoxExe);
	public static String ChromeSource = System.setProperty(Chromepath,path+pathName+ChromeExe);
	public static String IESource = System.setProperty(IEpath, path+pathName+ IEexe);
	public static String Source;
	public static final boolean highlight = true;
	public static String ScreenshotPath = null;
	
	



	static class utils{
		
		/**
		 * 
		 * @param x
		 */

		public static void Selection(By x){
			
			try {
				driver.findElement(x).click();
				System.out.println("Element Selected: "+ driver.findElement(x).isSelected());
			} catch (Exception e) {
				System.out.println("**** Element Selected Error! *****");
				e.printStackTrace();
			}
			
	}
		
		/**
		 * 
		 * @param x
		 * @param elementName
		 */
		public static void ActionClass(By x, String elementName){
			
			try {
				Actions ele = new Actions(driver);
				WebElement move = driver.findElement(x);
				ele.moveToElement(move).build().perform();
			} catch (Exception e) {
				System.out.println("Action Class Error for:" + elementName );
				e.printStackTrace();
			}
			
	}
		
		/**
		 * 
		 * @param selectTextBox
		 * @param TypeWords
		 */
		
		public static void EnterText(By selectTextBox, String TypeWords){
			
			try {
				driver.findElement(selectTextBox).sendKeys(TypeWords);
			} catch (Exception e) {
				System.out.println("EnterText: "+ TypeWords);
				e.printStackTrace();
			}
			
	}
		
		public static void Click(By ElementToClick){
			
			try {
				driver.findElement(ElementToClick).click();
			} catch (Exception e) {
				System.out.println(" ***** Click Error ****** ");
				e.printStackTrace();
			}
			
	}
		
		public static void CheckBoxConfirmed(By x){
			
			try {
				driver.findElement(x).isSelected();
			} catch (Exception e) {
				System.out.println(" ****** Check Box Confirmed Error ***** ");
				e.printStackTrace();
			}
	}

		public static void ScreenShots(String picName) throws IOException{
		
			try {
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File(picName));
			} catch (WebDriverException e) {
				System.out.println("ScreenShot Error:" + picName);
				e.printStackTrace();
			}
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
			
			Logger logg = Logger.getLogger("PGL");
			PropertyConfigurator.configure("C:\\Users\\admin\\Professional WorkSpace\\Pro WorkSpace\\LOG4JPROPERTIES");
			
			
			try {
				
				utils.EnterText(selectTextBox, Username);
				logg.info("Username: Valid ");
			} catch (Exception e) {
				e.printStackTrace();
				utils.ScreenShots(ScreenshotPath+"Username.png");
				
			}
			
			
			try {
				
				utils.EnterText(selectTextBox2, Password);
				logg.info("Password: Valid ");
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

		public static void tableElementCount(By x, By y, By z, By tag) throws InterruptedException{
			
			
			WebElement table = driver.findElement(x);
			int tableTags = table.findElements(y).size();
			
			utils.Selection(x);
			
			for(int i = 0; i < tableTags; i++){
				String printTags = table.findElements(tag).get(i).getText();
				
				System.out.print(printTags+" "+"|");
				
			}
					
		
		}

	
		
		
		
		
	}



static class DriversPath{
		 
			
			public static void CHROME(){
				

				Source = ChromeSource;
				driver = new ChromeDriver();
			}
			
			public static void FIREFOX(){
				
				Source = FirefoxSource;
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				//set profile to accept untrusted certificates 
				firefoxProfile.setAcceptUntrustedCertificates(true);
				firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
				//set download location and file types
				//firefoxProfile.setPreference(key, value);
				cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile );
				driver = new FirefoxDriver();
			
			}

			public static void IE()throws Exception{
				
				Source = IESource;
				driver = new InternetExplorerDriver();
				cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				driver = new InternetExplorerDriver(cap);
			
			}
	 	}
}
	 



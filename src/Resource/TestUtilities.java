package Resource;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import ProfessionalTesting.OrangeHomeTest;


public class TestUtilities {
	

	public static WebDriver driver = null;
	public static String actualText = null;
	public static OrangeHomeTest obj = null;
	public static Select dropdown = null;
	public static String path = System.getProperty("user.dir");
	public static String pathName = "\\src\\Resource";
	public static String Chromepath = "webdriver.chrome.driver";
	public static String ChromeExe = "\\chromedriverNew.exe";
	public static String FireFoxpath = "webdriver.gecko.driver";
	public static String FireFoxExe = "\\geckodriver.exe";
	public static String IEpath = "webdriver.ie.driver";
	public static String IEexe = "\\IEDriverServer32bit.exe";
	//ElementsUtilities ele =  new ElementsUtilities();

	DesiredCapabilities cap;
	public DesiredCapabilities DesiredCapabilites;
	public static String FirefoxSource = System.setProperty(FireFoxpath,path+pathName+FireFoxExe);
	public static String ChromeSource = System.setProperty(Chromepath,path+pathName+ChromeExe);
	public static String IESource = System.setProperty(IEpath, path+pathName+ IEexe);
	public static String Source;
	public static final boolean highlight = true;


	public void Selection(By x){
		
		driver.findElement(x).click();
		System.out.println("Element Selected: "+driver.findElement(x).isSelected());
		
	}
	
	public void ActionClass(By x){
		Actions ele = new Actions(driver);
		WebElement move = driver.findElement(x);
		ele.moveToElement(move).build().perform();
		
	}
	
	
	public void EnterText(By selectTextBox, String TypeWords){
		driver.findElement(selectTextBox).sendKeys(TypeWords);
	}
	
	public void Click(By ElementToClick){
		driver.findElement(ElementToClick).click();
	}
	
	public void CheckBoxConfirmed(By x){
		driver.findElement(x).isSelected();
	}
	
	public void highLightElement_1(WebElement element)throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"color: blue; border: 5px solid red;");
		Thread.sleep(500);
		
	}
	

	public void ScreenShots(String picName) throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(picName));
	}

	public void highLightElement(WebElement element)throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i =0; i < 1; i++){
	
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"color: blue; border: 5px solid red;");
			Thread.sleep(1000);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"");
		}
		
	

	}
	
class DriversPath{
		 
		
		public void CHROME(){
			
			//System.setProperty(Chromepath,path+pathName+ChromeExe);
			Source = ChromeSource;
			driver = new ChromeDriver();
			
		}
		
		public void FIREFOX(){
			Source = FirefoxSource;
			driver = new FirefoxDriver();
		}

		public void IE(){
			Source = IESource;
			driver = new InternetExplorerDriver();
		}

	}

}

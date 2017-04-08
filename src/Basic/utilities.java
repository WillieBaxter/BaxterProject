package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class utilities {
	
	public static WebDriver driver = null;
	public static String actualText = null;
	public static String obj = null;
	

	public void EnterText(By enterPath, String entry){
		driver.findElement(enterPath).sendKeys(entry);
	}

	public void Click(By enterPath){
		driver.findElement(enterPath).click();
	}
	
	public void CheckBoxConfirmed(By selectCheck){
		System.out.println(driver.findElement(selectCheck).isSelected());
	}
	
	public void CheckText(By text, String expected){
		actualText = driver.findElement(text).getText();
		Assert.assertEquals(actualText, expected, " name not found");
		System.out.println("Assert Test: Name Displays");
	}

	public void Lights(WebElement element) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element,"color: red; border: 5px solid red;"); 
		Thread.sleep(500);
	}


}

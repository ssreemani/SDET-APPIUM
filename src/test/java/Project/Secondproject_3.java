package Project;

import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Secondproject_3 {

	WebDriverWait wait;
	static AndroidDriver<MobileElement> driver = null;
    
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
		// Set the Desired Capabilities
	     DesiredCapabilities caps = new DesiredCapabilities();
	     caps.setCapability("deviceId", "b1f54525");
	     caps.setCapability("deviceName", "OPPO A5");
	     caps.setCapability("platformName", "android");
	     caps.setCapability("automationName", "UiAutomator2");
	     caps.setCapability("appPackage", "com.android.chrome");
	     caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	     caps.setCapability("noReset", true);
	     
	     // Instantiate Appium Driver
	     driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	     wait = new WebDriverWait(driver, 10);
  }	
  @Test
  public void Popups() throws InterruptedException {
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
	// Open the browser with the URL
	  driver.get("https://www.training-support.net/selenium");
	  }
	  catch (Exception e){
      
	  Thread.sleep(10);
	  
	  //Scroll to the exact Element
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Popups\"))")).click();
      
      String result=Addtask("admin", "password");
	  Assert.assertEquals("Welcome Back, admin", result);
	  String result1=Addtask("Test", "Test1");
	  Assert.assertEquals("Invalid Credentials", result1);
	   }
  }
  public static String Addtask(String username, String password) throws InterruptedException {
	  driver.findElementByXPath("//*[@text='Sign In']").click();
	  Thread.sleep(10);
	  driver.findElementByXPath("//*[@resource-id='username']").clear();
	  driver.findElementByXPath("//*[@resource-id='password']").clear();
	  driver.findElementByXPath("//*[@resource-id='username']").sendKeys(username);
	  driver.findElementByXPath("//*[@resource-id='password']").sendKeys(password);
	  driver.findElementByXPath("//*[@text='Log in']").click();
	  String result= driver.findElementByXPath("//*[@resource-id='action-confirmation']").getText();
	  return result;
  }
  
  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}

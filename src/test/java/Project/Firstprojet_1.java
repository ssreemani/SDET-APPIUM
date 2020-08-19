package Project;

import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Firstprojet_1 {
	
	WebDriverWait wait;
	// Instantiate Appium Driver
    AndroidDriver<MobileElement> driver = null;
    
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	     // Set the Desired Capabilities
	     DesiredCapabilities caps = new DesiredCapabilities();
	     caps.setCapability("deviceId", "b1f54525");
	     caps.setCapability("deviceName", "OPPO A5");
	     caps.setCapability("platformName", "android");
	     caps.setCapability("automationName", "UiAutomator2");
	     caps.setCapability("noReset", true);
	     caps.setCapability("appPackage", "com.google.android.apps.tasks");
	     caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
	     
	     // Instantiate Appium Driver
	     driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	     wait = new WebDriverWait(driver, 10);
    }   
  @Test
  public void Task() {
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Tasks");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  String expected1= driver.findElementByXPath("//*[@text='Complete Activity with Google Tasks']").getText();
	  Assert.assertEquals(expected1, "Complete Activity with Google Tasks");
	  
	  
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete Activity with Google Keep");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  String expected2= driver.findElementByXPath("//*[@text='Complete Activity with Google Keep']").getText();
	  Assert.assertEquals(expected2, "Complete Activity with Google Keep");
	  
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_title").sendKeys("Complete the second Activity Google Keep");
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  String expected3= driver.findElementByXPath("//*[@text='Complete the second Activity Google Keep']").getText();
	  Assert.assertEquals(expected3, "Complete the second Activity Google Keep");
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

package Project;

import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Secondproject_1 {

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
	     //caps.setCapability("noReset", true);
	     //caps.setCapability("browserName", "chrome");
	     caps.setCapability("appPackage", "com.android.chrome");
	     caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	     caps.setCapability("noReset", true);
	     
	     // Instantiate Appium Driver
	     driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	     wait = new WebDriverWait(driver, 10);
  }	
  @Test
  public void To_Do_List() throws InterruptedException {
	 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
	// Open the browser with the URL
	  driver.get("https://www.training-support.net/selenium");
	  }
	  catch (Exception e){
      
	  Thread.sleep(10);
	  
	  //Scroll to the exact Element
	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"To-Do List\"))")).click();
	  Addtask("Add tasks to list");
	  Addtask("Get number of tasks");
	  Addtask("Clear the list");

	  
	  driver.findElementByXPath("//*[@text='Add tasks to list']").click();
	  driver.findElementByXPath("//*[@text='Get number of tasks']").click();
	  driver.findElementByXPath("//*[@text='Clear the list']").click();
	  
	  //driver.findElementByXPath("//*[@text='Clear List']").click();
	  driver.findElementByXPath("//android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();
	   }
  }
  public static void Addtask(String taskName) {
	  driver.findElementByXPath("//*[@resource-id='taskInput']").sendKeys(taskName);
	  driver.findElementByXPath("//*[@text='Add Task']").click();
  }
  
  @AfterTest
  public void afterTest() {
	 // driver.quit();
  }

}

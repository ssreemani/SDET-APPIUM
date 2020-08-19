package Project;

import org.testng.annotations.Test;

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

public class Firstproject_2 {
	
   WebDriverWait wait;
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
	     caps.setCapability("appPackage", "com.google.android.keep");
	     caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
	     
	     // Instantiate Appium Driver
	     driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	     wait = new WebDriverWait(driver, 10);
  }
	
  @Test
  public void Keep() {
	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test Title_with out reminder");
	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Test Desc_with out reminder");
	  driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
	  String expected1= driver.findElementByXPath("//*[@text='Test Title_with out reminder']").getText();
	  Assert.assertEquals(expected1, "Test Title");
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

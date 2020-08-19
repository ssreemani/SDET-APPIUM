package Activity;

import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
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
  public void f() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  try {
	// Open the browser with the URL
	  driver.get("https://www.training-support.net/");
	  }
	  catch (Exception e){
	  // Locate page title on homepage and print it
	  String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
	  System.out.println("Title on Homepage: " + pageTitle);
	  

      MobileElement aboutButton = driver.findElementByXPath("//android.view.View[@content-desc='About Us']");
      aboutButton.click();

      String newPageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
      System.out.println("Title on new page: " + newPageTitle);

      // Assertions
      Assert.assertEquals(pageTitle, "Training Support");
      Assert.assertEquals(newPageTitle, "About Us");
	  }
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

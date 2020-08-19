package Activity;

import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.Test;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class calculator {

@Test
    public void calc() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "b1f54525");
        caps.setCapability("deviceName", "OPPO A5");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");

        // Instantiate Appium Driver
        AndroidDriver<MobileElement> driver = null;
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
            driver.findElementById("com.android.calculator2:id/digit6").click();
            driver.findElementById("com.android.calculator2:id/plus").click();
            driver.findElementById("digit5").click();
            driver.findElementById("com.android.calculator2:id/equal").click();
            driver.quit();
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}


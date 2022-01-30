package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    static AppiumDriver driver;

    public static void initializeDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability("avd", "Pixel_3_API_31");
        caps.setCapability("avdLaunchTimeout", 180000);
        String andAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "selendroid-test-app-0.17.0.apk";
        caps.setCapability(MobileCapabilityType.APP, andAppUrl);
        URL url = null;
        try{
           url= new URL("http://0.0.0.0:4723/wd/hub");
  
        }catch(MalformedURLException ex){
              logger.info(mainPageLabel);
        }
        driver = new AndroidDriver(url, caps);
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}

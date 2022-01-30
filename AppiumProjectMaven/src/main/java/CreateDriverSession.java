import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.io.File;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializeDriver(String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);

        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        Logger logger = Logger.getLogger("CreateDriverSession");
        PropertyConfigurator.configure("src/main/resources/log4j.properties");


        switch(platformName){
            case "Android":
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("appium:deviceName", "Pixel 3");
                desiredCapabilities.setCapability("appium:automationName", "UIAutomatior 2");
                desiredCapabilities.setCapability("appium:udid", "emulator-5554");
                desiredCapabilities.setCapability("appium:app", "src/main/resources/selendroid-test-app-0.17.0.apk");
                desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
                desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
                desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
                desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "");
                caps.setCapability("xcodeOrgId", "");
                caps.setCapability("xcodeSigningId", "");
                String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                        + File.separator + "resources" + File.separator + ".app";
                  caps.setCapability(MobileCapabilityType.APP, iOSAppUrl);
                caps.setCapability("simulatorStartupTimeout", 180000);
                caps.setCapability("bundleId", "");
                caps.setCapability("bundleId", "");
                caps.setCapability("includeSafariInWebviews", true);
                caps.setCapability("webviewConnectTimeout", "90000");
                caps.setCapability("safariLogAllCommunication", true);
                caps.setCapability("fullContextList", true);
                caps.setCapability("additionalWebviewBundleIds", "process-SafariViewService");
                return new IOSDriver(url, caps);
            default:
                logger.error("invalid platform");
                throw new Exception("invalid platform");
        }
    }
}

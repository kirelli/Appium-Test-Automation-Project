package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BasePage {

    public AppiumDriver driver;

    public void click(By e){
        driver.findElement(e).click();
    }
}

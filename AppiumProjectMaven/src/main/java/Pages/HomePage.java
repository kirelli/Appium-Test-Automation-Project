package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    private final MobileBy displayTextViewButton = (MobileBy) MobileBy.AccessibilityId("visibleButtonTestCD");
    private final By mainPageLabel =  MobileBy.id("io.selendroid.testapp:id/visibleTextView");
    private final MobileBy  registrationButton = (MobileBy) MobileBy.AccessibilityId("startUserRegistrationCD");
    private final By  userNameTextBox = MobileBy.id("io.selendroid.testapp:id/inputUsername");
    private final MobileBy  emailTextBox = (MobileBy) MobileBy.AccessibilityId("email of the customer");
    private final By  passwordTextBox = MobileBy.id("io.selendroid.testapp:id/inputPassword");
    private final By  languageDropbox = MobileBy.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
    private final By  acceptCheckBox = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[4]");
    private final By  oddsTextBox = MobileBy.id("io.selendroid.testapp:id/input_adds");
    private final By  completeRegistrationButton = MobileBy.id("io.selendroid.testapp:id/btnRegisterUser");
    private final By  successfulRegistrationButton = MobileBy.id("io.selendroid.testapp:id/buttonRegisterUser");
    private final MobileBy showPopUpButton = (MobileBy) MobileBy.AccessibilityId("showPopupWindowButtonCD");
    private final MobileBy  popupButton = (MobileBy) MobileBy.AccessibilityId("showPopupWindowButtonCD");
    private final MobileBy  mainPageTextBox = (MobileBy) MobileBy.AccessibilityId("my_text_fieldCD");

    private final AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickMobiTextViewButton() {
        driver.findElement(displayTextViewButton).click();
    }

    public String getMainPageLabel() {
      String mainPageLabelText = driver.findElement(mainPageLabel).getText().toString();
      return mainPageLabelText;
    }

    public String RegisterUser(String[] testData)
    {
        driver.findElement(registrationButton).click();
        driver.findElement(userNameTextBox).sendKeys(testData[0]);
        driver.findElement(emailTextBox).sendKeys(testData[1]);
        driver.findElement(passwordTextBox).sendKeys(testData[2]);
        driver.findElement(languageDropbox).click();
        driver.findElement(acceptCheckBox).click();
        driver.findElement(oddsTextBox).click();
        driver.findElement(completeRegistrationButton).click();
        String successfulRegistrationButtonText = driver.findElement(successfulRegistrationButton).getText().toString();
        return successfulRegistrationButtonText;
    }

    public String DisplayPopupShouldDisplay()
    {
        driver.findElement(showPopUpButton).click();
        String  popupButtonText = driver.findElement(popupButton).getText().toString();
        return popupButtonText;
    }

    public String MainPageTextBoxShouldBeActive()
    {
        driver.findElement(mainPageTextBox).sendKeys("Display Popup Window");
        String  popupButtonText = driver.findElement(mainPageTextBox).getText().toString();

        return popupButtonText;
    }
}

import Pages.HomePage;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import Utils.CSVRead;
import org.apache.log4j.Logger;

public class HomePageScenarios {

    AppiumDriver driver;
    CSVRead testDatas;
    Logger logger = Logger.getLogger("Demo");

    @Before
    public void setUp() throws MalformedURLException {
        try {
            driver = CreateDriverSession.initializeDriver("Android");
            testDatas = new CSVRead();
        } catch (Exception e) {
            logger.error(String.format("error:%s", e.getMessage()));
            e.printStackTrace();
        }
    }

    @Test
    public void DisplayButtonTextShouldShowed() {
        HomePage pageObjects = new HomePage(driver);
        pageObjects.clickMobiTextViewButton();
        String mainPageLabel = pageObjects.getMainPageLabel();
        logger.info(mainPageLabel);
        Assert.assertEquals("Text is sometimes displayed", mainPageLabel);
    }

    @Test
    public void RegisterUser() {

        String[] testData = testDatas.CSVTestDataRead();
        logger.info(String.format("username:%s email:%s password:%s", testData[0],testData[1],testData[2] ));

        HomePage pageObjects = new HomePage(driver);
        String registerMeesageSuccessText = pageObjects.RegisterUser(testData);
        logger.info(registerMeesageSuccessText);
        Assert.assertEquals("Register User", registerMeesageSuccessText);
    }

    @Test
    public void DisplayPopupShouldDisplay() {

        HomePage pageObjects = new HomePage(driver);
        String displayedPopupText = pageObjects.DisplayPopupShouldDisplay();
        Assert.assertEquals("Display Popup Window", displayedPopupText);
    }

    @Test
    public void MainPageTextBoxShouldBeActive() {

        HomePage pageObjects = new HomePage(driver);
        String displayedPopupText = pageObjects.MainPageTextBoxShouldBeActive();
        Assert.assertEquals("Display Popup Window", displayedPopupText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


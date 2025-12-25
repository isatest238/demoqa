package Shared_Data;

import Logger.Logger_Utility;
import Shared_Data.browser.BrowserFactory;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Shared_Data {

    private WebDriver driver;
    private WebDriverWait wait;

    //@BeforeMethod
    public void prepareBrowser() {
        driver = new BrowserFactory().getBrowserFactory();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Logger_Utility.infoLog("The browser was opened with success");
    }

    //  @AfterMethod
    public void clearBrowser() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            Logger_Utility.errorLog("Error on driver.quit(): " + e.getMessage());
        } finally {
            driver = null;
            wait = null;
        }
        Logger_Utility.infoLog("Browser closed successfully");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

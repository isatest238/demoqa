package Shared_Data;

import Logger.Logger_Utility;
import Shared_Data.browser.BrowserFactory;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class Shared_Data {


    private WebDriver driver;

    //@BeforeMethod

    public void prepareBrowser() {

        driver = new BrowserFactory().getBrowserFactory();
        Logger_Utility.infoLog("The browser was opened with success");


    }


  //  @AfterMethod

    public void clearBrowser() {
        driver.quit();
        Logger_Utility.infoLog("The browser was opened with success");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

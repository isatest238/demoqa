package Shared_Data.browser.service;

import configFile.configNode.DriverConfigNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        FirefoxOptions options = (FirefoxOptions) getBrowserOptions(driverConfigNode);
        driver = new FirefoxDriver(options);
        driver.get(driverConfigNode.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        FirefoxOptions options = new FirefoxOptions();

        if(!driverConfigNode.headless.isEmpty()){
            options.addArguments(driverConfigNode.headless);
        }

        options.addArguments(driverConfigNode.resolution);
        options.addArguments(driverConfigNode.gpu);
        options.addArguments(driverConfigNode.extensions);
        return options;
    }


    public WebDriver getDriver(){
        return driver;
    }
}

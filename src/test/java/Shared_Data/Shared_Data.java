package Shared_Data;

import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class Shared_Data {






    private WebDriver driver;

    @BeforeMethod

    public void prepareBrowser() {
        ConfigurationNode configurationNode = ConfigFile.createConfigNode(ConfigurationNode.class);

        driver = new ChromeDriver();
      //  driver.get("https://demoqa.com/");
        driver.get(configurationNode.driverConfigNode.url);


        //definim un wait implicit pentru un interval maxim de timp
        //se activeaza dupa fiecare linie in care faci driver find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @AfterMethod

    public void clearBrowser() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

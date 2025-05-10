package Shared_Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Shared_Data {

    private WebDriver driver;

    @BeforeMethod

    public void prepareBrowser() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
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

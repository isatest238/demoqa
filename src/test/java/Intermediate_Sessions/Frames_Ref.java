package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.Frames_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Frames_Page;
import Pages.Home_Page;
import Pages.SubMenu_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames_Ref {
    public WebDriver driver;
    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Frames_Methods framesMethods;
    Home_Page homePage;
    SubMenu_Page subMenuPage;
    Frames_Page framesPage;

    @Test
    public void automationMethod3() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        javaScriptMethods = new JavaScript_Methods(driver);
        elementsMethods = new Elements_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Page(driver);
        framesPage = new Frames_Page(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Frames");

        framesPage.switchToFrameVerifySwitchToMain();
        javaScriptMethods.scrollMethod(0, 600);
        framesPage.switchToFrameScrollSwitchToMain();
    }
}

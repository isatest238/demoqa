package Intermediate_Sessions;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Alerts_Page;
import Pages.Home_Page;
import Pages.SubMenu_Page;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts_Ref {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public Alerts_Methods alertsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Page subMenuPage;
    Alerts_Page alertsPage;

    @Test
    public void automationMethod2() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        //se activeaza dupa fiecare linie in care faci driver find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        elementsMethods = new Elements_Methods(driver);
        alertsMethods = new Alerts_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Page(driver);
        alertsMethods = new Alerts_Methods(driver);
        alertsPage = new Alerts_Page(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Alerts");
        javaScriptMethods.scrollMethod(0, -400);
        alertsPage.clickOnFirstAlertOK();
        alertsPage.interactWithDelayAlert();

        javaScriptMethods.scrollMethod(400, 0);
        alertsPage.interactWithCancelAlert();
        alertsPage.interactSendKeyAlert();
    }
}

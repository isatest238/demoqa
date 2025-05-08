package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Helper_Methods.Windows_Methods;
import Pages.Browser_Page;
import Pages.Home_Page;
import Pages.SubMenu_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Browser_Windows_Ref {
    public WebDriver driver;
    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Windows_Methods windowsMethods;
    Home_Page homePage;
    SubMenu_Page subMenuPage;
    Browser_Page browserPage;

    @Test
    public void automationMethod3() throws InterruptedException {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();

        javaScriptMethods = new JavaScript_Methods(driver);
        elementsMethods = new Elements_Methods(driver);
        windowsMethods = new Windows_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Page(driver);
        browserPage = new Browser_Page(driver);


        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Browser Windows");
        browserPage.clickNewTabButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowMessageVerifyCloseReturnToMain();
    }
}

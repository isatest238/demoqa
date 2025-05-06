package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Interactions_Sortable {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Page subMenuPage;

    @Test
    public void automationMethod() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();

        elementsMethods = new Elements_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Page(driver);

        homePage.goToDesiredMenu("Interactions");
        subMenuPage.goToDesiredSubMenuPage("Sortable");

    }
}

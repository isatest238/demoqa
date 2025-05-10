package Intermediate_Sessions.BeforeRef;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Helper_Methods.Windows_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Browser_Windows {
    public WebDriver driver;
    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Windows_Methods windowsMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;

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
        subMenuPage = new SubMenu_Common_Page(driver);


        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        javaScriptMethods.scrollMethod(0, 400);
//
//        //declaram 'Alerts, Frame & Windows' element si dam click pe el
//        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(AlertsFormElement);

        subMenuPage.goToDesiredSubMenuPage("Browser Windows");

        // declaram 'Alerts' element si dam click pe el
//        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        elementsMethods.clickOnElement(browserWindowsElement);

        //declaram New Tab button si dam click pe el
        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabElement);

        //mutam fosusul pe noul tab
        //salvam tab urile intr o lista si apoi schimbam focusul pe al doilea tab
        windowsMethods.switchToTab();
//        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabList.get(1));

        WebElement samplePageElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new Tab este: " + samplePageElement.getText());
        Thread.sleep(5000);
        // inchidem tabul nou deschis
        windowsMethods.closeTab();
//
        //revenim la tabul initial
        windowsMethods.switchToMain();
//      driver.switchTo().window(tabList.get(0));


        //declaram New Window button si dam click pe el
        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elementsMethods.clickOnElement(newWindowElement);
        Thread.sleep(5000);
        windowsMethods.switchToTab();

        WebElement newWindowsElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new windows este :" + newWindowsElement.getText());
        Thread.sleep(5000);

        windowsMethods.closeTab();
        windowsMethods.switchToMain();


        //declaram New Window Message button si dam click pe el
        WebElement newWindowMessageElement = driver.findElement(By.id("messageWindowButton"));
        elementsMethods.clickOnElement(newWindowMessageElement);
        Thread.sleep(5000);
        windowsMethods.switchToTab();

        windowsMethods.closeTab();
        windowsMethods.switchToMain();


    }
}

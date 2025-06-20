package Intermediate_TestsBeforeRef;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public Alerts_Methods alertsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;

    SubMenu_Common_Page subMenuPage;

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
        subMenuPage = new SubMenu_Common_Page(driver);


        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        javaScriptMethods.scrollMethod(0, 400);
        //declaram 'Alerts, Frame & Windows' element si dam click pe el
//        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(AlertsFormElement);

        subMenuPage.goToDesiredSubMenuPage("Alerts");

        // declaram 'Alerts' element si dam click pe el
//        WebElement AlertsSectionElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        elementsMethods.clickOnElement(AlertsSectionElement);


        //identificam prima alerta si dam click
        WebElement FirstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElement(FirstAlertElement);

        //se muta focusul pe alerta - overlay ul ca sa interactionam cu ea
        alertsMethods.interactWithAlertsOK();

        //identificam a doua alerta si dam click
        WebElement SecondAlertElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElement(SecondAlertElement);


        //definim un explicit wait ca sa astepte dupa alerta
        alertsMethods.interactWithDelayAlert();


        javaScriptMethods.scrollMethod(0, 400);

        //identificam a treia alerta si dam click pe ea
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElement(thirdAlertElement);
        alertsMethods.interactWithAlertCancel();


        //identificam a patra alerta si dam click pe ea
        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickOnElement(fourthAlertElement);
        alertsMethods.interactWithAlertSendKey();



    }
}

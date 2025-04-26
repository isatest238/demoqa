package Intermediate_Sessions;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public Alerts_Methods alertsMethods;
    public JavaScript_Methods javaScriptMethods;

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

        javaScriptMethods.scrollMethod(0, 400);


        //declaram 'Alerts, Frame & Windows' element si dam click pe el
        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMethods.clickOnElement(AlertsFormElement);


        // declaram 'Alerts' element si dam click pe el
        WebElement AlertsSectionElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementsMethods.clickOnElement(AlertsSectionElement);


        //identificam prima alerta si dam click
        WebElement FirstAlertElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElement(FirstAlertElement);

        //se muta focusul pe alerta - overlay ul ca sa interactionam cu ea
        alertsMethods.interactWithAlertsOK();
//        Alert FirtsAlert = driver.switchTo().alert();
//        FirtsAlert.accept();


        //identificam a doua alerta si dam click
        WebElement SecondAlertElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElement(SecondAlertElement);


        //definim un explicit wait ca sa astepte dupa alerta
        alertsMethods.interactWithDelayAlert();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());

//        Alert SecondAlert = driver.switchTo().alert();
//        SecondAlert.accept();


        javaScriptMethods.scrollMethod(0, 400);

        //identificam a treia alerta si dam click pe ea
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElement(thirdAlertElement);
        alertsMethods.interactWithAlertCancel();

//        Alert thirdAlert = driver.switchTo().alert();
//        thirdAlert.dismiss();


        //identificam a patra alerta si dam click pe ea
        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickOnElement(fourthAlertElement);
        alertsMethods.interactWithAlertSendKey();

//        Alert fourthAlert = driver.switchTo().alert();
//        fourthAlert.sendKeys("Isabela");
//        fourthAlert.accept();

    }
}

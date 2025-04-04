package Intermediate_Sessions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {
    public WebDriver driver;

    @Test
    public void automationMethod2() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //definim un wait implicit pentru un interval maxim de timp - se activeaza dupa fiecare linie in care faci driver find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // facem browserul in modul maximized
        driver.manage().window().maximize();
        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram 'Alerts, Frame & Windows' element si dam click pe el
        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        AlertsFormElement.click();

        // declaram 'Alerts' element si dam click pe el
        WebElement AlertsSectionElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        AlertsSectionElement.click();

        //identificam prima alerta si dam click
        WebElement FirstAlertElement = driver.findElement(By.id("alertButton"));
        FirstAlertElement.click();
        //se muta focusul pe alerta - overlay ul ca sa interactionam cu ea
        Alert FirtsAlert = driver.switchTo().alert();
        FirtsAlert.accept();


        //identificam a doua alerta si dam click
        WebElement SecondAlertElement = driver.findElement(By.id("timerAlertButton"));
        SecondAlertElement.click();
        //definim un explicit wait ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert SecondAlert = driver.switchTo().alert();
        SecondAlert.accept();


        js.executeScript("window.scrollBy(0,400)");
        //identificam a treia alerta si dam click pe ea
        WebElement thirdAlertElement = driver.findElement(By.id("confirmButton"));
        thirdAlertElement.click();

        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.dismiss();


        //identificam a patra alerta si dam click pe ea
        WebElement fourthAlertElement = driver.findElement(By.id("promtButton"));
        fourthAlertElement.click();

        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("Isabela");
        fourthAlert.accept();

    }
}

package Helper_Methods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts_Methods {
    WebDriver driver;


    public Alerts_Methods(WebDriver driver) {
        this.driver = driver;

    }

    public void interactWithAlertsOK() {
        Alert FirtsAlert = driver.switchTo().alert();
        FirtsAlert.accept();
    }

    public void explicitAlertWait() {
        //definim un explicit wait ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interactWithDelayAlert() {
        explicitAlertWait();
        Alert SecondAlert = driver.switchTo().alert();
        SecondAlert.accept();
    }

    public void interactWithAlertCancel() {
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.dismiss();
    }

    public void interactWithAlertSendKey() {
        Alert fourthAlert = driver.switchTo().alert();
        fourthAlert.sendKeys("Isabela");
        fourthAlert.accept();

    }
}

package Pages;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Alerts_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;
    Alerts_Methods alertsMethods;

    public Alerts_Page(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new Elements_Methods(driver);
        alertsMethods = new Alerts_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="alertButton")
    WebElement FirstAlertElement;

    @FindBy(id ="timerAlertButton")
    WebElement SecondAlertElement;

    @FindBy(id ="confirmButton")
    WebElement ThirdAlertElement;

    @FindBy(id ="promtButton")
    WebElement FourthAlertElement;

    public void clickOnFirstAlertOK (){
        elementsMethods.clickOnElement(FirstAlertElement);
        alertsMethods.interactWithAlertsOK();
    }

    public void interactWithDelayAlert (){
        elementsMethods.clickOnElement(SecondAlertElement);
        alertsMethods.interactWithDelayAlert();
    }

    public void interactWithCancelAlert (){
        elementsMethods.clickOnElement(ThirdAlertElement);
        alertsMethods.interactWithAlertCancel();
    }

    public void interactSendKeyAlert (){
        elementsMethods.clickOnElement(FourthAlertElement);
        alertsMethods.interactWithAlertSendKey();
    }
}

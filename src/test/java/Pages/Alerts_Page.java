package Pages;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Logger.Logger_Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Alerts_Page extends SubMenu_Common_Page {


    @FindBy(id ="alertButton")
    private WebElement FirstAlertElement;

    @FindBy(id ="timerAlertButton")
    private WebElement SecondAlertElement;

    @FindBy(id ="confirmButton")
    private WebElement ThirdAlertElement;

    @FindBy(id ="promtButton")
    private WebElement FourthAlertElement;

    public Alerts_Page(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstAlertOK (){
        elementsMethods.clickOnElement(FirstAlertElement);
//        Logger_Utility.infoLog("The User click on element: " + FirstAlertElement);
        alertsMethods.interactWithAlertsOK();
//        Logger_Utility.infoLog("User interactioneaza cu prima alerta, click on OK button");
    }

    public void interactWithDelayAlert (){
        elementsMethods.clickOnElement(SecondAlertElement);
//        Logger_Utility.infoLog("The User click on second alert after 5 seconds" + SecondAlertElement);
        alertsMethods.interactWithDelayAlert();
        javaScriptMethods.scrollMethod(400, 0);
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

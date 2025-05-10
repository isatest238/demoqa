package Pages;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.Windows_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Browser_Page extends SubMenu_Common_Page{

    @FindBy(id ="tabButton")
    private WebElement newTabElement;

    @FindBy(id ="sampleHeading")
    private WebElement sampleHeading;

    @FindBy(id ="windowButton")
    private WebElement windowButton;

    @FindBy(id ="messageWindowButton")
    private WebElement messageWindowButton;

    public Browser_Page(WebDriver driver) {
        super(driver);
    }

    public void clickNewTabButtonVerifyCloseReturnToMain(){
        elementsMethods.clickOnElement(newTabElement);
        windowsMethods.switchToTab();
        System.out.println("Textul din new Tab este: " + sampleHeading.getText());
        windowsMethods.closeTab();
        windowsMethods.switchToMain();
    }

    public void clickNewWindowButtonVerifyCloseReturnToMain(){
        elementsMethods.clickOnElement(windowButton);
        windowsMethods.switchToTab();
        System.out.println("Textul din new Tab este: " + sampleHeading.getText());
        windowsMethods.closeTab();
        windowsMethods.switchToMain();
    }

    public void clickNewWindowMessageVerifyCloseReturnToMain(){
        elementsMethods.clickOnElement(messageWindowButton);
        windowsMethods.switchToTab();
        windowsMethods.closeTab();
        windowsMethods.switchToMain();
    }
}

package Pages.BeforeRef;

import Helper_Methods.Elements_Methods;
import Helper_Methods.Windows_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Browser_Page_Before_Ref {
    WebDriver driver;
    Elements_Methods elementsMethods;
    Windows_Methods windowsMethods;

    public Browser_Page_Before_Ref(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new Elements_Methods(driver);
        windowsMethods = new Windows_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="tabButton")
    WebElement newTabElement;

    @FindBy(id ="sampleHeading")
    WebElement sampleHeading;

    @FindBy(id ="windowButton")
    WebElement windowButton;

    @FindBy(id ="messageWindowButton")
    WebElement messageWindowButton;

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

package Pages;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.Windows_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Browser_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;
    Windows_Methods windowsMethods;

    public Browser_Page(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new Elements_Methods(driver);
        windowsMethods = new Windows_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="tabButton")
    WebElement newTabElement;

    public void clickNewTabButton(){
        elementsMethods.clickOnElement(newTabElement);
    }

}

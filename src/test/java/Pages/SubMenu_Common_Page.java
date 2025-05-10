package Pages;

import Helper_Methods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubMenu_Common_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;
    JavaScript_Methods javaScriptMethods;
    Alerts_Methods alertsMethods;
    Windows_Methods windowsMethods;
    Frames_Methods framesMethods;
    Home_Page homePage;

    public SubMenu_Common_Page(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new Elements_Methods(driver);
        this.javaScriptMethods = new JavaScript_Methods(driver);
        this.alertsMethods = new Alerts_Methods(driver);
        this.windowsMethods = new Windows_Methods(driver);
        this.framesMethods = new Frames_Methods(driver);
        PageFactory.initElements(driver, this);
    }
    //identificam webelementele specifice pentru SubMenu Page
    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> elements;

    // identificam metodele specifice pentru Homepage (face click ul pe Forms si te duce pe pagina SubMenu Page)
    public void goToDesiredSubMenuPage (String submenu){
        javaScriptMethods.scrollMethod(0,400);
        elementsMethods.selectElementFromListByText(elements, submenu);
        javaScriptMethods.scrollMethod(0, -400);
    }
}

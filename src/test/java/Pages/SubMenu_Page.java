package Pages;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SubMenu_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;
    JavaScript_Methods javaScriptMethods;

    public SubMenu_Page(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new Elements_Methods(driver);
        this.javaScriptMethods = new JavaScript_Methods(driver);
        PageFactory.initElements(driver, this);
    }
    //identificam webelementele specifice pentru SubMenu Page
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // identificam metodele specifice pentru Homepage (face click ul pe Forms si te duce pe pagina SubMenu Page)
    public void goToDesiredSubMenuPage (String submenu){
        javaScriptMethods.scrollMethod(0,400);
        elementsMethods.selectElementFromListByText(elements, submenu);
    }
}

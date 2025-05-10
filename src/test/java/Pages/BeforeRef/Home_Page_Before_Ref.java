package Pages.BeforeRef;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page_Before_Ref {
        WebDriver driver;
        Elements_Methods elementsMethods;
        JavaScript_Methods javaScriptMethods;
        Home_Page_Before_Ref homePage;

    public Home_Page_Before_Ref(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new Elements_Methods(driver);
        this.javaScriptMethods = new JavaScript_Methods(driver);
        PageFactory.initElements(driver, this);
    }

    //identificam webelementele specifice pentru Homepage
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    // identificam metodele specifice pentru Homepage (face click ul pe Forms si te duce pe pagina urmatoare)
    public void goToDesiredMenu (String menu){
        javaScriptMethods.scrollMethod(0,400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }
}

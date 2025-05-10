package Pages;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page extends SubMenu_Common_Page{


    //identificam webelementele specifice pentru Homepage
    @FindBy(xpath = "//h5")
    private List<WebElement> elements;

    public Home_Page(WebDriver driver) {
        super(driver);
    }

    // identificam metodele specifice pentru Homepage (face click ul pe Forms si te duce pe pagina urmatoare)
    public void goToDesiredMenu (String menu){
        javaScriptMethods.scrollMethod(0,400);
        elementsMethods.selectElementFromListByText(elements, menu);
    }
}

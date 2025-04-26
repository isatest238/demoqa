package Pages;

import Helper_Methods.Elements_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home_Page {
    WebDriver driver;
    Elements_Methods elementsMethods;


    public Home_Page(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new Elements_Methods(driver);
    }

// Identificam webElements specifice pentru pagina
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

// Methods specifice pentru pagina
    public void goToDesiredMenu (List<WebElement> elementList, String menu ){
        elementsMethods.selectElementFromListByText(elementList, menu);
    }

}

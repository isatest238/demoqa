package Pages;

import Helper_Methods.UiHelper;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalBarPage {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

//   // @FindBy(id = "PERSONAL-BAR-TILE-3")
//    @FindBy (css="a[aria-label='Meins']")
//    private  WebElement meinsButton;
private final By meinsButton = By.cssSelector("a[aria-label='Meins']");

    public PersonalBarPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
       // PageFactory.initElements(driver, this);
    }


    public void goToMeins() {
        new UiHelper(driver, wait).closeOverlaysIfPresent();

        // re-locate de fiecare dată (evită stale)
        wait.until(ExpectedConditions.elementToBeClickable(meinsButton)).click();
    }
}


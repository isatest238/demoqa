package Pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenuDropdown {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    // locators
    @FindBy(xpath = "//*[@id='MENU-USER']//i[@aria-hidden='true']")
    private WebElement userProfileBtn;

    @FindBy(id = "MENU-LOGOUT")
    private WebElement menuLogoutBtn;


    public MainMenuDropdown(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public MainMenuDropdown clickuserProfileBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileBtn)).click();
        return this;
    }

    public void clickmenuLogoutBtn() {
        wait.until(ExpectedConditions.visibilityOf(menuLogoutBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuLogoutBtn);
        wait.until(ExpectedConditions.elementToBeClickable(menuLogoutBtn)).click();
    }

}

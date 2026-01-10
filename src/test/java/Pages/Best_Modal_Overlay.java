package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Best_Modal_Overlay {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='OVERLAY-BUTTON']//a[@title='Login']")
    private WebElement overlayLoginBtn;

    @FindBy(xpath = "//*[@id='OVERLAY-BUTTON']//a[@title='Jetzt Abo abschließen']")
    private WebElement overlaySubscribeBtn;


    public Best_Modal_Overlay(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public boolean isOverlayLoginBtnVisible() {
        return wait.until(ExpectedConditions.visibilityOf(overlayLoginBtn)).isDisplayed();
    }

    public boolean isOverlaySubscribeBtnVisible() {
        return wait.until(ExpectedConditions.visibilityOf(overlaySubscribeBtn)).isDisplayed();
    }

    public boolean isDisplayed() {
        return isOverlayLoginBtnVisible() && isOverlaySubscribeBtnVisible();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(overlayLoginBtn)).click();
    }

}

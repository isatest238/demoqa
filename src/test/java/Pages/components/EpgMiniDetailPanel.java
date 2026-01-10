package Pages.components;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EpgMiniDetailPanel {

    @Getter private WebDriver driver;
    @Getter private WebDriverWait wait;

    @FindBy(id = "PLAY")
    private WebElement btnPlayLiveTv;

    @FindBy(id = "RESTART")
    private WebElement btnInstantRestart;

    public EpgMiniDetailPanel(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickZumLiveTv() {
        clickSafely(btnPlayLiveTv);
    }

    public void clickInstantRestart() {
        clickSafely(btnInstantRestart);
    }

    private void clickSafely(WebElement el) {
        WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(el));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});", clickable
        );
        try {
            clickable.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickable);
        }
    }
}

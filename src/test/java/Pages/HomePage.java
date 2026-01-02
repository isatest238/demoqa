package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[@class='V4i7m' and span='Jetzt läuft im TV']")
    private WebElement nowOnTvHeader;

    // Freemium indicator 1: login menu visible
    @FindBy(id = "MENU-LOGIN")
    private WebElement menuLoginBtn;

    // Freemium indicator 2: “KOSTENLOS & OHNE LOGIN:” text lane visible
    @FindBy(xpath = "//h2[span='KOSTENLOS & OHNE LOGIN:']")
    private WebElement kostenlosOhneLoginLabel;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getNowOnTvHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(nowOnTvHeader)).getText().trim();
    }

    public boolean isMenuLoginVisible() {
        return wait.until(ExpectedConditions.visibilityOf(menuLoginBtn)).isDisplayed();
    }

    public boolean isFreemiumLabelVisible() {
        return wait.until(ExpectedConditions.visibilityOf(kostenlosOhneLoginLabel)).isDisplayed();
    }

    public String getFreemiumLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(kostenlosOhneLoginLabel)).getText().trim();
    }


}
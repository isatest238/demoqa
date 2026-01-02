package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // locators
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesBtn;

    @FindBy(id = "MENU-LOGIN")
    private WebElement menuLoginBtn;

    @FindBy(css = "input[type='email']")
    private WebElement userInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(id = "pw_submit")
    private WebElement submitBtn;

    @FindBy(id = "dont_ask_again")
    private WebElement dontAskAgainBtn;

    @FindBy(xpath ="//dialog[contains(@class,'N5zV1') and @open]//button[@id='OVERLAY-CLOSE']")
    private WebElement overlayCloseBtn1;

    @FindBy(xpath = "//dialog[@open]//button[@id='OVERLAY-CLOSE']")
    private WebElement overlayCloseBtn2;


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn)).click();
        return this;
    }

    public LoginPage clickMenuLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(menuLoginBtn)).click();
        return this;
    }

    public LoginPage enterUserInput(String user) {
        wait.until(ExpectedConditions.elementToBeClickable(userInput)).sendKeys(user);
        return this;
    }

    public LoginPage clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }

    public LoginPage submitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }

    public LoginPage clickDontAskAgain() {
        wait.until(ExpectedConditions.elementToBeClickable(dontAskAgainBtn)).click();
        return this;
    }

    public LoginPage clickoverlayCloseBtn1() {
        wait.until(ExpectedConditions.elementToBeClickable(overlayCloseBtn1)).click();        ;
        return this;
    }
    public LoginPage clickoverlayCloseBtn2() {
        wait.until(ExpectedConditions.elementToBeClickable(overlayCloseBtn2)).click();        ;
        return this;
    }
}

package Helper_Methods;
import Pages.Best_Modal_Overlay;
import Pages.HomePage;
import Pages.LoginPage;
import PropertyUtility.Property_Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class FreemiumFlows {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FreemiumFlows(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToFreemiumPage() {
        driver.manage().window().maximize();
        HashMap<String, String> data = new Property_Utility("Common").getAllData();
        AuthHelper.openWithBasicAuth(driver, data.get("basicUser"), data.get("basicPass"), data.get("baseUrl"));
        new LoginPage(driver, wait).acceptCookies();
    }

    public void assertFreemium() {
        // Freemium validations
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isMenuLoginVisible(), "Freemium: MENU-LOGIN should be visible");
        Assert.assertTrue(home.isFreemiumLabelVisible(), "Freemium: label should be visible");

    }

    public void loginFromOverlay(Map<String, String> data) {
        Best_Modal_Overlay overlay = new Best_Modal_Overlay(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);
        UiHelper uiHelper = new UiHelper(driver, wait);
        Assert.assertTrue(overlay.isDisplayed(), "Login overlay should be displayed");

        overlay.clickLogin();
        loginPage.enterUserInput(data.get("loginUser"));
        loginPage.clickNext();

        loginPage.enterPassword(data.get("loginPass"));
        loginPage.submitLogin();

        loginPage.clickDontAskAgain();

        loginPage.clickoverlayCloseBtn1();
        loginPage.clickoverlayCloseBtn2();

        uiHelper.pressEsc();
        uiHelper.pressEsc();
    }
}

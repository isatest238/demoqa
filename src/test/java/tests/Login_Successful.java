import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.AuthHelper;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class Login_Successful extends Hooks {

    @Test
    public void Login_Successful() {

        // ia datele pentru testul curent (folosește numele clasei)
        HashMap<String, String> data = new Property_Utility(this.getClass().getSimpleName()).getAllData();

        getDriver().manage().window().maximize();

        AuthHelper.openWithBasicAuth(getDriver(),
                data.get("basicUser"),
                data.get("basicPass"),
                data.get("baseUrl")
        );


        // 2) De aici începe flow-ul real din pagină (cookies + Login etc.)
        WebElement acceptAllCookies = getWait().until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        acceptAllCookies.click();


        WebElement loginButton = getWait().until(ExpectedConditions.elementToBeClickable(By.id("MENU-LOGIN")));
        loginButton.click();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"Click on Login button was done with success");


        WebElement username = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        username.sendKeys(data.get("loginUser"));

        WebElement next = getWait().until(ExpectedConditions.elementToBeClickable(By.id("pw_submit")));
        next.click();


        WebElement password = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        password.sendKeys(data.get("loginPass"));


        WebElement login2 = getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("scale-button#pw_submit")));
        login2.click();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 6000);"); // 600px in jos

        WebElement spater2 = getWait().until(ExpectedConditions.elementToBeClickable(By.id("dont_ask_again")));
        spater2.click();

        // close the cookie pages using ESC key
        Actions actions = new Actions(getDriver());
        // Send ESC key globally
        actions.sendKeys(Keys.ESCAPE).perform();

        // identify unique element from the Home Page
        WebElement homeScreenElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='V4i7m' and span='Jetzt läuft im TV']")));

        Assert.assertEquals(homeScreenElement.getText(), data.get("expectedHeader"), "Text verification failed!");

    }
}

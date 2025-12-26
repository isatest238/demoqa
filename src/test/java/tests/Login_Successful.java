import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.AuthHelper;
import Pages.HomePage;
import Pages.LoginPage;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
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

        LoginPage loginPage = new LoginPage(getDriver(), getWait());
        loginPage.acceptCookies();
        loginPage.clickMenuLoginBtn();
        loginPage.enterUserInput(data.get("loginUser"));
        loginPage.clickNext();
        loginPage.enterPassword(data.get("loginPass"));
        loginPage.submitLogin();
        loginPage.clickDontAskAgain();


        // close the cookie pages using ESC key
        Actions actions = new Actions(getDriver());
        // Send ESC key globally
        actions.sendKeys(Keys.ESCAPE).perform();

        // identify unique element from the Home Page
        HomePage homePage = new HomePage(getDriver(), getWait());


        Assert.assertEquals(homePage.getNowOnTvHeaderText(), data.get("expectedHeader"), "Text verification failed!");

    }
}

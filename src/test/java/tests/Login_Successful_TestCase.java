import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.AuthHelper;
import Helper_Methods.UiHelper;
import Logger.Logger_Utility;
import Pages.HomePage;
import Pages.LoginPage;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Login_Successful_TestCase extends Hooks {

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
        Logger_Utility.infoLog("Authentication with pampalini was made with success");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Authentication with pampalini was made with success");

        LoginPage loginPage = new LoginPage(getDriver(), getWait());
        loginPage.acceptCookies();
        loginPage.clickMenuLoginBtn();
        Logger_Utility.infoLog("Login button was clicked");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Login button was clicked");

        loginPage.enterUserInput(data.get("loginUser"));
        loginPage.clickNext();
        Logger_Utility.infoLog("Username inserted and Next button was clicked");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Username inserted and Next button was clicked");


        loginPage.enterPassword(data.get("loginPass"));
        loginPage.submitLogin();
        Logger_Utility.infoLog("Password inserted and Submit button was clicked");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Password inserted and Next button was clicked");


        loginPage.clickDontAskAgain();
        Logger_Utility.infoLog("Don't Ask Again button was clicked");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Don't Ask Again button was clicked");

        UiHelper uiHelper = new UiHelper(getDriver(), getWait());
        uiHelper.pressEsc();

        HomePage homePage = new HomePage(getDriver(), getWait());
        Assert.assertEquals(homePage.getNowOnTvHeaderText(), data.get("expectedHeader"), "Text verification failed!");

        Logger_Utility.infoLog("Login made with success");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Login made with success");


    }
}

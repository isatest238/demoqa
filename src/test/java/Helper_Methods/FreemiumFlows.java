package Helper_Methods;
import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Logger.Logger_Utility;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Map;


public class FreemiumFlows {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public FreemiumFlows(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToFreemiumPage(Map<String,String> data) {
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Navigate to Freemium page (Basic Auth + accept cookies)");
        Logger_Utility.infoLog("Navigate to Freemium page (Basic Auth + accept cookies)");

        driver.manage().window().maximize();
        AuthHelper.openWithBasicAuth(driver, data.get("basicUser"), data.get("basicPass"), data.get("baseUrl"));
        new LoginPage(driver, wait).acceptCookies();

        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Freemium page opened successfully");
        Logger_Utility.infoLog("Freemium page opened successfully");
    }

    public void assertFreemium() {
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Validate Freemium state: MENU-LOGIN visible & Freemium label visible");
        Logger_Utility.infoLog("Validate Freemium state");

        HomePage home = new HomePage(driver, wait);

        Assert.assertTrue(home.isMenuLoginVisible(), "Freemium: MENU-LOGIN should be visible");
        Assert.assertTrue(home.isFreemiumLabelVisible(), "Freemium: label should be visible");

        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Freemium mode confirmed");
        Logger_Utility.infoLog("Freemium mode confirmed");

    }


}

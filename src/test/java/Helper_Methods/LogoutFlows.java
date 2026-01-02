package Helper_Methods;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Logger.Logger_Utility;
import Pages.MainMenuDropdown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutFlows {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LogoutFlows(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void logout() {
        Logger_Utility.infoLog("Logout flow started: opening user profile menu");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Logout flow started: opening user profile menu");

        MainMenuDropdown menu = new MainMenuDropdown(driver, wait);
        menu.clickuserProfileBtn();

        Logger_Utility.infoLog("User profile menu opened.");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "User profile menu opened.");

        menu.clickmenuLogoutBtn();
        Logger_Utility.infoLog("Logout button clicked");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Logout button clicked");

        Logger_Utility.infoLog("Logout completed");
        Extent_Utility.attachLog(Report_Step.PASS_STEP, "Logout completed");
    }


}

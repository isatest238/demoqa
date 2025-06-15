package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Helper_Methods.Windows_Methods;
import Pages.Browser_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Hooks;
import org.testng.annotations.Test;

public class Browser_Windows_Ref extends Hooks {

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Browser_Page browserPage;

    @Test
    public void automationMethod3() throws InterruptedException {

        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());
        browserPage = new Browser_Page(getDriver());


        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Browser Windows");
        browserPage.clickNewTabButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowMessageVerifyCloseReturnToMain();
    }
}

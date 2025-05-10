package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Helper_Methods.Windows_Methods;
import Pages.Browser_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Shared_Data;
import org.testng.annotations.Test;

public class Browser_Windows_Ref extends Shared_Data {

    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Windows_Methods windowsMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Browser_Page browserPage;

    @Test
    public void automationMethod3() throws InterruptedException {

        javaScriptMethods = new JavaScript_Methods(driver);
        elementsMethods = new Elements_Methods(driver);
        windowsMethods = new Windows_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);
        browserPage = new Browser_Page(driver);


        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Browser Windows");
        browserPage.clickNewTabButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowButtonVerifyCloseReturnToMain();
        browserPage.clickNewWindowMessageVerifyCloseReturnToMain();
    }
}

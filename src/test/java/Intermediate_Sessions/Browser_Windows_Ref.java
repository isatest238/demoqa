package Intermediate_Sessions;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
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
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Alerts, Frame& Windows menu");

        subMenuPage.goToDesiredSubMenuPage("Browser Windows");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters oBrowser Windows menu");

        browserPage.clickNewTabButtonVerifyCloseReturnToMain();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user interacts with the new browser tab and return to main");

        browserPage.clickNewWindowButtonVerifyCloseReturnToMain();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user interacts new window / close the windows and return to main");

        browserPage.clickNewWindowMessageVerifyCloseReturnToMain();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user interacts new window / close the windows and return to main");

    }
}

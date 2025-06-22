package Intermediate_Sessions;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.Elements_Methods;
import Helper_Methods.Frames_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Frames_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Hooks;
import org.testng.annotations.Test;

public class Frames_Ref extends Hooks {

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Frames_Page framesPage;

    @Test
    public void automationMethod3() throws InterruptedException {

        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());
        framesPage = new Frames_Page(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Alerts, Frame& Windows menu");

        subMenuPage.goToDesiredSubMenuPage("Frames");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Frames submenu");

        framesPage.switchToFrameVerifySwitchToMain();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user interacts with the first iframe");
        //javaScriptMethods.scrollMethod(0, 600);

        framesPage.switchToFrameScrollSwitchToMain();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user interacts with the second iframe");
    }
}

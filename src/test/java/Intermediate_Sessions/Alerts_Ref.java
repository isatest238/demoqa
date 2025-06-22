package Intermediate_Sessions;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Alerts_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Hooks;
import org.testng.annotations.Test;

public class Alerts_Ref extends Hooks {

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Alerts_Page alertsPage;


    @Test
    public void automationMethod2() {

        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());
        //alertsMethods = new Alerts_Methods(getDriver());
        alertsPage = new Alerts_Page(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Alerts, Frame& Windows menu");


        subMenuPage.goToDesiredSubMenuPage("Alerts");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Alerts submenu");
        //javaScriptMethods.scrollMethod(0, -400);
        alertsPage.clickOnFirstAlertOK();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user deals with the alert with OK");

        alertsPage.interactWithDelayAlert();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user deals with the alert with Delay");
        //javaScriptMethods.scrollMethod(400, 0);

        alertsPage.interactWithCancelAlert();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user deals with the alert with Cancel");

        alertsPage.interactSendKeyAlert();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user deals with the alert with sendkey");
    }
}

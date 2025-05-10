package Intermediate_Sessions;

import Helper_Methods.Alerts_Methods;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Alerts_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Shared_Data;
import org.testng.annotations.Test;

public class Alerts_Ref extends Shared_Data {

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
        subMenuPage.goToDesiredSubMenuPage("Alerts");
        //javaScriptMethods.scrollMethod(0, -400);
        alertsPage.clickOnFirstAlertOK();
        alertsPage.interactWithDelayAlert();
        //javaScriptMethods.scrollMethod(400, 0);

        alertsPage.interactWithCancelAlert();
        alertsPage.interactSendKeyAlert();
    }
}

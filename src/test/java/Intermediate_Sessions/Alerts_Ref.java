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

    public Elements_Methods elementsMethods;
    public Alerts_Methods alertsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Alerts_Page alertsPage;

    @Test
    public void automationMethod2() {

        elementsMethods = new Elements_Methods(driver);
        alertsMethods = new Alerts_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);
        alertsMethods = new Alerts_Methods(driver);
        alertsPage = new Alerts_Page(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Alerts");
        javaScriptMethods.scrollMethod(0, -400);
        alertsPage.clickOnFirstAlertOK();
        alertsPage.interactWithDelayAlert();

        javaScriptMethods.scrollMethod(400, 0);
        alertsPage.interactWithCancelAlert();
        alertsPage.interactSendKeyAlert();
    }
}

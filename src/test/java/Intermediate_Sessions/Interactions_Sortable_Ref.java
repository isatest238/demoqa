package Intermediate_Sessions;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Hooks;
import org.testng.annotations.Test;

public class Interactions_Sortable_Ref extends Hooks{

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;

    @Test
    public void automationMethod() {


        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());

        homePage.goToDesiredMenu("Interactions");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Interaction submenu");

        subMenuPage.goToDesiredSubMenuPage("Sortable");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Sortable submenu");


    }
}

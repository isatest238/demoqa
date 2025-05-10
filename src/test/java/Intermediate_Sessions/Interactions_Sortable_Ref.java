package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Shared_Data;
import org.testng.annotations.Test;

public class Interactions_Sortable_Ref extends Shared_Data {
    public Elements_Methods elementsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;

    @Test
    public void automationMethod() {

        elementsMethods = new Elements_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);

        homePage.goToDesiredMenu("Interactions");
        subMenuPage.goToDesiredSubMenuPage("Sortable");

    }
}

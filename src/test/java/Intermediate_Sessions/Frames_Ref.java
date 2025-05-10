package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.Frames_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Frames_Page;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Shared_Data.Shared_Data;
import org.testng.annotations.Test;

public class Frames_Ref extends Shared_Data {

    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Frames_Methods framesMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    Frames_Page framesPage;

    @Test
    public void automationMethod3() throws InterruptedException {

        javaScriptMethods = new JavaScript_Methods(driver);
        elementsMethods = new Elements_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);
        framesPage = new Frames_Page(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        subMenuPage.goToDesiredSubMenuPage("Frames");

        framesPage.switchToFrameVerifySwitchToMain();
        javaScriptMethods.scrollMethod(0, 600);
        framesPage.switchToFrameScrollSwitchToMain();
    }
}

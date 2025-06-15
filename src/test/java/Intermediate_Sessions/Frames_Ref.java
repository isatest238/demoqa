package Intermediate_Sessions;

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
        subMenuPage.goToDesiredSubMenuPage("Frames");

        framesPage.switchToFrameVerifySwitchToMain();
        //javaScriptMethods.scrollMethod(0, 600);
        framesPage.switchToFrameScrollSwitchToMain();
    }
}

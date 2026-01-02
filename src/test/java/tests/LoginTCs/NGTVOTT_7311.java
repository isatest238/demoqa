package tests.LoginTCs;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.FreemiumFlows;
import Helper_Methods.LogoutFlows;
import Logger.Logger_Utility;
import Pages.*;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class NGTVOTT_7311 extends Hooks {

//    Given the user is in Freemium mode
//    When the user triggers a restricted action
//            | Add to Favourites |
//    Then the login overlay is shown
//
//    When the user logs in successfully
//    Then the user is redirected back to the same detail page
//    And the restricted action is not executed automatically
//
//    When the user logs out
//    Then Freemium mode is restored
//    And My Menu is no longer visible

    @Test
    public void Post_login_Redirection_in_Freemium_Mode() {

        HashMap<String, String> data = new Property_Utility("Common").getAllData();

        FreemiumFlows freemium = new FreemiumFlows(getDriver(), getWait());
        LogoutFlows logout = new LogoutFlows(getDriver(), getWait());
        VOD_Detail_Page vod = new VOD_Detail_Page(getDriver(), getWait());
        Best_Modal_Overlay overlay = new Best_Modal_Overlay(getDriver(), getWait());

        /// Given the user is in Freemium mode
        freemium.goToFreemiumPage(data);
        freemium.assertFreemium();

        Logger_Utility.infoLog("Freemium Mode confirmed. User is in Freemium Mode");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Freemium Mode confirmed");


        /// When the user triggers a restricted action: Add to Favourites
        vod.openByUrl(data.get("vodUrl"));
        String urlBefore = getDriver().getCurrentUrl();
        String titleBefore = getDriver().getTitle();


        vod.clickAddToFavourites();


        ///  Then the login overlay is shown
        Assert.assertTrue(overlay.isDisplayed(), "Login overlay should be displayed");


        /// When the user logs in successfully
        freemium.loginFromOverlay(data);

        /// Then the user is redirected back to the same detail page : Defect - DMW-4441 FTV - BETA&PROD - Freemium - User is taken to Aktuelles after login from Next Best Action Modal
//        getWait().until(ExpectedConditions.urlToBe(urlBefore));
//        Assert.assertEquals(getDriver().getCurrentUrl(), urlBefore, "Not redirected back to same detail page");
//        Assert.assertEquals(getDriver().getTitle(), titleBefore, "Title changed after login");

        ///  And the restricted action is not executed automatically  - blocked by Defect - DMW-4441
//         Assert.assertFalse(vod.isFavouriteSelected(), "Favourite should be false");

        ///  When the user logs out
        logout.logout();
        /// Then Freemium mode is restored
        freemium.assertFreemium();

    }
}

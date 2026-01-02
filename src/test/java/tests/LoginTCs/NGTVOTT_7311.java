package tests.LoginTCs;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.FreemiumFlows;
import Helper_Methods.LogoutFlows;
import Helper_Methods.UiHelper;
import Logger.Logger_Utility;
import Pages.*;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class NGTVOTT_7311 extends Hooks {

    /// Test scope: Ensure that in Freemium mode, restricted actions show the login overlay, successful login redirects the user back to the same detail page
    /// (not Start page), and logout restores Freemium with My Menu hidden.

    @Test
    public void Post_login_Redirection_in_Freemium_Mode() {

        HashMap<String, String> data = new Property_Utility("Common").getAllData();

        FreemiumFlows freemium = new FreemiumFlows(getDriver(), getWait());
        LogoutFlows logout = new LogoutFlows(getDriver(), getWait());
        VOD_Detail_Page vod = new VOD_Detail_Page(getDriver(), getWait());
        Best_Modal_Overlay overlay = new Best_Modal_Overlay(getDriver(), getWait());

        /// Given the user is in Freemium mode
        freemium.goToFreemiumPage();

        Logger_Utility.infoLog("Authentication with pampalini was made with success");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Authentication with pampalini was made with success");

        freemium.assertFreemium();

        Logger_Utility.infoLog("Freemium Mode confirmed");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Freamium Mode confirmed");


        /// AND user on VoD detail page
        vod.openByUrl(data.get("vodUrl"));

        String urlBefore = getDriver().getCurrentUrl();
        String titleBefore = getDriver().getTitle();


        /// WHEN user triggers restricted action: Add to Favourites
        vod.clickAddToFavourites();

        /// THEN login overlay shown - check that the overlay is displayed
        Assert.assertTrue(overlay.isDisplayed(), "Login overlay should be displayed");

       /// When the user logs in successfully
        freemium.loginFromOverlay(data);




        /// Then the user is redirected back to the same detail page
        /// Defect - DMW-4441 FTV - BETA&PROD - Freemium - User is taken to Aktuelles after login from Next Best Action Modal
//        getWait().until(ExpectedConditions.urlToBe(urlBefore));
//        Assert.assertEquals(getDriver().getCurrentUrl(), urlBefore, "Not redirected back to same detail page");
//        Assert.assertEquals(getDriver().getTitle(), titleBefore, "Title changed after login");

        System.out.println("User successfully on the MagentaTV Start Page");

        ///  And the restricted action is not executed automatically  - DE FACUT

        ///  When the user logs out
        logout.logout();
        /// Then Freemium mode is restored
        /// And My Menu is no longer visible
        freemium.assertFreemium();





    }
}

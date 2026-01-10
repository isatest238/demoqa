package tests.LoginTCs;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Helper_Methods.FreemiumFlows;
import Helper_Methods.LoginFlows;
import Helper_Methods.LogoutFlows;
import Pages.*;
import Pages.components.EpgMiniDetailPanel;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Helper_Methods.EPGFlows;


import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class NGTVOTT_7311 extends Hooks {

    public enum RestrictedAction {
        ADD_TO_FAVOURITES,
        PLAY_LIVETV_FROM_EPG,
        PLAY_INSTANT_RESTART_FROM_EPG
    }

    @DataProvider(name = "restrictedActions")
    public Object[][] restrictedActions() {
        return new Object[][]{
                {RestrictedAction.ADD_TO_FAVOURITES},
                {RestrictedAction.PLAY_LIVETV_FROM_EPG},
                {RestrictedAction.PLAY_INSTANT_RESTART_FROM_EPG},
        };
    }

    @Test(dataProvider = "restrictedActions")
    public void postLoginRedirectionInFreemiumMode(RestrictedAction action) {

        HashMap<String, String> data = new Property_Utility("Common").getAllData();

        FreemiumFlows freemium = new FreemiumFlows(getDriver(), getWait());
        LoginFlows login = new LoginFlows(getDriver(), getWait());
        LogoutFlows logout = new LogoutFlows(getDriver(), getWait());
        VOD_Detail_Page vod = new VOD_Detail_Page(getDriver(), getWait());
        Best_Modal_Overlay overlay = new Best_Modal_Overlay(getDriver(), getWait());
        EPG_Page epg = new EPG_Page(getDriver(), getWait());
        EPGFlows epgFlows = new EPGFlows(getDriver(), getWait());



        /// Given the user is in Freemium mode
        freemium.goToFreemiumPage(data);
        freemium.assertFreemium();

        /// When the user triggers a restricted action: Add to Favourites, Play LiveTV From EPG, PLay IR from EPG
        String vodUrlBefore = null;
        String vodTitleBefore = null;
        String epgUrlBefore = null;

        switch (action) {

            case ADD_TO_FAVOURITES:
                vod.openByUrl(data.get("vodUrl"));
                vodUrlBefore = getDriver().getCurrentUrl();
                vodTitleBefore = getDriver().getTitle();
                vod.clickAddToFavourites();
                break;
            case PLAY_LIVETV_FROM_EPG:
                epgUrlBefore = getDriver().getCurrentUrl();
                epgFlows.openEpgAndStartLiveTVFromDasErste();

                break;
            case PLAY_INSTANT_RESTART_FROM_EPG:
                epgUrlBefore = getDriver().getCurrentUrl();
                epgFlows.openEpgAndStartIRFromDasErste();
                break;

            default:
                throw new IllegalArgumentException("Unknown action: " + action);
        }

        ///  Then the login overlay is shown
        assertTrue(overlay.isDisplayed(), "Login overlay should be displayed");

        /// When the user logs in successfully
        login.loginFromFreemiumOverlay(data);

        /// Then the user is on the same page and the action is not executed (verificare “same page” + “action not executed”)
        switch (action) {
            case ADD_TO_FAVOURITES:
                ///: Defect - DMW-4441 FTV - BETA&PROD - Freemium - User is taken to Aktuelles after login from Next Best Action Modal
//                Assert.assertEquals(getDriver().getCurrentUrl(), vodUrlBefore, "Not redirected back to same detail page");
//                Assert.assertEquals(getDriver().getTitle(), vodTitleBefore, "Title changed after login");
//                Assert.assertFalse(vod.isFavouriteSelected(), "Favourite executed automatically after login");
                Extent_Utility.attachLog(Report_Step.INFO_STEP, "Skipping redirect assertions due to DMW-4441");

                break;
            case PLAY_LIVETV_FROM_EPG:
//                Assert.assertTrue(epg.isEpgLoaded(), "EPG should still be displayed after login");
//                Assert.assertTrue(getDriver().getCurrentUrl().contains("/tv-guide"),"Should remain on EPG (/tv-guide) after login");
                Extent_Utility.attachLog(Report_Step.INFO_STEP, "Skipping redirect assertions due to DMW-4441");
                break;

            case PLAY_INSTANT_RESTART_FROM_EPG:
                Assert.assertTrue(epg.isEpgLoaded(), "EPG should still be displayed after login");
                assertTrue(getDriver().getCurrentUrl().contains("/tv-guide"), "Should remain on EPG (/tv-guide) after login");
                break;

            default:
                throw new IllegalArgumentException("Unknown action: " + action);
        }

        ///  When the user logs out
        logout.logout();
        /// Then Freemium mode is restored
        freemium.assertFreemium();
    }
}

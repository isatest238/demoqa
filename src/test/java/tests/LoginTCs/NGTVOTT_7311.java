package tests.LoginTCs;

import Helper_Methods.FreemiumFlows;
import Helper_Methods.LogoutFlows;
import Pages.*;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class NGTVOTT_7311 extends Hooks {

    public enum RestrictedAction {
        ADD_TO_FAVOURITES,
        PLAY_FROM_EPG,
        INSTANT_RESTART
    }

    @DataProvider(name = "restrictedActions")
    public Object[][] restrictedActions() {
        return new Object[][]{
                {RestrictedAction.ADD_TO_FAVOURITES},
                {RestrictedAction.PLAY_FROM_EPG}
                // {RestrictedAction.INSTANT_RESTART}
        };
    }

    @Test(dataProvider = "restrictedActions")

    public void Post_login_Redirection_in_Freemium_Mode(RestrictedAction action) {

        HashMap<String, String> data = new Property_Utility("Common").getAllData();

        FreemiumFlows freemium = new FreemiumFlows(getDriver(), getWait());
        LogoutFlows logout = new LogoutFlows(getDriver(), getWait());

        VOD_Detail_Page vod = new VOD_Detail_Page(getDriver(), getWait());
        Best_Modal_Overlay overlay = new Best_Modal_Overlay(getDriver(), getWait());

        EPG_Page epg = new EPG_Page(getDriver(), getWait());
HomePage home = new HomePage(getDriver(), getWait());
        // TODO: înlocuiește cu PageObject-urile reale la voi
//        EPG_Page epg = new EPG_Page(getDriver(), getWait());
//        Player_Page player = new Player_Page(getDriver(), getWait());

        /// Given the user is in Freemium mode
        freemium.goToFreemiumPage(data);
        freemium.assertFreemium();


        /// When the user triggers a restricted action: Add to Favourites

        String urlBefore;
        String titleBefore;

        switch (action) {

            case ADD_TO_FAVOURITES:
                vod.openByUrl(data.get("vodUrl"));
                urlBefore = getDriver().getCurrentUrl();
                titleBefore = getDriver().getTitle();
                vod.clickAddToFavourites();
                break;
            case PLAY_FROM_EPG:
                // 1) open EPG
               home.clickEPgIcon();
                // 2) select locked program and start play
                epg.playLiveTvShowRTL();
               break;
            case INSTANT_RESTART:
                // TODO: completezi când e cazul
                // player.openLive();
                // urlBefore = getDriver().getCurrentUrl();
                // titleBefore = getDriver().getTitle();
                // player.clickInstantRestart();
                throw new UnsupportedOperationException("INSTANT_RESTART not implemented yet");

            default:
                throw new IllegalArgumentException("Unknown action: " + action);


        }


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

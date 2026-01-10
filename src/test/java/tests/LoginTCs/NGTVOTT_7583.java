package tests.LoginTCs;

import Helper_Methods.FreemiumFlows;
import Helper_Methods.LoginFlows;
import Helper_Methods.MerklisteFlow;
import java.util.HashMap;

import Helper_Methods.UiHelper;
import Pages.MerklistePage;
import Pages.PersonalBarPage;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class NGTVOTT_7583 extends Hooks {

    @Test
    public void removeFromWatchlistEditMode (){
        HashMap<String, String> data = new Property_Utility("Common").getAllData();

        FreemiumFlows freemium = new FreemiumFlows(getDriver(), getWait());
        LoginFlows login = new LoginFlows(getDriver(), getWait());


        /// Given the user is logged in
        freemium.goToFreemiumPage(data);
        login.normalLogin(data);

//        UiHelper helper = new UiHelper(getDriver(), getWait());
//        helper.closeOverlaysIfPresent();


        PersonalBarPage personalBarPage = new PersonalBarPage(getDriver(), getWait());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");   //scroll in jos un pic

        personalBarPage.goToMeins();


//        MerklistePage merklistePage = new MerklistePage(getDriver(), getWait());
//        merklistePage.goToMerkliste();
//
//        MerklisteFlow  merklisteFlow = new MerklisteFlow(getDriver(), getWait());
//        merklisteFlow.ensureMerklisteHasMoreThan3Items(data);


    }

}

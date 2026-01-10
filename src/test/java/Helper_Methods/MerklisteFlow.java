package Helper_Methods;

import Pages.MerklistePage;
import Pages.PersonalBarPage;
import Pages.VOD_Detail_Page;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class MerklisteFlow {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    public MerklisteFlow(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void ensureMerklisteHasMoreThan3Items(HashMap<String, String> data) {

        new PersonalBarPage(driver, wait).goToMeins();
        MerklistePage merkliste = new MerklistePage(driver, wait);
        merkliste.goToMerkliste();

        merkliste.debugMerklisteCandidates();

        int count = merkliste.getMerklisteCountFromAria();
        System.out.println("Merkliste aria count = " + count);

        if (count > 3) return;

        int needed = 4 - count;
        addItemsToFavoritesFromVodUrls(needed, data);

        new PersonalBarPage(driver, wait).goToMeins();
        merkliste = new MerklistePage(driver, wait);
        merkliste.goToMerkliste();

        int newCount = merkliste.getMerklisteCountFromAria();
        System.out.println("Merkliste new aria count = " + newCount);

        if (newCount <= 3) {
            throw new AssertionError("Precondition failed: Merkliste still has <= 3 items. Count=" + newCount);
        }
    }

    private void addItemsToFavoritesFromVodUrls(int needed, HashMap<String, String> data) {
        VOD_Detail_Page vod = new VOD_Detail_Page(driver, wait);

        for (int i = 1; i <= needed; i++) {
            // ex: data keys: vodUrl1, vodUrl2, vodUrl3...
            String url = data.get("vodUrl" + i);
            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException("Missing test data key: vodUrl" + i);
            }

            vod.openByUrl(url);
            UiHelper helper = new UiHelper(getDriver(), getWait());
            helper.closeOverlaysIfPresent();
            // dacă e deja favorit, sari peste
            if (!vod.isFavouriteSelected()) {

                vod.clickAddToFavourites();
            }
        }
    }

}

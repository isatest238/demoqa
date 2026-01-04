package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EPG_Page {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (id = "epg_ch_259728423995")
    private WebElement rtlChannel;


    public EPG_Page(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public EPG_Page playLiveTvShowRTL() {
        wait.until(ExpectedConditions.elementToBeClickable(rtlChannel)).click();
        return this;
    }

    public boolean isEpgLoaded() {
        try { return rtlChannel.isDisplayed(); }
        catch (Exception e) { return false; }
    }


}

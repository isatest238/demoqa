package Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EPG_Page {

    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    @FindBy(id = "epg_ch_259728423995")
    private WebElement rtlChannel;

    @FindBy(xpath = "(//button[contains(@aria-label,'Das Erste')])[1]")
    private WebElement dasErsteTVshow;

    @FindBy(id = "RESTART")
    private WebElement instantRestart;


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
        try {
            return rtlChannel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void switchToEpgIframe() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.switchTo().defaultContent();

        List<WebElement> frames = driver.findElements(By.cssSelector("iframe"));
        if (frames.isEmpty()) return;

        for (WebElement f : frames) {
            try {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(f);

                long epgButtons = ((Number) js.executeScript(
                        "return document.querySelectorAll(\"button[id^='epg_pr_'][aria-label]\").length;"
                )).longValue();

                long gridCells = ((Number) js.executeScript(
                        "return document.querySelectorAll(\"div[role='gridcell'], [role='gridcell']\").length;"
                )).longValue();

                // Daca gasim butoanele epg_pr_ sau macar multe gridcells, asta e candidatul
                if (epgButtons > 0 || gridCells > 10) {
                    return; // suntem in frame-ul bun
                }
            } catch (Exception ignored) {
            }
        }

        // daca nu am gasit, revenim
        driver.switchTo().defaultContent();
    }

    public void clickProgramFromDasErsteBestEffort() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) intra in iframe-ul corect
        switchToEpgIframe();

        // 2) asteapta sa apara orice tile clickabil in frame
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button[aria-label*='Das Erste'], button[id^='epg_pr_'][aria-label]")
        ));

        // 3) ia toate tile-urile Das Erste
        List<WebElement> tiles = driver.findElements(
                By.cssSelector("button[aria-label*='Das Erste']")
        );

        if (tiles.isEmpty()) {
            throw new RuntimeException("No Das Erste tiles found inside iframe.");
        }

        // 4) click pe primul vizibil/clickabil (suficient pt overlay restrictionat)
        WebElement candidate = null;
        for (WebElement t : tiles) {
            try {
                if (!t.isDisplayed()) continue;
                js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", t);
                candidate = t;
                break;
            } catch (Exception ignored) {
            }
        }

        if (candidate == null) {
            candidate = tiles.get(0);
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(candidate)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", candidate);
        } finally {
            // IMPORTANT: overlay-ul de login poate fi in top document, deci revenim
            driver.switchTo().defaultContent();
        }
    }


    public EPG_Page playIR() {
        wait.until(ExpectedConditions.elementToBeClickable(instantRestart)).click();
        return this;
    }


}

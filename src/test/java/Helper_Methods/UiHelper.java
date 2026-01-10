package Helper_Methods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UiHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ESC global
    public void pressEsc() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public void closeOverlaysIfPresent() {
        // 0) încearcă ESC (ieftin și sigur)
        try { pressEsc(); } catch (Exception ignored) {}

        // 1) Închide dialogurile native <dialog open>
        try {
            By openDialogs = By.cssSelector("dialog[open]");
            if (!driver.findElements(openDialogs).isEmpty()) {
                By closeBtn = By.xpath("//*[self::button or self::a][@aria-label='Close' or @aria-label='Schließen' or @title='Close' or @title='Schließen']");
                if (!driver.findElements(closeBtn).isEmpty()) {
                    wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
                } else {
                    ((JavascriptExecutor) driver).executeScript(
                            "document.querySelectorAll('dialog[open]').forEach(d => d.close && d.close());"
                    );
                }
                wait.until(ExpectedConditions.numberOfElementsToBe(openDialogs, 0));
            }
        } catch (Exception ignored) {}

        // 2) Închide modale “clasice” (buton X / schließen / close / ok / verstanden)
        // (aici prindem și popups gen “Das neue MagentaTV”)
        By commonCloseButtons = By.xpath(
                "//*[self::button or self::a]" +
                        "[contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'schließ')" +
                        " or contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'close')" +
                        " or contains(translate(@title,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'schließ')" +
                        " or contains(translate(@title,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'close')" +
                        " or normalize-space()='OK' or normalize-space()='Ok' or normalize-space()='Verstanden' or normalize-space()='Alles klar']"
        );

        try {
            if (!driver.findElements(commonCloseButtons).isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(commonCloseButtons)).click();
            }
        } catch (Exception ignored) {}

        // 3) Backdrop/overlay full-screen: click pe el ca să dispară
        // (foarte des overlay-ul e un div mare care blochează click-urile)
        try {
            By backdrop = By.cssSelector(
                    "[class*='overlay'],[class*='backdrop'],[class*='modal'],[class*='scrim']"
            );
            for (WebElement el : driver.findElements(backdrop)) {
                try {
                    if (el.isDisplayed()) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                    }
                } catch (Exception ignored) {}
            }
        } catch (Exception ignored) {}

        // 4) Ultimul resort: dacă încă există ceva care blochează, îl scoatem din DOM
        // (nu e “pur”, dar e super util pentru stabilitatea testelor)
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll(" +
                            "'[class*=overlay],[class*=backdrop],[class*=modal],[class*=scrim],' +" +
                            "'dialog[open]'" +
                            ").forEach(e => e.remove());"
            );
        } catch (Exception ignored) {}
    }

}


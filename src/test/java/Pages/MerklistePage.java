package Pages;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class MerklistePage {
    @Getter
    private WebDriver driver;
    @Getter
    private WebDriverWait wait;

    // locators
    @FindBy(id = "STRUCTURED-LANE-MEINE-MERKLISTE-HEADLINE")
    private WebElement meineMerklisteBtn;

    @FindBy(css = "div[aria-label^='Meine Merkliste (']")
    private WebElement meineMerklisteCount;


    public MerklistePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void goToMerkliste() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1) scroll în jos ca să ajungi în zona lane-urilor (dă trigger la lazy load)
        js.executeScript("window.scrollBy(0, 900);");

        wait.until(ExpectedConditions.elementToBeClickable(meineMerklisteBtn)).click();
    }


    public int getMerklisteCountFromAria() {
        try {
            WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("div[aria-label^='Meine Merkliste (']")
            ));
            String aria = el.getAttribute("aria-label"); // ex: "Meine Merkliste (8)"
            String digits = aria.replaceAll("\\D+", "");
            return digits.isEmpty() ? 0 : Integer.parseInt(digits);
        } catch (TimeoutException e) {
            return 0;
        }


        }


    public void debugMerklisteCandidates() {
        By counter = By.cssSelector("div[aria-label^='Meine Merkliste']");
        var els = driver.findElements(counter);

        System.out.println("Candidates found: " + els.size());
        for (int i = 0; i < els.size(); i++) {
            WebElement e = els.get(i);
            try {
                System.out.println(
                        "[" + i + "] displayed=" + e.isDisplayed() +
                                " aria-label='" + e.getAttribute("aria-label") + "'" +
                                " text='" + e.getText() + "'"
                );
            } catch (StaleElementReferenceException ex) {
                System.out.println("[" + i + "] STALE");
            }
        }

    }

//    public int getResultsCount() {
//        try {
//            String text = wait.until(ExpectedConditions.visibilityOf(meineMerklisteCount)).getText();
//            System.out.println("VEZI AICI ISA"+ meineMerklisteCount.getText());
//            String digits = text.replaceAll("\\D+", "");
//            return digits.isEmpty() ? 0 : Integer.parseInt(digits);
//        } catch (TimeoutException e) {
//            return 0;
//
//        }
//
//    }
}

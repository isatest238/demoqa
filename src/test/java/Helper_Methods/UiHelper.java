package Helper_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

    public void closeAnyOpenDialogs() {
        // 1) încearcă click pe X dacă există (de ex. buton cu aria-label Close / Schließen)
        By closeBtn = By.xpath(
                "//*[self::button or self::a][@aria-label='Close' or @aria-label='Schließen' or @title='Close' or @title='Schließen']"
        );

        // închide în buclă cât timp există dialog open
        while (!driver.findElements(By.cssSelector("dialog[open]")).isEmpty()) {
            if (!driver.findElements(closeBtn).isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(closeBtn)).click();
            } else {
                // fallback: închide dialog cu JS
                ((JavascriptExecutor) driver).executeScript(
                        "document.querySelectorAll('dialog[open]').forEach(d => d.close && d.close());"
                );
            }
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("dialog[open]"), 0));
        }
    }
    }


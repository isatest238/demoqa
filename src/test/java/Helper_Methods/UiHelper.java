package Helper_Methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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


    }


package Helper_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalBarFlows {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PersonalBarFlows (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}

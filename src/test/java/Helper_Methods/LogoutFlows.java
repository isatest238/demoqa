package Helper_Methods;

import Pages.UserMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutFlows {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public void logout() {
        UserMenuComponent menu = new UserMenuComponent(driver, wait);
        menu.clickuserProfileBtn();
        menu.clickmenuLogoutBtn();
    }

    public LogoutFlows(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}

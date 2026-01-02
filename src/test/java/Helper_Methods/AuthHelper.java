package Helper_Methods;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

public class AuthHelper {
    public static void openWithBasicAuth(WebDriver driver, String user, String pass, String url) {
        ((HasAuthentication) driver).register(
                uri -> uri.getHost().contains("beta.magenta.tv"),
                UsernameAndPassword.of(user, pass));

        driver.get(url);
    }
}

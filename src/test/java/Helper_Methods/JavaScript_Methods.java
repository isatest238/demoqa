package Helper_Methods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript_Methods {
    WebDriver driver;
    JavascriptExecutor js ;

    public JavaScript_Methods(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;

    }
    public void scrollMethod (int i, int j){
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", i, j);
    }

    public void forceClick (WebElement element){
        js.executeScript("arguments[0].click();", element);
    }
}

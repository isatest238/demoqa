package Helper_Methods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Windows_Methods {
    WebDriver driver;

    public Windows_Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println("Switched to the new tab ");
    }

    public void closeTab(){
        driver.close();
    }

    public void switchToMain(){
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
        System.out.println("Switched back to main tab.");
    }

}

package Helper_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames_Methods {
    WebDriver driver;

    public Frames_Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }
    public void switchToTheMainePage(){
        driver.switchTo().defaultContent();;
    }


}

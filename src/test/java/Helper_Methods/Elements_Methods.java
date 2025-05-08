package Helper_Methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class Elements_Methods {
    WebDriver driver;
    Actions actions;

    public Elements_Methods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/pic_automation.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value) {
        for (int i = 0; i < elementsList.size(); i++) {
            if (elementsList.get(i).getText().equals(value)) {
                clickOnElement(elementsList.get(i));
                break;
            }
        }
    }

    public void fillWithActions (WebElement webElement, String value){
        actions.sendKeys(value).perform();
        waitForVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();
    }


    public void waitForVisibilityElement(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void fillMultipleValues (WebElement webElement, List<String> lista){
        for (String value: lista){
            webElement.sendKeys(value);
            waitForVisibilityElement(webElement);
            webElement.sendKeys(Keys.ENTER);
        }
    }


    public void clickMultipleValuesList (List<WebElement> webElements, List<String> lista){
        //parcurg lista de stringuri
        for (String value:lista){
            // parcurg lista de elemente
            for (WebElement webElement: webElements){
                // daca textul de pw web element este o valoare egala cu ce l din lista atunci dam click
                if (webElement.getText().equals(value)){
                    webElement.click();
                }
            }
        }
    }
}

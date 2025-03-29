package Beginner_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Elements_RadioButton {
    public WebDriver driver;

    @Test
    public void automationMethod3() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();
        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //dam click pe Elements
        WebElement elementsElement = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsElement.click();

        // click on Radio Button
        WebElement radioButtonElement = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButtonElement.click();

        // radio button selection
        WebElement yesElement = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        //yesElement.click();
        WebElement impressiveElement = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        js.executeScript("window.scrollBy(0,400)");
        //impressiveElement.click();
        String optionValue = "Impressive";
        if (yesElement.getText().equals(optionValue)) {
           yesElement.click();
        } else if (impressiveElement.getText().equals(optionValue)) {
            impressiveElement.click();
        }
    }

}


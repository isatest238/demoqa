package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Elements_Buttons {
    public WebDriver driver;
    @Test
    public void automationMethod4 (){
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

        //click on Buttons option
        WebElement buttonsElement = driver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonsElement.click();

        // Double click on "Double Click Me" button
        WebElement doubleClickMeElement = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeElement).perform();;
        js.executeScript("window.scrollBy(0,400)");

        //  Right click on "Right Click Me" button
        WebElement rightClickMeElement = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        rightClickMeElement.click();
        actions.contextClick(rightClickMeElement).perform();

        // Click on "Click Me" button
        WebElement clickMeElement = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeElement.click();


    }
}

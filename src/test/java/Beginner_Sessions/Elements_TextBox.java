package Beginner_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Elements_TextBox {
    public WebDriver driver;

    @Test
    public void automationMethod2() {
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

        //click on Text Box
        WebElement textBoxElement = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxElement.click();

        // enter value into Full Name field
        WebElement fullNameElement = driver.findElement(By.id("userName"));
        fullNameElement.sendKeys("Isabela Maria");

        // enter value into Email field
        WebElement emailElement = driver.findElement(By.id("userEmail"));
        emailElement.sendKeys("isatest238@gmail.com");

        // enter value into Current Address field
        WebElement currentAddressElement = driver.findElement(By.id("currentAddress"));
        currentAddressElement.sendKeys("Str. Detunata, nr. 5, ap. 12, Cluj Napoca");

        // enter value into Permanent Address field
        WebElement permanentAddressElement = driver.findElement(By.id("permanentAddress"));
        permanentAddressElement.sendKeys("Str. Soporului, nr. 8, ap. 67, Cluj Napoca");

        // Click on 'Submit' button
        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.click();
    }

}

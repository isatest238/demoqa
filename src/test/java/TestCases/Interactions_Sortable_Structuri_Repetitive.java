package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Structuri_Repetitive {
    public WebDriver driver;

    @Test
    public void automationMethod4() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();
        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        //Click on Interaction Element
        WebElement interactionElement = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        interactionElement.click();
        js.executeScript("window.scrollBy(0,400)");
        //Click on Sortable menu option
        WebElement sortableElement = driver.findElement(By.xpath("//span[text()='Sortable']"));
        sortableElement.click();

    }
}

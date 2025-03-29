package Beginner_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Interactions_Sortable_GridView_Structuri_Repetitive {
    public WebDriver driver;

    @Test
    public void automationMethod (){
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

        //Grid view - Lista de Elemente - listare - move element with drag and drop
        WebElement gridButtonElement = driver.findElement(By.id("demo-tab-grid"));
        gridButtonElement.click();

        Actions actions = new Actions(driver);
        List<WebElement> gridList = driver.findElements(By.xpath("//div[@class='create-grid']//div[@class='list-group-item list-group-item-action']"));
        for (int j = 0; j < gridList.size(); j++) {
            WebElement firstGridElement = gridList.get(j);
            WebElement nextGridElement = gridList.get(j+1);
           // System.out.println("Numarul elementului este " + firstGridElement.getText());
            actions.clickAndHold(firstGridElement).moveToElement(nextGridElement).release().build().perform();
        }
    }
}

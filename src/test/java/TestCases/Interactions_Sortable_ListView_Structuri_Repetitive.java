package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Interactions_Sortable_ListView_Structuri_Repetitive {
    public WebDriver driver;

    @Test
    public void automationMethod() {
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

        //Lista de Elemente - listare - move element with drag and drop
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        Actions actions = new Actions(driver);
        js.executeScript("window.scrollBy(0,400)");
        for (int i = 0; i <= list.size() - 1; i++) {
            WebElement firstElement = list.get(i);
            WebElement urmatorulElement = list.get(i + 1);
           // System.out.println("Numarul elementului este " + firstElement.getText());
            //actions.clickAndHold(firstElement).moveToElement(urmatorulElement).release().build().perform();
            actions.clickAndHold(firstElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

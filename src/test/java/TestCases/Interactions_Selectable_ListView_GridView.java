package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Interactions_Selectable_ListView_GridView {
    public WebDriver driver;
    @Test
    public void automationMethod(){
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

        //Click on 'Selectable' meniu option
        WebElement selectableElement = driver.findElement(By.xpath("//span[text()='Selectable']"));
        selectableElement.click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='verticalListContainer']//li[@class='mt-2 list-group-item list-group-item-action']"));
        js.executeScript("window.scrollBy(0,400)");
        for (int i=0; i< list.size(); i++){
            WebElement listElement = list.get(i);
            listElement.click();
            //System.out.println(listElement.getText());
        }

        // Click on Grid view option
        WebElement gridViewElement = driver.findElement(By.id("demo-tab-grid"));
        gridViewElement.click();

        List<WebElement> gridList = driver.findElements(By.xpath("//div[@class='grid-container mt-4']//li[@class='list-group-item list-group-item-action']"));
        js.executeScript("window.scrollBy(0,400)");
        for (int j=0; j<gridList.size(); j++){
            WebElement gridElement = gridList.get(j);
            gridElement.click();
            //System.out.println(gridElement.getText());
        }

    }
}

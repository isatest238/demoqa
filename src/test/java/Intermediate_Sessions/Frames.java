package Intermediate_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
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

        //declaram 'Alerts, Frame & Windows' element si dam click pe el
        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        AlertsFormElement.click();

        // declaram 'Frames' element si dam click pe el
        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        // definim primul frame si apoi facem switch ul catre el
        WebElement frame1Element = driver.findElement(By.id("frame1"));

       driver.switchTo().frame(frame1Element);

       WebElement sampleFrame1Element = driver.findElement(By.id("sampleHeading"));
       System.out.println("Textul din primul frame este: " + sampleFrame1Element.getText());

       //mutam focusul pe pagina principala
       driver.switchTo().defaultContent();

        js.executeScript("window.scrollBy(0,600)");
        // definim al doilea frame, dam scroll si apoi facem switch ul catre el
        WebElement frame2Element = driver.findElement(By.id("frame2"));

        driver.switchTo().frame(frame2Element);

        //facem scroll pe orizontal si vertical in cel de al doilea frame
        js.executeScript("window.scrollBy(200,200)");

    }
}

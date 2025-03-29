package Beginner_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class Elements_Upload_Download {
    public WebDriver driver;
    @Test
    public void automationMethod5(){
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

        // click on "Upload and Download" section
        WebElement updloadDownloadElement = driver.findElement(By.xpath("//span[text()='Upload and Download']"));
        js.executeScript("window.scrollBy(0,400)");
        updloadDownloadElement.click();

        // click on 'Choose File' button - upload file
        WebElement chooseFileElement = driver.findElement(By.id("uploadFile"));
        File file2 = new File("src/test/resources/file_upload_selenium_java.png");
        chooseFileElement.sendKeys(file2.getAbsolutePath());

        // Download file ????
        //WebElement downloadElement = driver.findElement(By.id("downloadButton)"));
        //String imageURL = downloadElement.getAttribute("href");
        //driver.get(imageURL);


    }
}

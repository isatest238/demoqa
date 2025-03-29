package Intermediate_Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Browser_Windows {
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

        // declaram 'Alerts' element si dam click pe el
        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        //declaram New Tab button si dam click pe el
        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();

        //mutam fosusul pe noul tab
        //salvam tab urile intr o lista si apoi schimbam focusul pe al doilea tab

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement samplePageElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new Tab este: " + samplePageElement.getText());
        //inchidem tabul nou deschis
        driver.close();

        //revenim la tabul initial
        driver.switchTo().window(tabList.get(0));
        //declaram New Window button si dam click pe el
        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement newWindowsElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new windows este :" + newWindowsElement.getText());
        driver.close();
        driver.switchTo().window(tabList.get(0));

    }
}

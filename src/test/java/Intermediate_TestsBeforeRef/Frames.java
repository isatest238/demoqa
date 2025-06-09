package Intermediate_TestsBeforeRef;

import Helper_Methods.Elements_Methods;
import Helper_Methods.Frames_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {
    public WebDriver driver;
    public JavaScript_Methods javaScriptMethods;
    public Elements_Methods elementsMethods;
    public Frames_Methods framesMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;

    @Test
    public void automationMethod3() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        javaScriptMethods = new JavaScript_Methods(driver);
        elementsMethods = new Elements_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        javaScriptMethods.scrollMethod(0, 400);
//
//        //declaram 'Alerts, Frame & Windows' element si dam click pe el
//        WebElement AlertsFormElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(AlertsFormElement);

        subMenuPage.goToDesiredSubMenuPage("Frames");


        // declaram 'Frames' element si dam click pe el
//        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementsMethods.clickOnElement(frameElement);

        // definim primul frame si apoi facem switch ul catre el
        WebElement frame1Element = driver.findElement(By.id("frame1"));
        framesMethods.switchToFrame(frame1Element);

        //driver.switchTo().frame(frame1Element);
        Thread.sleep(5000);
        WebElement sampleFrame1Element = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din primul frame este: " + sampleFrame1Element.getText());

        //mutam focusul pe pagina principala
        framesMethods.switchToTheMainePage();

        javaScriptMethods.scrollMethod(0, 600);
        Thread.sleep(5000);
        // definim al doilea frame, dam scroll si apoi facem switch ul catre el
        WebElement frame2Element = driver.findElement(By.id("frame2"));

        framesMethods.switchToFrame(frame2Element);

        //facem scroll pe orizontal si vertical in cel de al doilea frame
        javaScriptMethods.scrollMethod(200, 200);
        Thread.sleep(5000);

        //al doilea branch
    }
}

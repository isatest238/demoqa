package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable_Test_Ref {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Page subMenuPage;

    @Test
    public void automationMethod() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();

        elementsMethods = new Elements_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Page(driver);

        homePage.goToDesiredMenu("Elements");

        subMenuPage.goToDesiredSubMenuPage("Web Tables");

        // tabel - dimensiunea tabelului
        List<WebElement> tableElement = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer actualTableSize = tableElement.size();

        // declaram Add button element
        javaScriptMethods.scrollMethod(0,400);
        WebElement AddButtonField = driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickOnElement(AddButtonField);

        // declaram primul field FirtsName
        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(FirstNameField, "Isabela");

        // declaram LastName field
        WebElement LastNameField = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(LastNameField, "Vulpe");

        // declaram Email field
        WebElement EmailField = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(EmailField, "isabela.vulpe@endava.com");

        //declaram Age field
        WebElement AgeField = driver.findElement(By.id("age"));
        elementsMethods.fillElement(AgeField, "27");

        // declaram Salary field
        WebElement SalaryField = driver.findElement(By.id("salary"));
        elementsMethods.fillElement(SalaryField, "25000");

        // declaram Departament Field
        WebElement DepartamentField = driver.findElement(By.id("department"));
        elementsMethods.fillElement(DepartamentField, "Testing");

        // declaram Submit button field
        WebElement SubmitButtonField = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElement(SubmitButtonField);

        //verificare - o noua linie a fost adaugata in tabel comparand size ul tabelului
        List<WebElement> tableElement1 = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer expectedSizeTable = actualTableSize+1;
        Assert.assertEquals(tableElement1.size(),expectedSizeTable);

        //validarea elementelor adaugate in tabel in ultima linie
//        String actualTableValue = tableElement1.get(3).getText();
//        Assert.assertTrue(actualTableValue.contains(FirstNameValue));
//        Assert.assertTrue(actualTableValue.contains(LastNameValue));
//        Assert.assertTrue(actualTableValue.contains(EmailValue));
//        Assert.assertTrue(actualTableValue.contains(AgeValue));
//        Assert.assertTrue(actualTableValue.contains(SalaryValue));
    }

}
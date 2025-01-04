package TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.awt.SystemColor.window;

public class WebTable_Test {
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

        //declaram un element si dam click pe el
        WebElement ElementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ElementsField.click();

        //declaram al doilea element si dam click pe el
        WebElement Element2Field = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        Element2Field.click();

        // tabel - dimensiunea tabelului
        List<WebElement> tableElement = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer actualTableSize = tableElement.size();

        // declaram Add button element
        js.executeScript("window.scrollBy(0,400)");
        WebElement AddButtonField = driver.findElement(By.id("addNewRecordButton"));
        AddButtonField.click();

        // declaram primul field FirtsName
        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        String FirstNameValue = "Isabela";
        FirstNameField.sendKeys(FirstNameValue);

        // declaram LastName field
        WebElement LastNameField = driver.findElement(By.id("lastName"));
        String LastNameValue = "Vulpe";
        LastNameField.sendKeys(LastNameValue);

        // declaram Email field
        WebElement EmailField = driver.findElement(By.id("userEmail"));
        String EmailValue = "isabela.vulpe@endava.com";
        EmailField.sendKeys(EmailValue);

        //declaram Age field
        WebElement AgeField = driver.findElement(By.id("age"));
        String AgeValue = "27";
        AgeField.sendKeys(AgeValue);

        // declaram Salary field
        WebElement SalaryField = driver.findElement(By.id("salary"));
        String SalaryValue = "250000";
        SalaryField.sendKeys(SalaryValue);

        // declaram Departament Field
        WebElement DepartamentField = driver.findElement(By.id("department"));
        String DepartamentValue = "Testing";
        DepartamentField.sendKeys(DepartamentValue);

        // declaram Submit button field
        WebElement SubmitButtonField = driver.findElement(By.id("submit"));
        SubmitButtonField.click();

        //verificare - o noua linie a fost adaugata in tabel comparand size ul tabelului
        List<WebElement> tableElement1 = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer expectedSizeTable = actualTableSize+1;
        Assert.assertEquals(tableElement1.size(),expectedSizeTable);

        //validarea elementelor adaugate in tabel in ultima linie
        String actualTableValue = tableElement1.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(FirstNameValue));
        Assert.assertTrue(actualTableValue.contains(LastNameValue));
        Assert.assertTrue(actualTableValue.contains(EmailValue));
        Assert.assertTrue(actualTableValue.contains(AgeValue));
        Assert.assertTrue(actualTableValue.contains(SalaryValue));
    }

}
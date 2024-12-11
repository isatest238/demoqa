package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeForm_Test {
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

        //declaram 'Forms' element si dam click pe el
        WebElement FormElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        FormElement.click();

        // declaram 'Practice Form' element si dam click pe el
        WebElement PracticeFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        PracticeFormElement.click();

        // declaram FirstName field si introducem valoarea
        WebElement FirstNameElement = driver.findElement(By.id("firstName"));
        String FirstNameValue = "Isabela";
        FirstNameElement.sendKeys(FirstNameValue);

        //LastName
        WebElement LastNameElement = driver.findElement(By.id("lastName"));
        String LastNameValue = "Popescu";
        LastNameElement.sendKeys(LastNameValue);

        // EmailAddress
        WebElement EmailAddressElement = driver.findElement(By.id("userEmail"));
        String EmailAddresValue = "isabela.popescu@gmail.com";
        EmailAddressElement.sendKeys(EmailAddresValue);

        //PhoneNumber
        WebElement PhoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String PhoneNumberValue = "0746832902";
        PhoneNumberElement.sendKeys(PhoneNumberValue);

        // Picture - ''Choose File'' button - upload a picture
        WebElement PictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/pic_automation.png");
        PictureElement.sendKeys(file.getAbsolutePath());

        // gender selection
        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Other";
        if (genderValue.equals("Male")) {
            maleElement.click();
        } else if (genderValue.equals("Female")) {
            femaleElement.click();
        } else if (genderValue.equals("Other")){
            otherElement.click();
        }

    }
}

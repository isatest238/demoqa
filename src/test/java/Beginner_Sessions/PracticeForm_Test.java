package Beginner_Sessions;

import Helper_Methods.Elements_Methods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeForm_Test {
    public WebDriver driver;
    public Elements_Methods elementsMethods;

    @Test
    public void automationMethod1() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();
        elementsMethods = new Elements_Methods(driver);

        // facem un scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declaram 'Forms' element si dam click pe el
        WebElement FormElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementsMethods.clickOnElement(FormElement);


        // declaram 'Practice Form' element si dam click pe el
        WebElement PracticeFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethods.clickOnElement(PracticeFormElement);


        // declaram FirstName field si introducem valoarea
        WebElement FirstNameElement = driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(FirstNameElement, "Isabela");

        //LastName
        WebElement LastNameElement = driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(LastNameElement, "Popescu");

        // EmailAddress
        WebElement EmailAddressElement = driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(EmailAddressElement, "isabela.popescu@gmail.com");

       //PhoneNumber
       WebElement PhoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
       elementsMethods.fillElement(PhoneNumberElement, "0746832902");

        // Subjects input selection
       WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
       elementsMethods.fillElement(subjectsElement,"Social Studies");
       subjectsElement.sendKeys(Keys.ENTER);


       // Picture - ''Choose File'' button - upload a picture
       WebElement PictureElement = driver.findElement(By.id("uploadPicture"));
       elementsMethods.uploadPicture(PictureElement);


        // gender selection
        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        List<WebElement> genderListElement = new ArrayList<>();
        genderListElement.add(maleElement);
        genderListElement.add(femaleElement);
        genderListElement.add(otherElement);
        elementsMethods.selectElementFromListByText(genderListElement, "Female");

//        String genderValue = "Female";
//        if (maleElement.getText().equals(genderValue)) {
//            maleElement.click();
//        } else if (femaleElement.getText().equals(genderValue)) {
//            femaleElement.click();
//        } else if (otherElement.getText().equals(genderValue)) {
//            otherElement.click();
//        }


//        // state element
//        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
//        js.executeScript("window.scrollBy(0,400)");
//        js.executeScript("arguments[0].click();", stateElement);
//        stateElement.sendKeys("NCR");
//        stateElement.sendKeys(Keys.ENTER);
//        String stateElementValue = "NCR";
//
//        // Select City
//        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
//        js.executeScript("arguments[0].click();", cityElement);
//        cityElement.sendKeys("Noida");
//        cityElement.sendKeys(Keys.ENTER);
//        String cityElementValue = "Noida";
//
//        // Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElement(submitButton);
//
//
//        // Validare prima coloana
//        System.out.println("Verificam ca elementele din prima coloana sunt cele asteptate ");
//        // declaram prima lista - coloana 1 din tabel si lista cu expected values
//        List<WebElement> tabelElement = driver.findElements(By.xpath("//div[@class='table-responsive']/table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr/td"));
//        List<String> expectedPrimaColoanaElement = List.of("Student Name", "Student Email", "Gender", "Mobile", "Date of Birth", "Subjects", "Hobbies", "Picture", "Address", "State and City");
//
//        //declaram o lista care sa contina doar elementele din prima coloana
//        List<String> evenPositionElements = new ArrayList<>();
//
//        // Add elements at even positions (index 0-based)
//        for (int i = 0; i < tabelElement.size(); i += 2) {
//            evenPositionElements.add(tabelElement.get(i).getText().trim());
//        }
//        System.out.println("Elements at even positions: " + evenPositionElements);
//
//        // validate that the size of the lists is the same - evenPositionElements with expectedPrimaColoana
//        Assert.assertEquals(expectedPrimaColoanaElement.size(), evenPositionElements.size());
//
//        // validam elementele din prima coloana
//        for (int i = 0; i < evenPositionElements.size(); i++) {
//            String evenPositionElementsValoare = evenPositionElements.get(i).trim();
//            String expectedPrimaColoanaValoare = expectedPrimaColoanaElement.get(i).trim();
//            System.out.println("Comparing: Actual [" + evenPositionElementsValoare + "] vs Expected [" + expectedPrimaColoanaValoare + "]"); // Debugging
//            Assert.assertTrue(evenPositionElementsValoare.equals(expectedPrimaColoanaValoare));
//        }
//
//        // Validare a doua coloana
//        // declaram o lista care sa contina doar elementele din a doua coloana
//        System.out.println("Validare a doua coloana");
//
//        List<String> secondColumnElements = new ArrayList<>();
//        for (int i = 1; i < tabelElement.size(); i += 2) {
//            secondColumnElements.add(tabelElement.get(i).getText().trim());
//        }
//        System.out.println("Elements inserted by the user when completing the form:" + secondColumnElements);
//
//        String nameValue = FirstNameValue+' '+LastNameValue;
//        String stateAndCity = stateElementValue+ ' ' + cityElementValue;
//        String pictureValue = "pic_automation.png";
//        String dateOfBirthValue = "04 January,2025";
//
//        //System.out.println("Name: " + nameValue);
//        //System.out.println("State and City " + stateAndCity);
//        //List<String> expectedSecondColoamnElement = List.of(nameValue, EmailAddresValue, genderValue, PhoneNumberValue,subjectsValue, stateAndCity );
//
//        //validam elemenetele din a doua coloana
//        Assert.assertTrue(secondColumnElements.contains(nameValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(EmailAddresValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(PhoneNumberValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(genderValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(subjectsValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(stateAndCity.trim()));
//        Assert.assertTrue(secondColumnElements.contains(pictureValue.trim()));
//        Assert.assertTrue(secondColumnElements.contains(dateOfBirthValue.trim()));
//
//
//    }

    }
}



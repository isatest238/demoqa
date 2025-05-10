package Beginner_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm_Test {
    public WebDriver driver;
    public Elements_Methods elementsMethods;
    public JavaScript_Methods javaScriptMethods;
    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;



    @Test
    public void automationMethod1() {
        //deschidem un Chrome browser
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        // facem browserul in modul maximized
        driver.manage().window().maximize();

        elementsMethods = new Elements_Methods(driver);
        javaScriptMethods = new JavaScript_Methods(driver);
        homePage = new Home_Page(driver);
        subMenuPage = new SubMenu_Common_Page(driver);



        // facem un scroll
        //javaScriptMethods.scrollMethod(0,400);

        //inlocuieste linia 52 - 53
//        List <WebElement> elementField = driver.findElements(By.xpath("//h5"));
//        javaScriptMethods.scrollMethod(0,400);
//        elementsMethods.selectElementFromListByText(elementField, "Forms");


        //declaram 'Forms' element si dam click pe el
//        WebElement FormElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        elementsMethods.clickOnElement(FormElement);

        homePage.goToDesiredMenu("Forms");


        //inlocuieste linia 59 - 60
//        List <WebElement> elementField2 = driver.findElements(By.xpath("//span[@class='text']"));
//        elementsMethods.selectElementFromListByText(elementField2, "Practice Form");


        // declaram 'Practice Form' element si dam click pe el
//        WebElement PracticeFormElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
//        elementsMethods.clickOnElement(PracticeFormElement);

        subMenuPage.goToDesiredSubMenuPage("Practice Form");

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


        // state element
       WebElement stateElement = driver.findElement(By.id("react-select-3-input"));

       javaScriptMethods.scrollMethod(0, 400);
       elementsMethods.fillElement(stateElement, "NCR");
       stateElement.sendKeys(Keys.ENTER);


       // Select City
       WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
       javaScriptMethods.forceClick(cityElement);
       elementsMethods.fillElement(cityElement, "Noida");
       cityElement.sendKeys(Keys.ENTER);


       // Submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        elementsMethods.clickOnElement(submitButton);



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



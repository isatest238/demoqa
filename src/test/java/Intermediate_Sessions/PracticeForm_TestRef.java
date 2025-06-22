package Intermediate_Sessions;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import ObjectData.PracticeForm_Object;
import Pages.Home_Page;
import Pages.PracticeForm_Page;
import Pages.SubMenu_Common_Page;
import PropertyUtility.Property_Utility;
import Shared_Data.Hooks;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm_TestRef extends Hooks {

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    PracticeForm_Page practiceFormPage;


    @Test
    public void automationMethod1() {

       Property_Utility propertyUtility = new Property_Utility("PracticeForm_TestRef");
       PracticeForm_Object practiceFormObject = new PracticeForm_Object(propertyUtility.getAllData());


        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());
        practiceFormPage = new PracticeForm_Page(getDriver());


        homePage.goToDesiredMenu("Forms");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Forms menu");

        subMenuPage.goToDesiredSubMenuPage("Practice Form");
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters on Practice Form submenu");




        practiceFormPage.completeFirstPart(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user complete the first part of the Practice Form ");
        practiceFormPage.uploadPicture();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user upload picture");

        practiceFormPage.completeGender(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters gender");
        //practiceFormPage.completeSubject("Maths");

//        List<String> subject = new ArrayList<>();
//        subject.add("Maths");
//        subject.add("English");
        practiceFormPage.completeSubjectWithList(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user complete subject field");


       // javaScriptMethods.scrollMethod(0, 400);
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Sports");
//        hobbies.add("Music");
//        hobbies.add("Reading");
        practiceFormPage.completeHobbies(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters hobbies");



        practiceFormPage.completeStateElement(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters State");


        practiceFormPage.completeCityElement(practiceFormObject);
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user enters City");


        practiceFormPage.clickOnButton();
        Extent_Utility.attachLog(Report_Step.PASS_STEP,"The user click on submit button");


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



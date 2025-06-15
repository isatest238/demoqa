package Intermediate_Sessions;

import Helper_Methods.Elements_Methods;
import Helper_Methods.JavaScript_Methods;
import Pages.Home_Page;
import Pages.SubMenu_Common_Page;
import Pages.WebTable_Page;
import Shared_Data.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable_Test_Ref extends Hooks {

    Home_Page homePage;
    SubMenu_Common_Page subMenuPage;
    WebTable_Page webTablePage;

    @Test
    public void automationMethod() {


        homePage = new Home_Page(getDriver());
        subMenuPage = new SubMenu_Common_Page(getDriver());
        webTablePage = new WebTable_Page(getDriver());

        homePage.goToDesiredMenu("Elements");

        subMenuPage.goToDesiredSubMenuPage("Web Tables");
        webTablePage.clickOnAddButton();

        // tabel - dimensiunea tabelului
        List<WebElement> tableElement = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer actualTableSize = tableElement.size();

        webTablePage.fillRegistationForm("Isabela", "Vulpe", "isatest@gmail.com", "25", "25000", "Testing");
        webTablePage.clickOnSubmit();


        //verificare - o noua linie a fost adaugata in tabel comparand size ul tabelului
        List<WebElement> tableElement1 = getDriver().findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Integer expectedSizeTable = actualTableSize + 1;
        Assert.assertEquals(tableElement1.size(), expectedSizeTable);

        //validarea elementelor adaugate in tabel in ultima linie
//        String actualTableValue = tableElement1.get(3).getText();
//        Assert.assertTrue(actualTableValue.contains(FirstNameValue));
//        Assert.assertTrue(actualTableValue.contains(LastNameValue));
//        Assert.assertTrue(actualTableValue.contains(EmailValue));
//        Assert.assertTrue(actualTableValue.contains(AgeValue));
//        Assert.assertTrue(actualTableValue.contains(SalaryValue));
    }
}
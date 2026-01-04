package Shared_Data;

import ExtentUtility.Extent_Utility;
import Logger.Logger_Utility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks extends Shared_Data {

    public String testName;

    @BeforeSuite
    public void initiateTestReport() {
        Extent_Utility.initiateReport();
    }

    @BeforeMethod
    public void prepareEnvironment() {
        testName = this.getClass().getSimpleName();
        Logger_Utility.startTestCase(testName);
        Extent_Utility.createTest(testName);
        prepareBrowser();
    }


    @AfterMethod
    public void clearEnvironment(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                String errorMessage = result.getThrowable() != null
                        ? result.getThrowable().getMessage()
                        : "Test failed (no throwable message)";
                Logger_Utility.errorLog(errorMessage);
                Extent_Utility.attachLog(testName, errorMessage, getDriver());
            }
        } finally {
            clearBrowser();
            Logger_Utility.endTestCase(testName);
            Extent_Utility.finishTest(testName);
        }
    }

    @AfterSuite
    public void finalizedLogFiles() {

        Logger_Utility.mergeLogFileInToOne();
        Extent_Utility.generateReport();
    }
}

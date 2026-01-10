package Shared_Data;

import ExtentUtility.Extent_Utility;
import Logger.Logger_Utility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Hooks extends Shared_Data {

    public String testName;

    @BeforeSuite
    public void initiateTestReport() {
        Extent_Utility.initiateReport();
    }

    @BeforeMethod
    //public void prepareEnvironment() {
    public void prepareEnvironment(Method method, Object[] testData) {
        String className = this.getClass().getSimpleName();
        String methodName = method.getName();

        String params = (testData != null && testData.length > 0)
                ? Arrays.toString(testData)
                : "";

        testName = className + "." + methodName + (params.isEmpty() ? "" : " " + params);

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

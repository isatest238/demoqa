package Shared_Data;

import Logger.Logger_Utility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class Hooks extends Shared_Data{

    public String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        Logger_Utility.startTestCase(testName);
        prepareBrowser();
    }


    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            Logger_Utility.errorLog(result.getThrowable().getMessage());
        }
        clearBrowser();
        //pentru moment toate sunt bune
        Logger_Utility.endTestCase(testName);
    }

    @AfterSuite
    public void finalizedLogFiles(){
        Logger_Utility.mergeLogFileInToOne();
    }
}

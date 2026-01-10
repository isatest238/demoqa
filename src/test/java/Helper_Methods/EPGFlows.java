package Helper_Methods;

import ExtentUtility.Extent_Utility;
import ExtentUtility.Report_Step;
import Logger.Logger_Utility;
import Pages.EPG_Page;
import Pages.HomePage;
import Pages.components.EpgMiniDetailPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EPGFlows {

    private final HomePage homePage;
    private final EPG_Page epg;
    private final EpgMiniDetailPanel mini;

    public EPGFlows(WebDriver driver, WebDriverWait wait) {
        this.homePage = new HomePage(driver, wait);
        this.epg  = new EPG_Page(driver, wait);
        this.mini = new EpgMiniDetailPanel(driver, wait);
    }

    public void openEpgFromHome() {
        Logger_Utility.infoLog("Open EPG from Home");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Open EPG from Home");

        homePage.clickEpgIcon();

        Logger_Utility.infoLog("EPG opened");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "EPG opened");
    }

    public void openDasErsteOngoingMiniDetail() {
        Logger_Utility.infoLog("Open Das Erste mini detail (ongoing program)");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Open Das Erste mini detail (ongoing program)");

        epg.clickProgramFromDasErsteBestEffort();

        Logger_Utility.infoLog("Mini detail opened");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Mini detail opened");
    }

    public void startInstantRestartFromMiniDetail() {
        Logger_Utility.infoLog("Click 'Neu starten' (Instant Restart) in mini detail");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Click 'Neu starten' (Instant Restart) in mini detail");

        mini.clickInstantRestart();
    }

    public void startLiveTvFromMiniDetail() {
        Logger_Utility.infoLog("Click 'Zum Live-TV' in mini detail");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Click 'Zum Live-TV' in mini detail");

        mini.clickZumLiveTv();
    }

    public void openEpgAndStartIRFromDasErste() {
        Logger_Utility.infoLog("Scenario: Open EPG and start Instant Restart from Das Erste");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Scenario: Open EPG and start Instant Restart from Das Erste");

        openEpgFromHome();
        openDasErsteOngoingMiniDetail();
        startInstantRestartFromMiniDetail();
    }

    public void openEpgAndStartLiveTVFromDasErste() {
        Logger_Utility.infoLog("Scenario: Open EPG and start Live TV from Das Erste");
        Extent_Utility.attachLog(Report_Step.INFO_STEP, "Scenario: Open EPG and start Live TV from Das Erste");

        openEpgFromHome();
        openDasErsteOngoingMiniDetail();
        startLiveTvFromMiniDetail();
    }
}

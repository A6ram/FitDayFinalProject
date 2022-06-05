package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ActivityLogTest extends BaseTest {

    @Test
    public void createdWalkingActivity() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addActivityButton();
        activityPage.createDataInActivityLog("Walking", "1", "1000", "yards");
        activityPage.addToActivityLog();
        activityPage.validateResultWalking("backpacking");
        activityPage.deleteFromActivityLog();


    }

    @Test
    public void createdBicyclingActivity() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addActivityButton();
        activityPage.createDataInActivityLog("Bicycling", "2", "50", "kms");
        activityPage.addToActivityLog();
        activityPage.validateResultBicycling("BMX or mountain biking");
        activityPage.deleteFromActivityLog();


    }


}

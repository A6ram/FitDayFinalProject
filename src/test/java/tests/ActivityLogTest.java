package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ActivityLogTest extends BaseTest{


    @Test(description = "Try to add some foodname to food table")
    public void foodButtonTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addActivityButton();
        activityPage.checkResultInActivityLog();
    }
    @Test
    public void browseActivity(){
        loginPage.openPage();
        loginPage.login(user,password);
        dashBoardPage.addActivityButton();
        activityPage.chooseTheVariantFromDropdownActivity();
        activityPage.checkResultInActivityLog();
    }
    @Test
    public void createActivity(){
        loginPage.openPage();
        loginPage.login(user,password);
        dashBoardPage.addActivityButton();
        activityPage.chooseTheVariantFromDropdownActivity();
        activityPage.checkResultOfActivity();

    }
    @Test
    public void addingAndRemovingFromTheActivityLogTest(){
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addActivityButton();
        activityPage.addActivityBySearch("boxing");
        activityPage.checkResultOfActivity();
        activityPage.inputSpaceTimeOfActivity("1");
        activityPage.addValueToFoodLog();
        activityPage.addToActivityLog();
        activityPage.searchActivityBottom();
        activityPage.addActionsButton();
        activityPage.addDeleteButton();
        activityPage.resultOfActivity();

    }


}

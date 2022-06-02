package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;


@Log4j2
public class DashBoardTest extends BaseTest {

    @Test(description = "Try to add some foodname to food table")
    public void foodButtonTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.checkResultInFoodLog();
    }

    @Test(description = "Try to search some kind of foodname")
    public void foodSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        dashBoardPage.checkSearchResult();
    }

    @Test(description = "Try to create some custom food")
    public void foodCustomSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.createCustomFoodItem();
        dashBoardPage.enterCustomFoodName("dranik");
        dashBoardPage.addSaveButton();
        dashBoardPage.addEditButton();
        dashBoardPage.addDeleteCustomFoodButton();
        dashBoardPage.setSearchResultOfCustomFood();
    }

    @Test(description = "Try to change value of amount")
    public void changingTheValueOfFoodAmountTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        dashBoardPage.checkSearchResult();
        foodPage.clearTheAmountOfFood();
        foodPage.addAmountOfFood("3");
        foodPage.addValueToFoodLog();
        dashBoardPage.checkResultOfFood();
    }

    @Test(description = "Try to change value of unit")
    public void changingTheValueOfFoodUnitTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        dashBoardPage.checkSearchResult();
        foodPage.chooseTheVariantFromDropdownKindOfFood();
        foodPage.addValueToFoodLog();
        dashBoardPage.checkResultOfFood();
    }

    @Test(description = "Try to adding and removing from the Food log")
    public void addingAndRemovingFromTheFoodLogTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        dashBoardPage.checkSearchResult();
        foodPage.addActionsButton();
        foodPage.addDeleteButton();
        dashBoardPage.checkResultOfFood();

    }

}

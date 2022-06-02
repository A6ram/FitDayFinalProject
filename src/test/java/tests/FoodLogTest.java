package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;


@Log4j2
public class FoodLogTest extends BaseTest {

    @Test(description = "Try to add some foodname to food table")
    public void foodButtonTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.checkResultInFoodLog();
    }

    @Test(description = "Try to search some kind of foodname")
    public void foodSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        foodPage.checkSearchResult();
    }

    @Test(description = "Try to create some custom food")
    public void foodCustomSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.createCustomFoodItem();
        foodPage.enterCustomFoodName("drak");
        foodPage.addSaveButton();
        foodPage.addEditButton();
        foodPage.addDeleteCustomFoodButton();
        foodPage.checkSearchResultOfCustomFood();
    }

    @Test(description = "Try to change value of amount")
    public void changingTheValueOfFoodAmountTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        foodPage.checkSearchResult();
        foodPage.clearTheAmountOfFood();
        foodPage.addAmountOfFood("3");
        foodPage.addValueToFoodLog();
        foodPage.checkResultOfFood();
    }

    @Test(description = "Try to change value of unit")
    public void changingTheValueOfFoodUnitTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        foodPage.checkSearchResult();
        foodPage.chooseTheVariantFromDropdownKindOfFood();
        foodPage.addValueToFoodLog();
        foodPage.checkResultOfFood();
    }

    @Test(description = "Try to adding and removing from the Food log")
    public void addingAndRemovingFromTheFoodLogTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese");
        foodPage.checkSearchResult();
        foodPage.addActionsButton();
        foodPage.addDeleteButton();
        foodPage.checkResultOfFood();

    }

}

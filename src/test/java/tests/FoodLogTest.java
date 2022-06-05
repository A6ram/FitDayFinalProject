package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;


@Log4j2
public class FoodLogTest extends BaseTest {

    @Test(description = "Trying to create custom food and then delete it")
    public void creatingCustomFoodAndDelete() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.createCustomFoodItem("Cukar", "200", "grams", "100");
        foodPage.validateResultAfterAddingCustom("100");
        foodPage.deleteFromFoodLog();
        foodPage.validateResultAfterDeleteCustom("—");

    }

    @Test(description = "Trying to add to the food log and then delete")
    public void addedAndDeletedFromTheFoodLog() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodBySearch("cheese", "3", "kg");
        foodPage.addToFoodLog();
        foodPage.validateResultAfterAdding("10167");
        foodPage.deleteFromFoodLog();
        foodPage.validateResultAfterDelete("—");

    }

    @Test(description = "Trying to add to the food log by browse and then delete")
    public void addFoodByBrowse() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodByBrowse();
        foodPage.chooseTypeOfFood("Fish");
        foodPage.chooseTypeOf("FinFish");
        foodPage.chooseKindOf("Barracuda");
        foodPage.choosePortion("400", "grams");
        foodPage.addToFoodLog();
        foodPage.validateResultAfterAddingByBrowse("844");
        foodPage.deleteFromFoodLog();
        foodPage.validateResultAfterDeleteByBrowse("—");

    }

}

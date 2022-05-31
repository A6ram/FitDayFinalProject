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
        dashBoardPage.setResultOfFoodLog();
    }

    @Test(description = "Try to search some kind of foodname")
    public void foodSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.setEnterTypeOfFood();
        dashBoardPage.setSearchResult();
    }

    @Test(description = "Try to search some custom foodname")
    public void foodCustomSearchTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.createCustomFoodItem();
        dashBoardPage.setInputNewCustomFood();
        dashBoardPage.setSearchResultOfCustomFood();
    }

    @Test(description = "Try to change value of amount + unit")
    public void changingTheValueOfFoodAmountTest() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.setEnterTypeOfFood();
        dashBoardPage.chooseTheVariantFromDropdownKindOfFood();
        dashBoardPage.cleanInputSpaceFoodAmount();
        dashBoardPage.setEnterTypeOfFoodAmount();
        dashBoardPage.chooseFoodInVariantFromDropdown();
        dashBoardPage.addValueToFoodLog();
        dashBoardPage.setResultOfFood();
    }

}

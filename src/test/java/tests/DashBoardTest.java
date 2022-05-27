package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static pages.DashBoardPage.*;

@Log4j2
public class DashBoardTest extends BaseTest {

    @Test(description = "Try to add some foodname to food table")
    public void foodButtonTest() {
        log.info("Open page fitday.com");
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        log.info("Comparison of expected and actual");
        $(VISIBILITY_NAME_OF_LOG).shouldBe(visible);
    }

    @Test(description = "Try to search some kind of foodname")
    public void foodSearchTest() {
        log.info("Open page fitday.com");
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        log.info("Enter the type of food");
        $(ENTER_TYPE_OF_FOOD).sendKeys("cheese");
        log.info("Comparison of expected and actual");
        $(SEARCH_RESULT).shouldBe(visible);
    }

    @Test(description = "Try to search some custom foodname")
    public void foodCustomSearchTest() {
        log.info("Open page fitday.com");
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        dashBoardPage.createCustomFoodItem();
        log.info("Input new custom food");
        $(INPUT_NEW_CUSTOM_FOOD).sendKeys("dranik");
        log.info("Comparison of expected and actual");
        $(SEARCH_RESULT_OF_CUSTOM_FOOD).shouldNotBe(visible);
    }

    @Test(description = "Try to change value of amount + unit")
    public void changingTheValueOfFoodAmountTest() {
        log.info("Open page fitday.com");
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        log.info("Input value of food");
        $(ENTER_TYPE_OF_FOOD).sendKeys("meat");
        dashBoardPage.chooseTheVariantFromDropdownKindOfFood();
        dashBoardPage.cleanInputSpaceFoodAmount();
        log.info("Input value of food amount");
        $(ENTER_TYPE_OF_FOOT_AMOUNT).sendKeys("3");
        dashBoardPage.chooseFoodInVariantFromDropdown();
        dashBoardPage.addValueToFoodLog();
        log.info("Comparison of expected and actual");
        $(RESULT_OF_FOOD_LOG).shouldNotBe(value("0"));
    }

}

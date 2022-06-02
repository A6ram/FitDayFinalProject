package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class FoodPage extends BasePage {
    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement ENTER_TYPE_OF_FOOD = $("[value='What did you eat today?']");
    public static final SelenideElement CLEAN_FOOD_AMOUNT = $("[value='What did you eat today?']");
    public static final SelenideElement FOOD_AMOUNT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
    public static final SelenideElement ENTER_DROPDOWN_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[3]/select"));
    public static final SelenideElement ADD_VALUE_TO_FOOD_LOG = $("a[class='add icon']");
    public static final SelenideElement ACTIONS_BUTTON = $(".edit.icon");
    public static final SelenideElement DELETE_BUTTON = $(".button-icon.delete");

    @Override
    public FoodPage isPageOpened() {
        $(PROFILE_LINK).shouldBe(Condition.visible);
        return this;

    }

    @Step("Enter type of food")
    public void addFoodBySearch(String type) {
        log.info("Enter type of food");
        $(ENTER_TYPE_OF_FOOD).sendKeys(type);
    }

    @Step("Clean input space of food amount")
    public void clearTheAmountOfFood() {
        log.info("Clean input space of food amount");
        $(FOOD_AMOUNT).sendKeys(Keys.CONTROL + "a");
        $(FOOD_AMOUNT).sendKeys(Keys.BACK_SPACE);
        ;
    }


    @Step("Enter type of food amount")
    public void addAmountOfFood(String type) {
        log.info("Enter type of food amount");
        $(FOOD_AMOUNT).sendKeys(type);
    }

    @Step("Choose the variant from dropdown kind of food")
    public void chooseTheVariantFromDropdownKindOfFood() {
        log.info("Choose the variant from dropdown kind of food");
        $(ENTER_DROPDOWN_FOOD_VALUE).sendKeys(Keys.ARROW_DOWN);
        $(ENTER_DROPDOWN_FOOD_VALUE).pressEnter();
    }

    @Step("Add value to food log")
    public void addValueToFoodLog() {
        log.info("Add value to food log");
        $(ADD_VALUE_TO_FOOD_LOG).click();
    }

    @Step
    public void addActionsButton() {
        $(ACTIONS_BUTTON).click();
    }

    @Step
    public void addDeleteButton() {
        $(DELETE_BUTTON).click();
    }

}

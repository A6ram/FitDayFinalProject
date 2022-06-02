package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


@Log4j2
public class FoodPage extends BasePage {
    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement ENTER_TYPE_OF_FOOD = $("[value='What did you eat today?']");
    public static final SelenideElement FOOD_AMOUNT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
    public static final SelenideElement ENTER_DROPDOWN_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[3]/select"));
    public static final SelenideElement ADD_VALUE_TO_FOOD_LOG = $("a[class='add icon']");
    public static final SelenideElement ACTIONS_BUTTON = $(".edit.icon");
    public static final SelenideElement DELETE_BUTTON = $(".button-icon.delete");
    public static final SelenideElement RESULT_OF_FOOD_LOG = $("div[id='food-log'] tfoot td:nth-child(1)");
    public static final SelenideElement SEARCH_RESULT = $(By.xpath("(//div[@class='fd-search-results'])[1]"));
    public static final SelenideElement CREATE_CUSTOM_FOOD = $("div[id='food-new-custom'] a");
    public static final SelenideElement ADD_SAVE_BUTTON = $(".save.button");
    public static final SelenideElement ADD_EDIT_BUTTON = $(".edit.button");
    public static final SelenideElement DELETE_CUSTOM_FOOD = $(".delete.button.grey");
    public static final SelenideElement CUSTOM_FOOD_NAME = $("input[name='name']");
    public static final SelenideElement VISIBILITY_NAME_OF_LOG = $("#main");
    public static final SelenideElement SEARCH_RESULT_OF_CUSTOM_FOOD = $("#food-search-custom");

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

    @Step("Add actions button")
    public void addActionsButton() {
        $(ACTIONS_BUTTON).click();
    }

    @Step("Add delete button")
    public void addDeleteButton() {
        $(DELETE_BUTTON).click();
    }

    @Step("Add save button")
    public void addSaveButton() {
        log.info("Add save button");
        $(ADD_SAVE_BUTTON).click();
    }

    @Step("Add adit button")
    public void addEditButton() {
        log.info("Add edit button");
        $(ADD_EDIT_BUTTON).click();
    }

    @Step("Add delete custom food button")
    public void addDeleteCustomFoodButton() {
        log.info("Add delete custom food button");
        $(DELETE_CUSTOM_FOOD).click();
    }


    @Step("Enter custom food name")
    public void enterCustomFoodName(String type) {
        log.info("Enter custom food name");
        $(CUSTOM_FOOD_NAME).sendKeys(type);
    }


    @Step("Create custom food item")
    public void createCustomFoodItem() {
        log.info("Create custom food item");
        $(CREATE_CUSTOM_FOOD).click();
    }


    @Step("Results food button test")
    public void checkResultInFoodLog() {
        log.info("results food button test");
        $(VISIBILITY_NAME_OF_LOG).shouldBe(visible);
    }

    @Step("Result food search test")
    public void checkSearchResult() {
        log.info("Result food search test");
        $(SEARCH_RESULT).shouldBe(visible);
    }

    @Step("Result search of custom food")
    public void checkSearchResultOfCustomFood() {
        log.info("Result search of custom food");
        $(SEARCH_RESULT_OF_CUSTOM_FOOD).shouldNotBe(visible);
    }

    @Step("Search result of food log")
    public void checkResultOfFood() {
        log.info("Search result of food log");
        $(RESULT_OF_FOOD_LOG).shouldNotBe(value("0"));
    }

}

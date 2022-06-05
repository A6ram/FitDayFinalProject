package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;


@Log4j2
public class FoodPage extends BasePage {
    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement ENTER_TYPE_OF_FOOD = $("[value='What did you eat today?']");
    public static final SelenideElement FOOD_AMOUNT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
    public static final SelenideElement ENTER_DROPDOWN_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[3]/select"));
    public static final SelenideElement ADD_VALUE_TO_FOOD_LOG = $("a[class='add icon']");
    public static final SelenideElement ACTIONS_BUTTON = $(".edit.icon");
    public static final SelenideElement DELETE_BUTTON = $(".button-icon.delete");
    public static final SelenideElement RESULT_OF_FOOD_LOG = $(By.xpath("//td[@class='name']"));
    public static final SelenideElement CREATE_CUSTOM_FOOD = $("div[id='food-new-custom'] a");
    public static final SelenideElement ADD_SAVE_BUTTON = $(".save.button");
    public static final SelenideElement CUSTOM_FOOD_NAME = $("input[name='name']");
    public static final SelenideElement CUSTOM_FOOD_VALUE = $("input[value='1']");
    public static final SelenideElement CUSTOM_FOOD_UNIT = $("select[name='unit']");
    public static final SelenideElement CUSTOM_FOOD_CALORIES = $("input[name='Calories']");
    public static final SelenideElement ADD_TO_FOOD_LOG_BUTTON_IN_CUSTOM = $("div[id='food-add-dialog'] span:nth-child(1)");
    public static final SelenideElement BROWSE_BUTTON = $(".browse-link");
    public static final SelenideElement TYPE_OF_FOOD = $(By.xpath("(//td[contains(@class,'name')])[8]"));
    public static final SelenideElement TYPE_OF_FISH = $(By.xpath("(//*[contains(@class,'name')])[8]"));
    public static final SelenideElement KIND_OF_FINFISH = $(By.xpath("(//td[contains(@class,'name')])[2]"));


    @Override
    public FoodPage isPageOpened() {
        $(PROFILE_LINK).shouldBe(Condition.visible);
        return this;

    }
    @Step
    public void chooseKindOf(String kindOf){
        $(KIND_OF_FINFISH).click();
    }

    @Step
    public void addFoodByBrowse(){
        $(BROWSE_BUTTON).click();
    }
    @Step
    public void chooseTypeOfFood(String type){
        $(TYPE_OF_FOOD).click();
    }
    @Step
    public void chooseTypeOf(String type){
        $(TYPE_OF_FISH).click();
    }
    @Step
    public void choosePortion(String amount,String value){
        $(FOOD_AMOUNT).sendKeys(Keys.CONTROL + "a");
        $(FOOD_AMOUNT).sendKeys(Keys.BACK_SPACE);
        $(FOOD_AMOUNT).sendKeys(amount);
        $(ENTER_DROPDOWN_FOOD_VALUE).sendKeys(value);
    }

    @Step
    public void addFoodBySearch(String type, String amount, String value) {
        log.info("Selecting amount of food");
        $(ENTER_TYPE_OF_FOOD).sendKeys(type);
        $(FOOD_AMOUNT).sendKeys(Keys.CONTROL + "a");
        $(FOOD_AMOUNT).sendKeys(Keys.BACK_SPACE);
        $(FOOD_AMOUNT).sendKeys(amount);
        $(ENTER_DROPDOWN_FOOD_VALUE).sendKeys(value);
    }

    @Step
    public void addToFoodLog() {
        log.info("Add value to food log");
        $(ADD_VALUE_TO_FOOD_LOG).click();
    }

    @Step("Add delete button")
    public void deleteFromFoodLog() {
        $(ACTIONS_BUTTON).click();
        $(DELETE_BUTTON).click();
    }

    @Step("Create custom food item")
    public void createCustomFoodItem(String FoodName, String value, String unit, String calories) {
        log.info("Create custom food item");
        $(CREATE_CUSTOM_FOOD).click();
        $(CUSTOM_FOOD_NAME).sendKeys(FoodName);
        $(CUSTOM_FOOD_VALUE).sendKeys(Keys.CONTROL + "a");
        $(CUSTOM_FOOD_VALUE).sendKeys(Keys.BACK_SPACE);
        $(CUSTOM_FOOD_VALUE).sendKeys(value);
        $(CUSTOM_FOOD_UNIT).sendKeys(unit);
        $(CUSTOM_FOOD_CALORIES).sendKeys(calories);
        $(ADD_SAVE_BUTTON).click();
        $(ADD_TO_FOOD_LOG_BUTTON_IN_CUSTOM).click();

    }

    @Step
    public void validateResultAfterAdding(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult, "10167");
    }

    @Step
    public void validateResultAfterDelete(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult, "—");
    }

    @Step
    public void validateResultAfterAddingCustom(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult, "100");
    }

    @Step
    public void validateResultAfterDeleteCustom(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult, "—");
    }
    @Step
    public void validateResultAfterAddingByBrowse(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult,"844");
    }
    @Step
    public void validateResultAfterDeleteByBrowse(String searchResult) {
        log.info("Validation result Food Log");
        $(RESULT_OF_FOOD_LOG).getText();
        assertEquals(searchResult, "—");
    }

}

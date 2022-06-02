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
public class DashBoardPage extends BasePage {

    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement CREATE_CUSTOM_FOOD = $(By.xpath("//*[@id=\"food-search-tabs\"]/ul/li[3]/a"));
    public static final SelenideElement ADD_FOOD_BUTTON = $(By.xpath("(//span[contains(.,'Add »')])[1]"));
    // public static final SelenideElement DROPDOWN_VARIANT_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[3]/select"));
    public static final SelenideElement ENTER_DROPDOWN_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[3]/select"));
    public static final SelenideElement CLEAN_FOOD = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
    public static final SelenideElement BACK_SPACE_FOOD_AMOUNT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
    public static final SelenideElement ENTER_TYPE_OF_FOOD_AMOUNT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[2]/input"));
   // public static final SelenideElement CHOOSE_DROPDOWN_VARIANT_FOOD_VALUE2 = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[3]/td[3]/select"));
    public static final SelenideElement PRESS_ENTER_DROPDOWN_FOOD_VALUE = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[3]/td[3]/select"));
    public static final SelenideElement ADD_VALUE_TO_FOOD_LOG = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[3]/td[5]/a"));
    public static final SelenideElement RESULT_OF_FOOD_LOG = $(By.xpath("//*[@id=\"food-log\"]/table/tfoot/tr/td[2]"));
    public static final SelenideElement ENTER_TYPE_OF_FOOD = $(By.xpath("//*[@id=\"food-search-bar\"]/form/input"));
    public static final SelenideElement VISIBILITY_NAME_OF_LOG = $(By.xpath("//*[@id=\"main\"]/h1"));
    public static final SelenideElement SEARCH_RESULT = $(By.xpath("//*[@id=\"food-search-all\"]/div[1]/table/tbody/tr[1]/td[1]/a"));
    public static final SelenideElement INPUT_NEW_CUSTOM_FOOD = $(By.xpath("//*[@id=\"food-search-bar\"]/form/input"));
    public static final SelenideElement SEARCH_RESULT_OF_CUSTOM_FOOD = $(By.xpath("//*[@id=\"food-search-custom\"]/div[1]/div"));


    @Override
    public DashBoardPage isPageOpened() {
        $(PROFILE_LINK).shouldBe(Condition.visible);
        return this;
    }


    @Step("Add food button")
    public void addFoodButton() {
        log.info("Add food button");
        $(ADD_FOOD_BUTTON).click();
    }

    @Step("Enter type of food")
    public void setEnterTypeOfFood() {
        log.info("Enter type of food");
        $(ENTER_TYPE_OF_FOOD).sendKeys("cheese");
    }

    @Step("Input new custom food")
    public void setInputNewCustomFood() {
        log.info("Input new custom food");
        $(INPUT_NEW_CUSTOM_FOOD).sendKeys("dranik");
    }

    @Step("Enter type of food amount")
    public void setEnterTypeOfFoodAmount() {
        log.info("Enter type of food amount");
        $(ENTER_TYPE_OF_FOOD_AMOUNT).sendKeys("3");
    }

    @Step("Choose the variant from dropdown kind of food")
    public void chooseTheVariantFromDropdownKindOfFood() {
        log.info("Choose the variant from dropdown kind of food");
        $(ENTER_DROPDOWN_FOOD_VALUE).sendKeys(Keys.ARROW_DOWN);
        $(ENTER_DROPDOWN_FOOD_VALUE).pressEnter();
    }


    @Step("Clean input space of food amount")
    public void cleanInputSpaceFoodAmount() {
        log.info("Clean input space of food amount");
        $(CLEAN_FOOD).sendKeys(Keys.CONTROL + "a");
        $(BACK_SPACE_FOOD_AMOUNT).sendKeys(Keys.BACK_SPACE);
    }


    @Step("Choose the food amount variant from dropdown")
    public void chooseFoodInVariantFromDropdown() {
        log.info("Choose the food amount variant from dropdown");
        $(PRESS_ENTER_DROPDOWN_FOOD_VALUE).sendKeys(Keys.ARROW_DOWN);
        $(PRESS_ENTER_DROPDOWN_FOOD_VALUE).pressEnter();
    }

    @Step("Create custom food item")
    public void createCustomFoodItem() {
        log.info("Create custom food item");
        $(CREATE_CUSTOM_FOOD).click();
    }

    @Step("Add value to food log")
    public void addValueToFoodLog() {
        log.info("Add value to food log");
        $(ADD_VALUE_TO_FOOD_LOG).click();
    }

    @Step("results food button test")
    public void setResultOfFoodLog() {
        log.info("results food button test");
        $(VISIBILITY_NAME_OF_LOG).shouldBe(visible);
    }

    @Step("Result food search test")
    public void setSearchResult() {
        log.info("Result food search test");
        $(SEARCH_RESULT).shouldBe(visible);
    }

    @Step("Result search of custom food")
    public void setSearchResultOfCustomFood() {
        log.info("Result search of custom food");
        $(SEARCH_RESULT_OF_CUSTOM_FOOD).shouldNotBe(visible);
    }

    @Step("Search result of food log")
    public void setResultOfFood() {
        log.info("Search result of food log");
        $(RESULT_OF_FOOD_LOG).shouldNotBe(value("0"));
    }

}

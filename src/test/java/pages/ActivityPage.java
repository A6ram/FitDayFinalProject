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
public class ActivityPage extends BasePage {
    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement VISIBILITY_NAME_OF_ACTIVITY_LOG = $("#main");
    public static final SelenideElement DROPDOWN_VARIANT_ACTIVITY =$("#activity-browse");
    public static final SelenideElement AVTIVITY_SEARCH_ALL = $("#activity-search-all");
    public static final SelenideElement INPUT_SPACE_OF_ACTIVITY_TIME = $(By.xpath("(//input[@name='hours'])[1]"));
    public static final SelenideElement ADD_VALUE_TO_ACTIVITY_LOG = $("a[class='add icon']");
    public static final SelenideElement ENTER_TYPE_OF_ACTIVITY = $("input[value='What did you do today?']");
    public static final SelenideElement ADD_TO_ACTIVITY_LOG = $(".activity-add-button.add.button");
    public static final SelenideElement ACTIVITY_BOTTOM = $("#activity-bottom");
    public static final SelenideElement ACTIONS_BUTTON = $(".edit.icon");
    public static final SelenideElement DELETE_BUTTON = $(".button-icon.delete");
    public static final SelenideElement RESULT_OF_ACTIVITY_LOG = $("tfoot td:nth-child(1)");

    @Override
    public ActivityPage isPageOpened() {
        $(PROFILE_LINK).shouldBe(Condition.visible);
        return this;
    }
    @Step("Results activity button test")
    public void checkResultInActivityLog() {
        log.info("Results activity button test");
        $(VISIBILITY_NAME_OF_ACTIVITY_LOG).shouldBe(visible);
    }

    @Step("Choose the dropdown activity variant")
    public void chooseTheVariantFromDropdownActivity() {
        log.info("Choose the dropdown activity variant");
        $(DROPDOWN_VARIANT_ACTIVITY).sendKeys(Keys.ARROW_DOWN);
        $(DROPDOWN_VARIANT_ACTIVITY).pressEnter();
    }
    @Step("Search result of activity log")
    public void checkResultOfActivity(){
        log.info("Search result of activity log");
        $(AVTIVITY_SEARCH_ALL).shouldBe(visible);

    }
    @Step("Input time of activity space")
    public void inputSpaceTimeOfActivity(String type) {
        log.info("Input time of activity space");
        $(INPUT_SPACE_OF_ACTIVITY_TIME).sendKeys(Keys.CONTROL + "a");
        $(INPUT_SPACE_OF_ACTIVITY_TIME).sendKeys(type);
    }
    @Step("Add value to food log")
    public void addValueToFoodLog() {
        log.info("Add value to food log");
        $(ADD_VALUE_TO_ACTIVITY_LOG).click();
    }
    @Step("Enter type of food")
    public void addActivityBySearch(String type) {
        log.info("Enter type of food");
        $(ENTER_TYPE_OF_ACTIVITY).sendKeys(type);
    }
    @Step("Add to activity log")
    public void addToActivityLog(){
        log.info("Add to activity log");
        $(ADD_TO_ACTIVITY_LOG).click();
    }
    @Step
    public void searchActivityBottom(){
        log.info("");
        $(ACTIVITY_BOTTOM).shouldBe(visible);
    }
    @Step("Add actions button")
    public void addActionsButton() {
        $(ACTIONS_BUTTON).click();
    }
    @Step("Add delete button")
    public void addDeleteButton() {
        $(DELETE_BUTTON).click();
    }
    @Step("Search result of activity log")
    public void resultOfActivity() {
        log.info("Search result of activity log");
        $(RESULT_OF_ACTIVITY_LOG).shouldNotBe(value("0"));
    }



}

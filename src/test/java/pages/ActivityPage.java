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
public class ActivityPage extends BasePage {
    public static final By PROFILE_LINK = By.id("profile-link");
    public static final SelenideElement DROPDOWN_VARIANT_ACTIVITY = $("#activity-browse");
    public static final SelenideElement INPUT_SPACE_OF_ACTIVITY_TIME = $(By.xpath("(//input[@name='hours'])[1]"));
    public static final SelenideElement ADD_VALUE_TO_ACTIVITY_LOG = $("a[class='add icon']");
    public static final SelenideElement ADD_TO_ACTIVITY_LOG = $(".activity-add-button.add.button");
    public static final SelenideElement ACTIONS_BUTTON = $(".edit.icon");
    public static final SelenideElement DELETE_BUTTON = $(".button-icon.delete");
    public static final SelenideElement RESULT_OF_ACTIVITY_LOG = $(By.xpath("//td[@class='name']"));
    public static final SelenideElement ACTIVITY_UNIT = $(By.xpath("(//select[@name='unit'])[1]"));
    public static final SelenideElement ACTIVITY_DISTANTION = $(By.xpath("(//input[@name='distance'])[1]"));

    @Override
    public ActivityPage isPageOpened() {
        $(PROFILE_LINK).shouldBe(Condition.visible);
        return this;
    }

    @Step
    public void createDataInActivityLog(String activity, String time, String dist, String unit) {
        log.info("Create data in activity log");
        $(DROPDOWN_VARIANT_ACTIVITY).sendKeys(activity);
        $(INPUT_SPACE_OF_ACTIVITY_TIME).sendKeys(Keys.CONTROL + "a");
        $(INPUT_SPACE_OF_ACTIVITY_TIME).sendKeys(Keys.BACK_SPACE);
        $(INPUT_SPACE_OF_ACTIVITY_TIME).sendKeys(time);
        $(ACTIVITY_DISTANTION).sendKeys(dist);
        $(ACTIVITY_UNIT).sendKeys(unit);
        $(ADD_VALUE_TO_ACTIVITY_LOG).click();

    }

    @Step
    public void addToActivityLog() {
        log.info("Add to activity log");
        $(ADD_TO_ACTIVITY_LOG).click();

    }

    @Step
    public void deleteFromActivityLog() {
        log.info("Add actions button");
        $(ACTIONS_BUTTON).click();
        $(DELETE_BUTTON).click();

    }

    @Step
    public void validateResultWalking(String searchResult) {
        log.info("Validation result Activity Walking");
        $(RESULT_OF_ACTIVITY_LOG).getText();
        assertEquals(searchResult, "backpacking");

    }

    @Step
    public void validateResultBicycling(String searchResult) {
        log.info("Validation result Activity Bicycling");
        $(RESULT_OF_ACTIVITY_LOG).getText();
        assertEquals(searchResult, "BMX or mountain biking");

    }
}

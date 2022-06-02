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
    public static final SelenideElement ADD_FOOD_BUTTON = $(By.xpath("(//span[contains(text(),'Add »')])[1]"));
    public static final SelenideElement ADD_ACTIVITY_BUTTON = $(By.xpath("(//span[contains(text(),'Add »')])[2]"));



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
    @Step("Add activity button")
    public void addActivityButton(){
        log.info("Add activity button");
        $(ADD_ACTIVITY_BUTTON).click();


    }


}

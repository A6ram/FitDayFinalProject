package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("username");
    public static final SelenideElement PASSWORD_INPUT = $(By.xpath("//input[@type='password']"));
    public static final SelenideElement LOGIN_BUTTON = $(By.xpath("//input[@value='Login']"));
    public static final By FORM_LOGIN = By.id("form-login");
    public static final SelenideElement ERROR_MESSAGE = $("p[for='Password']");

    @Override
    public LoginPage isPageOpened() {
        $(FORM_LOGIN).shouldBe(Condition.visible);
        return this;
    }

    @Step("Opening login page")
    public LoginPage openPage() {
        open("https://www.fitday.com/fitness/Login.html");
        return this;
    }

    @Step("Login by '{user}' using password '{password}'")
    public void login(String user, String password) {
        $(USERNAME_INPUT).sendKeys(user);
        $(PASSWORD_INPUT).sendKeys(password);
        $(LOGIN_BUTTON).submit();
    }

    @Step("Login by '{user}' without '{password}'")
    public void loginWithoutPassword(String user) {
        $(USERNAME_INPUT).sendKeys(user);
        $(LOGIN_BUTTON).submit();


    }

    @Step("Get error message")
    public void getErrorMessage() {
        $(ERROR_MESSAGE).shouldBe(Condition.visible);

    }
}

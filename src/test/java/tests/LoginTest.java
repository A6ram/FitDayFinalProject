package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login")
    public void positiveLogin() {
        loginPage.openPage();
        loginPage.login(user, password);
        loginPage.isPageOpened();
    }

    @Test(description = "Login without password")
    public void loginWithoutPassword() {
        loginPage.openPage();
        loginPage.login(user, "");
        loginPage.getErrorMessage("Password is required.");
    }

}

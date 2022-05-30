package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login")
    public void positiveLogin() {
        loginSteps.login(user, password);
    }

}

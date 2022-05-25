package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.*;
import steps.LoginSteps;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    public String user;
    public String password;
    protected LoginSteps loginSteps;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening browser")
    public void setUp(ITestContext context, @Optional("chrome") String browser) {
        log.info("start test");
        log.info(browser);

        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.baseUrl = "https://www.fitday.com/";
        Configuration.browser = "Chrome";
        Configuration.timeout = 10000;
        Configuration.clickViaJs = true;
        Configuration.headless = false; // Для Jenkins нужно

        loginSteps = new LoginSteps();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}

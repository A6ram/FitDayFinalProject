package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    public String user;
    public String password;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening browser")
    public void setUp(ITestContext context, @Optional("chrome") String browser) {
        log.info("start test");
        log.info(browser);

        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.clickViaJs = true;
        Configuration.headless = false; // Для Jenkins нужно

        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}

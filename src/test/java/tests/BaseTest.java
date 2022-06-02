package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import pages.ActivityPage;
import pages.DashBoardPage;
import pages.FoodPage;
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
    public FoodPage foodPage;
    public ActivityPage activityPage;

    @BeforeMethod(description = "Opening browser")
    public void setUp(@Optional("chrome") String browser) {

        log.info("start test");
        log.info(browser);

        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));

        Configuration.browser = "chrome";
        Configuration.timeout = 30000;
        Configuration.clickViaJs = true;
        Configuration.headless = false; // Для Jenkins нужно

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.reportsFolder = "target/allure-results";

        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        foodPage = new FoodPage();
        activityPage= new ActivityPage();
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}

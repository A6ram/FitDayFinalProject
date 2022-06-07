package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.*;
import pages.ActivityPage;
import pages.DashBoardPage;
import pages.FoodPage;
import pages.LoginPage;
import utils.PropertyReader;
import utils.TestListener;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



public class BaseTest {
    public String user;
    public String password;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;
    public FoodPage foodPage;
    public ActivityPage activityPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening browser")
    public void setUp(@Optional("chrome") String browser) {

        user = System.getProperty("user", PropertyReader.getProperty("user"));
        password = System.getProperty("password", PropertyReader.getProperty("password"));


        Configuration.browser = browser;
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.reportsFolder = "target/allure-results";

        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        foodPage = new FoodPage();
        activityPage = new ActivityPage();

    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void close() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}

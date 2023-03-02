package tests;

import framework.browser.Browser;
import framework.utils.JsonConverter;
import framework.utils.PropertiesManager;
import framework.utils.SmartLogger;
import framework.utils.api.Response;
import io.restassured.http.ContentType;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.BookStoreApplicationPageSteps;
import steps.HomePageSteps;
import steps.LoginPageSteps;
import utils.BookStoreApi;

import static services.ConfigVariables.*;
import static services.Files.CONFIG_PROPERTIES;
import static services.Paths.TEST_RESOURCES_PATHS;

public class AccountTest extends BaseTest {

    private int stepNumber;

    @DataProvider
    public Object[][] getParameters() {
        return new Object[][]{
                {"02user", "03Pass!@"},
                {"03user", "03Pass!@"}
        };
    }

    @Test(priority = 1, dataProvider = "getParameters")
    protected void accountApiRegistration(String userName, String password) {
        stepNumber = 0;
        SmartLogger.logStep(++stepNumber, "Registration user from api request");
        User user = new User(userName, password);
        Response response = BookStoreApi.registrationUser(ContentType.JSON, JsonConverter.getJsonString(user));
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_CREATED, "User isn't registered");
    }

    @Test(priority = 2, dataProvider = "getParameters")
    protected void accountAuthorization(String userName, String password) {
        stepNumber = 0;
        SmartLogger.logStep(++stepNumber, "Go to ".concat(DEMOQA_URI.getConfigVariable()));
        Browser.setMaximizeWindow();
        Browser.timeouts();
        Browser.openUrl(PropertiesManager.getValue(TEST_RESOURCES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
                DEMOQA_URI.getConfigVariable()));
        HomePageSteps.assertIsOpenHomePage();

        SmartLogger.logStep(++stepNumber, "Open Book Store Application");
        HomePageSteps.clickBookStoreApplicationBtn();
        BookStoreApplicationPageSteps.assertIsOpenBookStoreApplicationPage();

        SmartLogger.logStep(++stepNumber, "Open Login page");
        BookStoreApplicationPageSteps.clickLoginBtn();
        LoginPageSteps.assertIsOpenLoginPage();

        SmartLogger.logStep(++stepNumber, "Authorization user from Book Store application");
        LoginPageSteps.inputUserName(userName);
        LoginPageSteps.inputPassword(password);
        LoginPageSteps.clickLoginBtn();
        BookStoreApplicationPageSteps.assertIsOpenBookStoreApplicationPage();
        Assert.assertEquals(BookStoreApplicationPageSteps.getUserName(), userName, "User name isn't correct ");
    }
}

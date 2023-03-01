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
    private String userName = PropertiesManager.getValue(TEST_RESOURCES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
            USER_NAME.getConfigVariable());
    private String password = PropertiesManager.getValue(TEST_RESOURCES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
            PASSWORD.getConfigVariable());
    private User user = new User(userName, password);

    @Test(priority = 1)
    protected void accountApiRegistration() {
        stepNumber = 0;
        SmartLogger.logStep(++stepNumber, "Registration user from api request");
        Response response = BookStoreApi.registrationUser(ContentType.JSON, JsonConverter.getJsonString(user));
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_CREATED, "User isn't registered");
    }

    @Test(priority = 2)
    protected void accountAuthorization() {
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
        LoginPageSteps.inputUserName(user.getUserName());
        LoginPageSteps.inputPassword(user.getPassword());
        LoginPageSteps.clickLoginBtn();
        BookStoreApplicationPageSteps.assertIsOpenBookStoreApplicationPage();
        Assert.assertEquals(BookStoreApplicationPageSteps.getUserName(), user.getUserName(), "User name isn't correct ");
    }
}

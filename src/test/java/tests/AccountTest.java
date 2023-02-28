package tests;

import framework.utils.JsonConverter;
import framework.utils.PropertiesManager;
import framework.utils.SmartLogger;
import framework.utils.api.Response;
import io.restassured.http.ContentType;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BookStoreApi;

import static services.ConfigVariables.PASSWORD;
import static services.ConfigVariables.USER_NAME;
import static services.Files.CONFIG_PROPERTIES;
import static services.Paths.CONFIG_PROPERTIES_PATHS;

public class AccountTest extends BaseTest {

    private int stepNumber;
    private String userName = PropertiesManager.getValue(CONFIG_PROPERTIES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
            USER_NAME.getConfigVariable());
    private String password = PropertiesManager.getValue(CONFIG_PROPERTIES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
            PASSWORD.getConfigVariable());
    private User user = new User(userName, password);

    @Test(priority = 0)
    protected void accountApiRegistration() {
        stepNumber = 0;
        SmartLogger.logStep(++stepNumber, "Registration user from api request");
        Response response = BookStoreApi.registrationUser(ContentType.JSON, JsonConverter.getJsonString(user));
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_CREATED, "Don't correct status code");
    }
}

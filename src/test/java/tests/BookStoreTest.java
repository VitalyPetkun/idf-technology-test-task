package tests;

import framework.browser.Browser;
import framework.utils.JsonConverter;
import framework.utils.PropertiesManager;
import framework.utils.SmartLogger;
import framework.utils.api.Response;
import io.restassured.http.ContentType;
import models.Books;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BookStoreApplicationPageSteps;
import steps.HomePageSteps;
import utils.BookStoreApi;

import java.util.ArrayList;
import java.util.List;

import static services.ConfigVariables.DEMOQA_URI;
import static services.Files.CONFIG_PROPERTIES;
import static services.Paths.TEST_RESOURCES_PATHS;

public class BookStoreTest extends BaseTest {

    private int stepNumber;

    @Test
    protected void booksTitlesTest() {
        stepNumber = 0;
        SmartLogger.logStep(++stepNumber, "Get list books titles from api");
        Response response = BookStoreApi.getBooks(ContentType.JSON);
        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "Status code isn't correct");
        Books books = JsonConverter.getObject(response.getBody(), Books.class);
        List<String> apiBooksTitles = new ArrayList<>();
        books.getBooks().forEach(Book -> apiBooksTitles.add(Book.getTitle()));

        SmartLogger.logStep(++stepNumber, "Get list books titles from Books Store Application");
        Browser.setMaximizeWindow();
        Browser.timeouts();
        Browser.openUrl(PropertiesManager.getValue(TEST_RESOURCES_PATHS.getPath(), CONFIG_PROPERTIES.getFile(),
                DEMOQA_URI.getConfigVariable()));
        HomePageSteps.assertIsOpenHomePage();
        HomePageSteps.clickBookStoreApplicationBtn();
        BookStoreApplicationPageSteps.assertIsOpenBookStoreApplicationPage();
        Assert.assertEquals(BookStoreApplicationPageSteps.getTextBooksTitlesLnk(), apiBooksTitles,
                "Titles books aren't correct");
    }
}

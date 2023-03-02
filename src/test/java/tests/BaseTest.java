package tests;

import framework.browser.Browser;
import framework.utils.api.ApiUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.Uri;

public class BaseTest {

    @BeforeMethod
    protected void setup() {
        ApiUtils.setupBaseUri(Uri.DEMOQA_URI.getUri());
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}

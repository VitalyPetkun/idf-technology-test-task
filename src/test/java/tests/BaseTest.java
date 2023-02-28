package tests;

import framework.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    protected void setUp() {
        Browser.setMaximizeWindow();
        Browser.timeouts();
    }

    @AfterMethod
    protected void quitDriver() {
        Browser.quit();
    }
}

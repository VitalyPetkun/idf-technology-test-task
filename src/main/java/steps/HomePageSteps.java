package steps;

import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {

    private static final HomePage homePage = new HomePage();

    private HomePageSteps() {
    }

    public static void clickBookStoreApplicationBtn() {
        homePage.clickBookStoreApplicationBtn();
    }

    public static void assertIsOpenHomePage() {
        Assert.assertTrue(homePage.isFormOpen(), "Home page isn't open");
    }
}

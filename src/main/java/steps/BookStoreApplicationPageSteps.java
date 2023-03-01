package steps;

import org.testng.Assert;
import pages.BookStoreApplicationPage;

import java.util.List;

public class BookStoreApplicationPageSteps {

    private static final BookStoreApplicationPage bookStoreApplicationPage = new BookStoreApplicationPage();

    private BookStoreApplicationPageSteps() {
    }

    public static void click() {
        bookStoreApplicationPage.clickLoginBtn();
    }

    public static List<String> getTextBooksTitlesLnk() {
        return bookStoreApplicationPage.getTextBooksTitlesLnk();
    }

    public static void assertIsOpenBookStoreApplicationPage() {
        Assert.assertTrue(bookStoreApplicationPage.isFormOpen(), "Don't open Book Store Application page");
    }
}

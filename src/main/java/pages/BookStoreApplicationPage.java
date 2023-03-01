package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Link;
import org.openqa.selenium.By;

public class BookStoreApplicationPage extends BaseForm {

    private static final Button BOOK_STORE_APPLICATION_PAGE_UNIQ_ELEMENT = new Button(
            By.xpath("//div[contains(@class,'books')]/div[@id='searchBox-wrapper']"), "Book Store Application page uniq element"
    );
    private static final Button LOGIN_BTN = new Button(By.xpath("//button[@id='login']"), "Login button");
    private static final Link BOOKS_TITLES_LNK = new Link(By.xpath("//div[contains(@class,'td')]//span/a"), "Books titles link");

    public BookStoreApplicationPage() {
        super(BOOK_STORE_APPLICATION_PAGE_UNIQ_ELEMENT, "Book Store Application page");
    }

    public static void clickLoginBtn() {
        LOGIN_BTN.click();
    }

    public static String getTextBooksTitlesLnk() {
        return BOOKS_TITLES_LNK.getText();
    }
}

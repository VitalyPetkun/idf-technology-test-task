package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.Link;
import framework.elements.TextBox;
import org.openqa.selenium.By;

import java.util.List;

public class BookStoreApplicationPage extends BaseForm {

    private static final TextBox BOOK_STORE_APPLICATION_PAGE_UNIQ_ELEMENT = new TextBox(
            By.xpath("//div[contains(@class,'books')]/div[@id='searchBox-wrapper']"),
            "Book Store Application page uniq element");
    private static final Button LOGIN_BTN = new Button(By.xpath("//button[@id='login']"), "Login button");
    private static final Link BOOKS_TITLES_LNK = new Link(By.xpath("//div[contains(@class,'td')]//span/a"),
            "Books titles link");

    private static final Label USER_NAME_LBL = new Label(By.xpath("//label[@id='userName-value']"), "User name label");

    public BookStoreApplicationPage() {
        super(BOOK_STORE_APPLICATION_PAGE_UNIQ_ELEMENT, "Book Store Application page");
    }

    public void clickLoginBtn() {
        LOGIN_BTN.click();
    }

    public List<String> getTextBooksTitlesLnk() {
        return this.getElementsText(BOOKS_TITLES_LNK.getLocator());
    }

    public String getUserName() {
        return USER_NAME_LBL.getText();
    }
}

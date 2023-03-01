package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    private static final TextBox HOME_PAGE_UNIQ_ELEMENT = new TextBox(
            By.xpath("//div[contains(@class,'home')]"), "Home page uniq element");
    private static final Button BOOK_STORE_APPLICATION_BTN = new Button(
            By.xpath("//div/h5[contains(text(),'Book Store')]"), "Book Store Application button");


    private HomePage() {
        super(HOME_PAGE_UNIQ_ELEMENT, "Home page");
    }

    public void clickBookStoreApplicationBtn() {
        BOOK_STORE_APPLICATION_BTN.click();
    }
}

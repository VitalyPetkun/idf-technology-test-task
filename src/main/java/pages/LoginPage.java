package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private static final TextBox LOGIN_PAGE_UNIQ_ELEMENT = new TextBox(By.xpath("//form[@id='userForm']/div"),
            "Login page uniq element");
    private static final TextBox USER_NAME_TXT_BOX = new TextBox(By.xpath("//div[contains(@id,'userName')]/div/input"),
            "User name text box");
    private static final TextBox PASSWORD_TXT_BOX = new TextBox(By.xpath("//div[contains(@id,'password')]/div/input"),
            "Password text box");
    private static final Button LOGIN_BTN = new Button(By.xpath("//button[@id='login']"), "Login button");

    public LoginPage() {
        super(LOGIN_PAGE_UNIQ_ELEMENT, "Login page");
    }

    public static void clickAndClearUsernameTxtBox() {
        USER_NAME_TXT_BOX.clickAndClear();
    }

    public static void inputTextUserNameTxtBox(String userName) {
        USER_NAME_TXT_BOX.inputText(userName);
    }

    public static void clickAndClearPasswordTxtBox() {
        PASSWORD_TXT_BOX.clickAndClear();
    }

    public static void inputTextPasswordTxtBox(String password) {
        PASSWORD_TXT_BOX.inputText(password);
    }

    public static void clickLoginBtn() {
        LOGIN_BTN.click();
    }
}

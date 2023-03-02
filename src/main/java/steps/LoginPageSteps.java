package steps;

import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    private static final LoginPage loginPage = new LoginPage();

    private LoginPageSteps() {
    }

    public static void inputUserName(String userName) {
        loginPage.clickAndClearUserNameTxtBox();
        loginPage.inputTextUserNameTxtBox(userName);
    }

    public static void inputPassword(String password) {
        loginPage.clickAndClearPasswordTxtBox();
        loginPage.inputTextPasswordTxtBox(password);
    }

    public static void clickLoginBtn() {
        loginPage.clickLoginBtn();
    }

    public static void assertIsOpenLoginPage() {
        Assert.assertTrue(loginPage.isFormOpen(), "Don't open login page");
    }
}

package org.auto.simple.tests.users;

import org.auto.simple.pages.LoginPage;
import org.auto.simple.tests.BaseTest;
import org.auto.simple.utils.NavigationUtils;

/**
 * This test verifies validation of user credentials on login page.
 * 
 * @author Maksym Barvinskyi
 */
public class LoginValidation extends BaseTest {

    private LoginPage loginPage;

    public LoginValidation() throws Exception {
        super("data/users/LoginValidation.csv", "Login Validation");
    }

    @Override
    protected void onExecute() {
        startWebApplication();
        enterLogin();
        enterPassword();
        verifyLoginButtonState();
    }

    private void startWebApplication() {
        loginPage = NavigationUtils.startWebApplication(browser);
    }

    private void enterLogin() {
        loginPage.setLogin(data.get("Login"));
    }

    private void enterPassword() {
        loginPage.setPassword(data.get("Password"));
    }

    private void verifyLoginButtonState() {
        boolean expectedState = Boolean.parseBoolean(data.get("LoginButtonEnabled"));
        loginPage.verifyLoginButtonEnabled(expectedState);
    }

}

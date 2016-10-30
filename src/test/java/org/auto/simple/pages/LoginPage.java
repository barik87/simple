package org.auto.simple.pages;

import org.auto.simple.elements.SmartWebElement;
import org.auto.simple.report.ErrorsHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private SmartWebElement edtLogin = new SmartWebElement(By.id("login"));
    private SmartWebElement edtPassword = new SmartWebElement(By.id("pswd"));
    private SmartWebElement btnLogin = new SmartWebElement(By.id("btn-login"));

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void setLogin(String login) {
        edtLogin.clearAndType(browser, login);
    }

    public void setPassword(String password) {
        edtPassword.clearAndType(browser, password);
    }

    public void clickLoginButton() {
        btnLogin.click(browser);
    }

    public void verifyLoginButtonEnabled(boolean expectedState) {
        boolean actualState = btnLogin.getAttribute(browser, "disabled");
        if (actualState != expectedState) {
            ErrorsHolder.failIteration("Verification of Login button enabled state failed. Actual: " + actualState
                    + ". Expected: " + expectedState + ".");
        }
    }

}

package org.auto.simple.pages;

import org.auto.simple.SmartWebElement.PageInit;
import org.auto.simple.SmartWebElement.SmartWebElement;
import org.auto.simple.report.ErrorsHolder;
import org.omg.CORBA.Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login")
    private SmartWebElement edtLogin;
    @FindBy(id = "pswd")
    private SmartWebElement edtPassword;
    @FindBy(id = "btn-login")
    private SmartWebElement btnLogin;
    private LoginPage loginPage;

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void setLogin(String login) {
        edtLogin.clear();
        edtLogin.enterText(login).pressEnter();
    }

    public void setPassword(String password) {
        edtPassword.clear();
        edtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public void verifyLoginButtonEnabled(boolean expectedState) {
        boolean actualState = btnLogin.getAttribute("disabled") == null;
        if (actualState != expectedState) {
            ErrorsHolder.failIteration("Verification of Login button enabled state failed. Actual: " + actualState
                    + ". Expected: " + expectedState + ".");
        }
    }

}

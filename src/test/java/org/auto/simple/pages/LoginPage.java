package org.auto.simple.pages;

import org.auto.simple.SmartWebElement.*;
import org.auto.simple.report.ErrorsHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "login")
    private SmartWebElement edtLogin;
    private SmartWebElement edtPassword;
    private SmartWebElement btnLogin;

//    public LoginPage(WebDriver browser) {
//        super(browser);
//    }

    public void setLogin(String login) {
//        edtLogin = edtLogin.find(By.id("login"));
        edtLogin.clear();
        edtLogin.enterText(login).pressEnter();
    }

    public void setPassword(String password) {
        edtPassword.findElement(By.id("pswd"));
        edtPassword.clear();
        edtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.findElement(By.id("btn-login"));
        btnLogin.click();
    }

    public void verifyLoginButtonEnabled(boolean expectedState) {
        btnLogin.findElement(By.id("btn-login"));
        boolean actualState = btnLogin.getAttribute("disabled") == null;
        if (actualState != expectedState) {
            ErrorsHolder.failIteration("Verification of Login button enabled state failed. Actual: " + actualState
                    + ". Expected: " + expectedState + ".");
        }
    }

}

package org.auto.simple.utils;

import org.auto.simple.pages.LoginPage;
import org.auto.simple.pages.PizzaPage;
import org.openqa.selenium.WebDriver;

public class NavigationUtils {
    public static LoginPage startWebApplication(WebDriver browser) {
        browser.get("file:///" + FileSystemUtils.addAbsolutePath("app/index.html"));
        return new LoginPage(browser);
    }

    public static PizzaPage openPizzaPage(WebDriver browser) {
        browser.get("file:///" + FileSystemUtils.addAbsolutePath("app/pizza.html"));
        return new PizzaPage(browser);

    }
}

package org.auto.simple.utils;

import org.auto.simple.pages.LoginPage;
import org.auto.simple.pages.PizzaPage;
import org.auto.simple.webBrowser.WebBrowser;
import org.openqa.selenium.WebDriver;


public class NavigationUtils {


    public static LoginPage startWebApplication() {
        WebDriver browser = WebBrowser.getInstance();
        WebBrowser.openUrl("file:///" + FileSystemUtils.addAbsolutePath("app/index.html"));
        return new LoginPage(browser);
    }

    public static PizzaPage openPizzaPage() {
        WebDriver browser = WebBrowser.getInstance();
        WebBrowser.openUrl("file:///" + FileSystemUtils.addAbsolutePath("app/pizza.html"));
        return new PizzaPage(browser);

    }
}

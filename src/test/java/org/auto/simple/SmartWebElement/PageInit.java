package org.auto.simple.SmartWebElement;

import com.gargoylesoftware.htmlunit.Page;
import org.omg.CORBA.Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageInit {
    public PageInit() {
    }

    static SmartWebElement smartWebElement;

    public static void initElement(WebDriver browser, Object page) {
        final WebDriver browserInit = browser;
        initElement(browser, page);
    }
}

package org.auto.simple.webBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;


public class WebBrowser {

    private static WebDriver browser = null;
    private static Browser browserType;

    private WebBrowser() {
        // Exists only to defeat instantiation
    }

    public static void setBrowser(Browser browserType) {
        WebBrowser.browserType = browserType;
    }

    public static WebDriver getInstance() {
        if (browser == null) {
            switch (browserType) {
                case CHROME:
                    browser = new ChromeDriver();
                    break;
                case FIREFOX:
                    browser = new FirefoxDriver();
                    break;
                default:
                    browser = new ChromeDriver();
                    break;
            }
            browser.manage().window().maximize();
            browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return browser;
    }

    public static void openUrl(String url) {
        browser.get(url);
    }

    public static void quitBrowser() {
        if (browser != null) {
            browser.quit();
            browser = null;
        }
    }
}

package org.auto.simple.utils;

import org.auto.simple.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class NavigationUtils {
	public static LoginPage startWebApplication(WebDriver browser) {
		browser.get("file:///" + FileSystemUtils.addAbsolutePath("app/index.html"));
		return new LoginPage(browser);
	}
}

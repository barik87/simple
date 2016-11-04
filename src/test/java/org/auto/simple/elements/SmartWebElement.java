package org.auto.simple.elements;

import org.auto.simple.webBrowser.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartWebElement {

    private By by;
    private WebDriver browser = WebBrowser.getInstance();

    public SmartWebElement(By by) {
        this.by = by;
    }

    public void clearAndType(String var) {
        WebElement element = browser.findElement(by);
        element.clear();
        element.sendKeys(var);
    }

    public void click() {
        WebElement element = browser.findElement(by);
        element.click();
    }

    public boolean getAttribute(String var) {
        WebElement element = browser.findElement(by);
        return element.getAttribute(var) == null;

    }

    public void selectDropdown(String var) {
        Select element = new Select(browser.findElement(by));
        element.selectByValue(var);

    }

    public void selectCheckBox() {
        WebElement element = browser.findElement(by);
        if (element.isSelected()) {
            element.clear();
            element.click();
        } else {
            element.click();
        }
    }

    public String getText() {
        WebElement element = browser.findElement(by);
        return element.getText();

    }

    public void waitForElement() {
        WebDriverWait driverWait = new WebDriverWait(browser, 5);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

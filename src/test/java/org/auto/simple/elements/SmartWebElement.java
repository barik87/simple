package org.auto.simple.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartWebElement {

    private By by;

    public SmartWebElement(By by) {
        this.by = by;
    }

    public void clearAndType(WebDriver driver, String var) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(var);
    }

    public void click(WebDriver driver) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public boolean getAttribute(WebDriver driver, String var) {
        WebElement element = driver.findElement(by);
        return element.getAttribute(var) == null;

    }
}

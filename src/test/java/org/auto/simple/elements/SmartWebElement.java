package org.auto.simple.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public void selectDropdown(WebDriver driver, String var) {
        Select element = new Select(driver.findElement(by));
        element.selectByValue(var);

    }

    public void multipleSelect(WebDriver driver, String... var) {
        List<WebElement> elements = driver.findElements(by);
        elements.clear();
        for (WebElement element : elements) {
            if (!element.findElement(By.className(String.valueOf(var))).isSelected())
                element.click();
        }
    }

    public String getElementText(WebDriver driver) {
        WebElement element = driver.findElement(by);
        return element.getText();

    }

    public void waitForElement(WebDriver driver) {
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

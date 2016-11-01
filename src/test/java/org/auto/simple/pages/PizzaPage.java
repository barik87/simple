package org.auto.simple.pages;

import org.auto.simple.elements.SmartWebElement;
import org.auto.simple.report.ErrorsHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class PizzaPage extends BasePage {

    private SmartWebElement createButton = new SmartWebElement(By.id("predefined"));
    private SmartWebElement checkBoxGoup = new SmartWebElement(By.className("ingredient"));
    private SmartWebElement sizeButton = new SmartWebElement(By.id("size"));
    private SmartWebElement stdCheeseRadioButton = new SmartWebElement(By.xpath(".//div[1]/div/div[2]/input[19]"));
    private SmartWebElement dblCheeseRadioButton = new SmartWebElement(By.xpath(".//div[1]/div/div[2]/input[20]"));
    private SmartWebElement orderButton = new SmartWebElement(By.id("btn-order"));
    private SmartWebElement successMessage = new SmartWebElement(By.id("result"));
    private SmartWebElement ingredientsMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[3]"));
    private SmartWebElement sizeMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[4]"));
    private SmartWebElement cheeseMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[5]"));

    public PizzaPage(WebDriver browser) {
        super(browser);
    }

    public void choosePizza(String pizzaType) {
        createButton.selectDropdown(browser, pizzaType);
    }

    public void ingredientsCheck(String ingredient) {
        checkBoxGoup.multipleSelect(browser, ingredient);
    }

    public void sizeSelect(String size) {
        sizeButton.selectDropdown(browser, size);
    }

    public void cheeseQty(String cheeseQty) {
        if (cheeseQty.equals("Standard")) {
            stdCheeseRadioButton.click(browser);
        } else dblCheeseRadioButton.click(browser);
    }

    public void makeAnOrder() {
        orderButton.click(browser);
    }


    public void verifyExpectedSuccessMessage(String message) {
        successMessage.waitForElement(browser);
        String actualMessage = successMessage.getElementText(browser);
        if (!actualMessage.contains(message)) {
            ErrorsHolder.failIteration("Verification of Success Order Message failed. Actual: " + actualMessage + ". Expected: " + message + ".");
        }

    }
}

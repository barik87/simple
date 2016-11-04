package org.auto.simple.pages;

import org.auto.simple.elements.SmartWebElement;
import org.auto.simple.report.ErrorsHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PizzaPage extends BasePage {

    private SmartWebElement createButton = new SmartWebElement(By.id("predefined"));
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
        createButton.selectDropdown(pizzaType);
    }

    public void ingredientsSelect(String ingredient) {
        String[] elements = ingredient.split(";");
        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i].trim();
        }
        for (String element : elements) {
            SmartWebElement checkBox = new SmartWebElement(By.id(element));
            checkBox.selectCheckBox();
        }
    }

    public void sizeSelect(String size) {
        sizeButton.selectDropdown(size);
    }

    public void cheeseQty(String cheeseQty) {
        if (cheeseQty.equals("Standard")) {
            stdCheeseRadioButton.click();
        } else {
            dblCheeseRadioButton.click();
        }
    }

    public void makeAnOrder() {
        orderButton.click();
    }


    public void verifyExpectedSuccessMessage(String message) {
        successMessage.waitForElement();
        String actualMessage = successMessage.getText();
        if (!actualMessage.contains(message)) {
            ErrorsHolder.failIteration("Verification of Success Order Message failed. Actual: " + actualMessage + ". Expected: " + message + ".");
        }
    }
}

package org.auto.simple.pages;

import org.auto.simple.elements.SmartWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class PizzaPage extends BasePage {

    private SmartWebElement createButton = new SmartWebElement(By.id("predefined"));
    private SmartWebElement checkBoxGoup = new SmartWebElement(By.id("ingredient"));
    private SmartWebElement sizeButton = new SmartWebElement(By.id("size"));
    private SmartWebElement cheeseRadioButton = new SmartWebElement(By.name("cheese"));
    private SmartWebElement orderButton = new SmartWebElement(By.id("btn-order"));
    private SmartWebElement successMessage = new SmartWebElement(By.className("success"));
    private SmartWebElement ingredientsMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[3]"));
    private SmartWebElement sizeMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[4]"));
    private SmartWebElement cheeseMessage = new SmartWebElement(By.xpath(".//*[@id='result']/br[5]"));

    public PizzaPage(WebDriver browser) {
        super(browser);
    }

    public void createPizza(String pizzaType) {
        createButton.selectDropdown(browser, pizzaType);
    }

    public void ingredientsCheck(List ingredient) {
        checkBoxGoup.multipleSelect(browser, ingredient);
    }

    public  void sizeSelect(String size) {
        sizeButton.selectDropdown(browser, size);
    }

    public void cheeseQty(String cheeseQty) {
        cheeseRadioButton.selectDropdown(browser, cheeseQty);
    }

    public void makeAnOrder() {
        orderButton.click(browser);
    }

    public void readMessage() {
        successMessage.getElementText(browser);
        ingredientsMessage.getElementText(browser);
        sizeMessage.getElementText(browser);
        cheeseMessage.getElementText(browser);
    }
}

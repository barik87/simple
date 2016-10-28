package org.auto.simple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


public class PizzaPage extends BasePage {

    public PizzaPage(WebDriver browser) {
        super(browser);
    }


    private WebElement createButton;
    private WebElement checkBoxGoup;
    private WebElement sizeButton;
    private WebElement stndCheeseChBox;
    private WebElement dblCheeseChBox;
    private WebElement orderButton;

    public void createPizzaButton(String pizzaType) {
        createButton = browser.findElement(By.id("predefined"));
        createButton.click();
        createButton.findElement(By.name(pizzaType)).click();
    }

    public void ingredientsCheck(HashMap ingredient) {
        checkBoxGoup = browser.findElement(By.className("ingredient"));


        
    }



}

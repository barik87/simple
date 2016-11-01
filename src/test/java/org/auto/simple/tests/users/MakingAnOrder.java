package org.auto.simple.tests.users;

import org.auto.simple.pages.PizzaPage;
import org.auto.simple.tests.BaseTest;
import org.auto.simple.utils.NavigationUtils;




public class MakingAnOrder extends BaseTest {

    private PizzaPage pizzaPage;

    public MakingAnOrder(String dataFilePath, String testName) throws Exception {
        super("data/users/MakingAnOrder.csv", "Making an Order");
    }

    @Override
    protected void onExecute() {
        startWebApplication();
        createPizza();
        verifyCreatedPizza();


    }

    private void startWebApplication() {
        pizzaPage = NavigationUtils.openPizzaPage(browser);
    }

    private void createPizza() {
        pizzaPage.choosePizza(data.get("PizzaType"));
        if(data.get("PizzaType") == "Create your own") {
            pizzaPage.ingredientsCheck(data.get("Ingredients"));
        }
    }

    private void verifyCreatedPizza() {

    }
}

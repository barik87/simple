package org.auto.simple.tests.users;

import org.auto.simple.pages.PizzaPage;
import org.auto.simple.tests.BaseTest;
import org.auto.simple.utils.NavigationUtils;

public class MakingAnOrder extends BaseTest {

    private PizzaPage pizzaPage;

    public MakingAnOrder() throws Exception {
        super("data/users/MakingAnOrder.csv", "Making an Order");
    }

    @Override
    protected void onExecute() {
        startWebApplication();
        createPizza();
        verifyCreatedPizza();
    }

    private void startWebApplication() {
        pizzaPage = NavigationUtils.openPizzaPage();
    }

    private void createPizza() {
        pizzaPage.choosePizza(data.get("PizzaType"));
        if (data.get("PizzaType").equals("own")) {
            pizzaPage.ingredientsSelect(data.get("Ingredient"));
        }
        pizzaPage.sizeSelect(data.get("Size"));
        pizzaPage.cheeseQty(data.get("CheeseQty"));
        pizzaPage.makeAnOrder();
    }

    private void verifyCreatedPizza() {
        pizzaPage.verifyExpectedSuccessMessage(data.get("ExpectedSuccessMessage"));
    }
}

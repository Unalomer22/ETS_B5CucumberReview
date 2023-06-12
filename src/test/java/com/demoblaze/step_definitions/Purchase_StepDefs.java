package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {
        ProductPage productPage=new ProductPage();
        CartPage cartPage=new CartPage();
    @When("The user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
        productPage.addProduct_mtd(product,category);
    }
    @When("The users removes {string} from cart")
    public void the_users_removes_from_cart(String remoevProduct) {
        cartPage.removeProduct_mtd(remoevProduct);
    }
    @When("The user places order and captures and log amount")
    public void the_user_places_order_and_captures_and_log_amount() {
        cartPage.finishePurchase_LogAmount_mtd();
    }
    @Then("The user verifies puchase amount equals {int}")
    public void the_user_verifies_puchase_amount_equals(Integer expectedAmount) {
        cartPage.verifyPurchaseAmount_mtd(expectedAmount);
    }


}

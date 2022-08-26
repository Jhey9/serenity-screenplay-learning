package swag.tasks.cart;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class AddToCard {
    public static Performable itemCalled(String itemName) {
        return Task.where("{0} Clicks on the add to cart button for" + itemName,
                Click.on(
                        Button.withText("ADD TO CART")
                                .inside(PageElement.locatedBy(".inventory_item").containingText(itemName))
                )
        );
    }
}

package swag.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProductsUserInterface {

    public static final Target TITLE =
            Target.the("The title the products").locatedBy(".title");

    public static final Target SHOPPING_CART_BADGE =
            Target.the("Number of shopping cart badge").locatedBy(".shopping_cart_badge");

}

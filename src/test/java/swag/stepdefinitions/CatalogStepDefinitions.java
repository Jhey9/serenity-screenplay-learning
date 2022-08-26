package swag.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import swag.tasks.Navigate;
import swag.tasks.cart.AddToCard;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static swag.userinterfaces.ProductsUserInterface.SHOPPING_CART_BADGE;

public class CatalogStepDefinitions {

    List<String> cartItems;

    @And("{actor} is browsing the catalog")
    public void IsBrowsingTheCatalog(Actor actor) {
        actor.attemptsTo(
                Navigate.toTheCatalogePage()
        );
    }

    @When("{actor} adds the following items to the cart:")
    public void AddsTheFollowingItemsToTheCart(Actor actor, List<String> items) {
        cartItems = items;
        items.forEach(
                item -> actor.attemptsTo(
                        AddToCard.itemCalled(item)
                )
        );
    }

    @Then("the shopping cart count should be {string}")
    public void theShoppingCartCountShouldBe(String expectedCount) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(SHOPPING_CART_BADGE).hasText(expectedCount)
        );
    }

    @And("the items should appear in the cart")
    public void theItemsShouldAppearInTheCart() {
        theActorInTheSpotlight().attemptsTo(

                Navigate.toTheShoppingaCart(),
                Ensure.thatTheAnswersTo(Text.ofEach(".inventory_item_name")).containsElementsFrom(cartItems)
        );
    }
}

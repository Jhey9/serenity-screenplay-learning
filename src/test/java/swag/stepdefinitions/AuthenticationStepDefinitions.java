package swag.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import swag.models.SwagUser;
import swag.tasks.Navigate;
import swag.tasks.authentication.Login;

import static swag.userinterfaces.ProductsUserInterface.TITLE;

public class AuthenticationStepDefinitions {

    @Given("{actor} is on the login page")
    public void on_the_login_page(Actor actor) {
        actor.attemptsTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("{actor} logs in with valid credentials")
    public void logs_in_with_valid_credentials(Actor actor) {

        actor.attemptsTo(
                Login.asA(SwagUser.STANDARD_USER)
        );
    }

    @Then("{actor} should be presented with the product catalog")
    public void he_should_be_presented_with_the_product_catalog(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TITLE).hasText("PRODUCTS")
        );
    }

    @Given("{actor} has logged on to the application")
    public void colin_has_logged_on_to_the_application(Actor actor) {

        actor.attemptsTo(
                Navigate.toTheLoginPage(),
                Login.asA(SwagUser.STANDARD_USER)
        );
    }
}

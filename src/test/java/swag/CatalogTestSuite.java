package swag;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        publish = true,
        plugin = {"pretty"},
        features = "src/test/resources/features/cart/"

)
public class CatalogTestSuite {
}

package swag.tasks.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import swag.models.SwagUser;

public class Login {

    public static Performable asA(SwagUser standardUser) {
        return Task.where("{0} logins in as a" + standardUser,
                Enter.theValue(standardUser.username).into("#user-name"),
                Enter.theValue(standardUser.password).into("#password"),
                Click.on(Button.withText("Login"))
        );
    }
}

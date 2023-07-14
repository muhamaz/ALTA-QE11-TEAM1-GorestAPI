package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeleteTodosSteps {
    @Steps
    GorestAPI gorestAPI;
    @Given("DELETE todos with valid id {int}")
    public void deleteTodosWithValidId(int id) {
        gorestAPI.deleteTodos(id);
    }

    @When("Send request DELETE todos")
    public void sendRequestDELETETodos() {
        SerenityRest.when()
                .delete(GorestAPI.DELETE_TODOS);
    }

    @Given("DELETE todos with invalid id {int}")
    public void deleteTodosWithInvalidId(int id) {
        gorestAPI.deleteTodos(id);
    }
}

package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class GetSingleTodosSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("GET Single todos with parameter id {int}")
    public void getSingleTodosWithParameterId(int id) {
        gorestAPI.getSingleTodos(id);
    }

    @When("Send request GET Single todos")
    public void sendRequestGETSingleTodos() {
        SerenityRest.when()
                .get(GorestAPI.GET_SINGLE_TODOS);
    }

}

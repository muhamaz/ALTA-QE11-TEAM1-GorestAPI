package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;


public class DeleteUserSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("DELETE User with valid parameter id {int}")
    public void deleteUserWithValidParameterId(int id) {
        gorestAPI.deleteUser(id);
    }

    @When("Send request DELETE User")
    public void sendRequestDELETEUser() {
        SerenityRest.when()
                .delete(GorestAPI.DELETE_USER);
    }
}

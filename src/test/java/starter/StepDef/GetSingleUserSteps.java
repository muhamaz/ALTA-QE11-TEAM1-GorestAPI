package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class GetSingleUserSteps {

    @Steps
    GorestAPI gorestAPI;

    @Given("GET Single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        gorestAPI.getSingleUser(id);
    }

    @When("Send request GET Single user")
    public void sendRequestGETSingleUser() {
        SerenityRest.when()
                .get(GorestAPI.GET_SINGLE_USERS);
    }

    @Given("GET Single user with unregistered parameter id {int}")
    public void getSingleUserWithUnregisteredParameterId(int id) {
        gorestAPI.getSingleUser(id);
    }

    @Given("GET Single user with invalid parameter id {string}")
    public void getSingleUserWithInvalidParameterId(String id) {
        gorestAPI.getSingleUserInvalidParam(id);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }
}

package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;

import java.io.File;


public class GetListTodosSteps {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get list todos with valid parameter {string}")
    public void getListTodosWithValidParameter(String path) {
        gorestAPI.setGetListUsers(path);
    }
    @When("Send get list todos")
    public void sendGetListTodos() {
        SerenityRest.when().get(GorestAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Validate with JSON Schema valid parameter")
    public void validateWithJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_TODOS+"/GetListTodosSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get list todos with unvalid parameter {string}")
    public void getListTodosWithUnvalidParameter(String path) {
        gorestAPI.setGetListUsers(path);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate with JSON Schema unvalid parameter")
    public void validateWithJSONSchemaUnvalidParameter() {
        File json = new File(Constants.JSON_SCHEMA_TODOS+"/GetListTodosUnvalidParamSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

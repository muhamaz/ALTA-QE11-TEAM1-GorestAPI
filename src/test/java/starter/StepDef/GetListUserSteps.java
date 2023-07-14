package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;

import java.io.File;

public class GetListUserSteps {

    @Steps
    GorestAPI gorestAPI;

    @Given("GET list user with valid path {string}")
    public void getListUserWithValidPath(String path) {
        gorestAPI.getListUser(path);
    }

    @When("Send request GET list user")
    public void sendRequestGETListUser() {
        SerenityRest.when()
                .get(GorestAPI.GET_LIST_USERS);
    }

    @And("Validate user feature with JSON Schema {string}")
    public void validateWithJSONSchema(String jsonSchName) {
        File jsonSch = new File(Constants.JSON_SCHEMA_USERS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSch));
    }

    @Given("GET list user with invalid path {string}")
    public void getListUserWithInvalidPath(String path) {
        gorestAPI.getListUser(path);
    }
}

package starter.StepDef;

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

public class GetListCommentSteps {

    @Steps
    GorestAPI gorestAPI;

    @Given("GET list comment with valid path {string}")
    public void getListCommentWithValidPath(String path) {
        gorestAPI.getListComment(path);
    }

    @When("Send request GET list comment")
    public void sendRequestGETListComment() {
        SerenityRest.when()
                .get(GorestAPI.GET_LIST_COMMENTS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Given("GET list comment with invalid path {string}")
    public void getListCommentWithInvalidPath(String path) {
        gorestAPI.getListComment(path);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Validate comment feature with JSON Schema {string}")
    public void validateWithJSONSchema(String jsonSchName) {
        File jsonSch = new File(Constants.JSON_SCHEMA_COMMENTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSch));
    }
}

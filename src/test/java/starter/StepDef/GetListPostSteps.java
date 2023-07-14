package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;

import java.io.File;

public class GetListPostSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("GET list post with valid path {string}")
    public void getListPostWithValidPath(String path) {
        gorestAPI.getListPost(path);
    }

    @When("Send request GET list post")
    public void sendRequestGETListPost() {
        SerenityRest.when()
                .get(GorestAPI.GET_LIST_POSTS);
    }

    @And("Validate post feature with JSON Schema {string}")
    public void validatePostFeatureWithJSONSchema(String jsonSchName) {
        File jsonSch = new File(Constants.JSON_SCHEMA_POSTS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSch));
    }
}

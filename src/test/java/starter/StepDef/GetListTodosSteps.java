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

public class GetListTodosSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("GET list user with parameter {string}")
    public void getListUserWithParameter(String param) {
        gorestAPI.getListTodos(param);
    }

    @When("Send request GET list todos")
    public void sendRequestGETListTodos() {
        SerenityRest.when()
                .get(GorestAPI.GET_LIST_TODOS);
    }

    @And("Validate todos feature with JSON Schema {string}")
    public void validateTodosFeatureWithJSONSchema(String jsonSchName) {
        File jsonSch = new File(Constants.JSON_SCHEMA_TODOS + ""+jsonSchName+"");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSch));
    }

}

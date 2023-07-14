package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateTodosSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("POST Create new todos with id {int} and JSON {string}")
    public void postCreateNewTodosWithIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_TODOS + ""+jsonName+"");
        gorestAPI.postCreateTodos(id, json);
    }

    @When("Send request POST Create new todos")
    public void sendRequestPOSTCreateNewTodos() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_NEW_TODOS);
    }

    @And("Response body should be show error message {string}")
    public void responseBodyShouldBeShowErrorMessage(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_UPDATE_TODOS, equalTo(errorMessage));
    }

}

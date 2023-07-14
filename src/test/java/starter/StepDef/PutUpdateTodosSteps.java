package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import java.io.File;
import java.security.SecureRandom;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateTodosSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("PUT Update todos with id {int} and JSON {string}")
    public void putUpdateTodosWithIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_TODOS + ""+jsonName+"");
        gorestAPI.putUpdateTodos(id, json);
    }

    @When("Send request PUT Update todos")
    public void sendRequestPUTUpdateTodos() {
        SerenityRest.when()
                .put(GorestAPI.PUT_UPDATE_TODOS);
    }

    @And("Response body should be display errr msg {string}")
    public void responseBodyShouldBeDisplayErrrMsg(String error) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_UPDATE_USER, equalTo(error));
    }

    @And("Response body should be display err msge {string}")
    public void responseBodyShouldBeDisplayErrMsge(String error) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_CREATE_TODOS, equalTo(error));
    }
}

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

import static org.hamcrest.Matchers.equalTo;

public class PostCreateUserSteps {

    @Steps
    GorestAPI gorestAPI;

    @Given("POST Create user with valid JSON {string}")
    public void postCreateUserWithValidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY_USERS + ""+jsonName+"");
        gorestAPI.postCreateUser(json);
    }

    @When("Send request POST Create user")
    public void sendRequestPOSTCreateUser() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_USERS);
    }

    @Given("POST Create user with invalid JSON {string}")
    public void postCreateUserWithInvalidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY_USERS + ""+jsonName+"");
        gorestAPI.postCreateUser(json);
    }

    @And("Response body should be display error mesage {string}")
    public void responseBodyShouldBeDisplayErrorMesage(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_CREATE_USERS, equalTo(errorMessage));
    }
}

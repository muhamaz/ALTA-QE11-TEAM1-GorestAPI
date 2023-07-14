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

public class PutUpdateUserSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("Given PUT Update user with JSON {string} and parameter id {int}")
    public void givenPUTUpdateUserWithJSONAndParameterId(String jsonName, int id) {
        File json = new File(Constants.REQ_BODY_USERS + ""+jsonName+"");
        gorestAPI.putUpdateUser(id, json);
    }

    @When("Send request PUT Update user")
    public void sendRequestPUTUpdateUser() {
        SerenityRest.when()
                .put(GorestAPI.PUT_UPDATE_USERS);
    }

    @And("Response body id should be id {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.and()
                .body(GorestResponses.USER_ID, equalTo(id));
    }

    @And("Response body should be display eror mesage {string}")
    public void responseBodyShouldBeDisplayErorMesage(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_UPDATE_USER, equalTo(errorMessage));
    }
}

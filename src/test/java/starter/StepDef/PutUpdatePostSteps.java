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

public class PutUpdatePostSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("PUT Update post with id {int} and JSON {string}")
    public void putUpdatePostWithIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_POSTS + ""+jsonName+"");
        gorestAPI.putUpdateComment(id, json);
    }

    @When("Send request PUT Update post")
    public void sendRequestPUTUpdatePost() {
        SerenityRest.when()
                .put(GorestAPI.PUT_UPDATE_POSTS);
    }

    @And("Response body should be display err msg {string}")
    public void responseBodyShouldBeDisplayErrMsg(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.UPDATE_POST_ERR_INVALID, equalTo(errorMessage));
    }

    @And("Response body should be display eror msg {string}")
    public void responseBodyShouldBeDisplayErorMsg(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.UPDATE_POST_ERR, equalTo(errorMessage));
    }
}

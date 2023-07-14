package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateNewPostSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("POST Create new post with valid parameter id {int} and JSON {string}")
    public void postCreateNewPostWithValidParameterIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_POSTS + ""+jsonName+"");
        gorestAPI.postCreateNewPost(id, json);
    }

    @When("Send request POST Create new post")
    public void sendRequestPOSTCreateNewPost() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_POSTS);
    }

    @And("Response body user id was {int} and title was {string} and body was {string}")
    public void responseBodyUserIdWasAndTitleWasAndBodyWas(int id, String title, String body) {
        SerenityRest.and()
                .body(GorestResponses.POST_USERID, equalTo(id))
                .body(GorestResponses.POST_TITLE, equalTo(title))
                .body(GorestResponses.POST_BODY, equalTo(body));
    }

    @And("Response body should be display err message {string}")
    public void responseBodyShouldBeDisplayErrMessage(String errorMessage) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_CREATE_POST_INVALID, equalTo(errorMessage));
    }
}

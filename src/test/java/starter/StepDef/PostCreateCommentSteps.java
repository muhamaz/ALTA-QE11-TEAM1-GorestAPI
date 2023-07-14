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

public class PostCreateCommentSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("POST Create new comment with post id {int} and JSON {string}")
    public void postCreateNewCommentWithPostIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_COMMENTS + ""+jsonName+"");
        gorestAPI.postCreateNewComment(id, json);
    }

    @When("Send request POST Create new comment")
    public void sendRequestPOSTCreateNewComment() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_NEW_COMMENTS);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int stausCode) {
        SerenityRest.then()
                .statusCode(stausCode);
    }

    @And("Response body id was {int} and name was {string} and email {string} and body {string}")
    public void responseBodyIdWasAndNameWasAndEmailAndBody(int id, String name, String email, String body) {
        SerenityRest.and()
                .body(GorestResponses.POST_ID_COMMENT, equalTo(id))
                .body(GorestResponses.NAME_COMMENT, equalTo(name))
                .body(GorestResponses.EMAIL_COMMENT, equalTo(email))
                .body(GorestResponses.BODY_COMMENT, equalTo(body));
    }

    @Then("Status code should be {int} Unprocessable Entity")
    public void statusCodeShouldBeUnprocessableEntity(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body should be display error {string}")
    public void responseBodyShouldBeDisplayError(String errorMsg) {
        SerenityRest.and()
                .body(GorestResponses.ERROR_CREATE_COMMENT, equalTo(errorMsg));
    }
}

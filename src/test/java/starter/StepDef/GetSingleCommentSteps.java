package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;
import starter.gorest.GorestResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleCommentSteps {

    @Steps
    GorestAPI gorestAPI;

    @Given("GET Single comment with parameter id {int}")
    public void getSingleCommentWithParameterId(int id) {
        gorestAPI.getSingleComment(id);
    }

    @When("Send request GET Single comment")
    public void sendRequestGETSingleComment() {
        SerenityRest.when()
                .get(GorestAPI.GET_SINGLE_COMMENTS);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and()
                .body(GorestResponses.COMMENT_ID, equalTo(id));
    }

    @And("Response body should be display error message {string}")
    public void responseBodyShouldBeDisplayErrorMessage(String errorMsg) {
        SerenityRest.and()
                .body(GorestResponses.SINGLE_COMMENT_ERR, equalTo(errorMsg));
    }


}

package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeleteCommentSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("DELETE comment with valid id {int}")
    public void deleteCommentWithValidId(int id) {
        gorestAPI.deleteComment(id);
    }

    @When("Send request DELETE comment")
    public void sendRequestDELETEComment() {
        SerenityRest.when()
                .delete(GorestAPI.DELETE_COMMENT);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Given("DELETE comment with invalid id {int}")
    public void deleteCommentWithInvalidId(int id) {
        gorestAPI.deleteComment(id);
    }
}

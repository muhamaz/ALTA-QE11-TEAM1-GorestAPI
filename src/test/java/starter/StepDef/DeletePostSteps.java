package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class DeletePostSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("DELETE post with valid id {int}")
    public void deletePostWithValidId(int id) {
        gorestAPI.deletePost(id);
    }

    @When("Send request DELETE post")
    public void sendRequestDELETEPost() {
        SerenityRest.when()
                .delete(GorestAPI.DELETE_POSTS);
    }

    @Given("DELETE post with invalid id {int}")
    public void deletePostWithInvalidId(int id) {
        gorestAPI.deletePost(id);
    }
}

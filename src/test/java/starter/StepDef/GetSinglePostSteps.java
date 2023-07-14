package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.gorest.GorestAPI;

public class GetSinglePostSteps {
    @Steps
    GorestAPI gorestAPI;
    @Given("GET Single post with valid post id {int}")
    public void getSinglePostWithValidPostId(int id) {
        gorestAPI.getSinglePost(id);
    }

    @When("Send request GET Single post")
    public void sendRequestGETSinglePost() {
        SerenityRest.when()
                .get(GorestAPI.GET_SINGLE_POSTS);
    }

    @Given("GET Single post with invalid post id {string}")
    public void getSinglePostWithInvalidPostId(String id) {
        gorestAPI.getSinglePostinvalid(id);
    }
}

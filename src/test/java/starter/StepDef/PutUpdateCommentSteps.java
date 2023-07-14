package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constants;
import starter.gorest.GorestAPI;

import java.io.File;

public class PutUpdateCommentSteps {

    @Steps
    GorestAPI gorestAPI;
    @Given("PUT Update comment with id {int} and JSON {string}")
    public void putUpdateCommentWithIdAndJSON(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY_COMMENTS + ""+jsonName+"");
        gorestAPI.putUpdateComment(id, json);
    }

    @When("Send request PUT Update comment")
    public void sendRequestPUTUpdateComment() {
        SerenityRest.when()
                .put(GorestAPI.PUT_UPDATE_COMMENTS);
    }
}

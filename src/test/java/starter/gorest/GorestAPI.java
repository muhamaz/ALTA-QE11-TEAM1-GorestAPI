package starter.gorest;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

public class GorestAPI {
    public static String GET_LIST_USERS =  Constants.BASE_URL+"/public/v2/{path}";
    @Step("Get list users")
    public void setGetListUsers(String path) {
        SerenityRest.given().pathParam("path", path);

    }

}

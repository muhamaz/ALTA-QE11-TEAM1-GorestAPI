package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class GorestAPI {

    public static String TOKEN = "6b40c85bb6cae547d13fb7a09b2db6c77c970adcfb8a6deb9df9cd8d3e7b8720";
    public static String GET_LIST_COMMENTS = Constants.BASE_URL + "/public/v2/{path}";
    public static String GET_SINGLE_COMMENTS = Constants.BASE_URL + "/public/v2/comments/{id}";
    public static String POST_CREATE_NEW_COMMENTS = Constants.BASE_URL + "/public/v2/posts/{id}/comments";


    @Step("GET List Comment")
    public void getListComment(String path){
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Get Single Comment")
    public void getSingleComment(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Create New Comment")
    public void postCreateNewComment(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

}

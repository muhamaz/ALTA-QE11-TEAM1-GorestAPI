package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class GorestAPI {

    public static String TOKEN = "6b40c85bb6cae547d13fb7a09b2db6c77c970adcfb8a6deb9df9cd8d3e7b8720";

    public static String GET_LIST_TODOS = Constants.BASE_URL + "/public/v2/{param}";
    public static String GET_SINGLE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";
    public static String POST_CREATE_NEW_TODOS = Constants.BASE_URL + "/public/v2/users/{id}/todos";
    public static String PUT_UPDATE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";
    public static String DELETE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";


    @Step("Get list todos")
    public void getListTodos(String param){
        SerenityRest.given()
                .pathParam("param", param);
    }

    @Step("Get single todos")
    public void getSingleTodos(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }


    @Step("Post Create Todos")
    public void postCreateTodos(int id ,File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update Todos")
    public void putUpdateTodos(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteTodos(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

}

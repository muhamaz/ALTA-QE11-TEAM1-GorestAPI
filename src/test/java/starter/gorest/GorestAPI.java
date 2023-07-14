package starter.gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class GorestAPI {


    /**
     * USER
     */
    public static String TOKEN = "6b40c85bb6cae547d13fb7a09b2db6c77c970adcfb8a6deb9df9cd8d3e7b8720";
    public static String GET_LIST_USERS = Constants.BASE_URL + "/public/v2/{path}";
    public static String GET_SINGLE_USERS = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String POST_CREATE_USERS = Constants.BASE_URL + "/public/v2/users";
    public static String PUT_UPDATE_USERS = Constants.BASE_URL + "/public/v2/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/public/v2/users/{id}";

    /**
     * POST
     */
    public static String GET_LIST_POSTS = Constants.BASE_URL + "/public/v2/{path}";
    public static String GET_SINGLE_POSTS = Constants.BASE_URL + "/public/v2/users/{id}/posts";
    public static String POST_CREATE_POSTS = Constants.BASE_URL + "/public/v2/users/{id}/posts";
    public static String PUT_UPDATE_POSTS = Constants.BASE_URL + "/public/v2/posts/{id}";
    public static String DELETE_POSTS = Constants.BASE_URL + "/public/v2/posts/{id}";

    /**
     * COMMENT
     */
    public static String GET_LIST_COMMENTS = Constants.BASE_URL + "/public/v2/{path}";
    public static String GET_SINGLE_COMMENTS = Constants.BASE_URL + "/public/v2/comments/{id}";
    public static String POST_CREATE_NEW_COMMENTS = Constants.BASE_URL + "/public/v2/posts/{id}/comments";
    public static String PUT_UPDATE_COMMENTS = Constants.BASE_URL + "/public/v2/comments/{id}";
    public static String DELETE_COMMENT = Constants.BASE_URL + "/public/v2/comments/{id}";

    /**
     * TODOS
     */
    public static String GET_LIST_TODOS = Constants.BASE_URL + "/public/v2/{param}";
    public static String GET_SINGLE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";
    public static String POST_CREATE_NEW_TODOS = Constants.BASE_URL + "/public/v2/users/{id}/todos";
    public static String PUT_UPDATE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";
    public static String DELETE_TODOS = Constants.BASE_URL + "/public/v2/todos/{id}";

    /**
     * USER
     */
    @Step("Get list user")
    public void getListUser(String path){
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Get single user invalid param")
    public void getSingleUserInvalidParam(String id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Post Create User")
    public void postCreateUser(File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    /**
     * POST
     */
    @Step("Get list post")
    public void getListPost(String path){
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Get Single post")
    public void getSinglePost(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Get Single post invalid")
    public void getSinglePostinvalid(String id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    @Step("Post Create new post")
    public void postCreateNewPost(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update post")
    public void putUpdatePost(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Post")
    public void deletePost(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    /**
     *
     * COMMENT
     */
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

    @Step("Put Update Comment")
    public void putUpdateComment(int id, File json){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Comment")
    public void deleteComment(int id){
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
    }

    /**
     * TODOS
     */
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

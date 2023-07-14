package starter.gorest;

public class GorestResponses {


    public static String ERROR_UPDATE_USER = "message";
    public static String ERROR_CREATE_TODOS = "[0].message";
    public static String ERROR_UPDATE_TODOS = "message";



    /**
     * USER
     */
    public static String ERROR_CREATE_USERS = "[0].message";
    public static String USER_ID = "id";
    public static String ERROR_UPDATE_USER = "message";

    /**
     * POST
     */
    public static String ERROR_CREATE_POST_INVALID = "[0].message";
    public static String POST_USERID = "user_id";
    public static String POST_TITLE = "title";
    public static String POST_BODY = "body";
    public static String UPDATE_POST_ERR_INVALID = "message";
    public static String UPDATE_POST_ERR = "[0].message";


    /**
     * COMMENT
     */
    public static String COMMENT_ID = "id";
    public static String SINGLE_COMMENT_ERR = "message";
    public static String POST_ID_COMMENT = "post_id";
    public static String NAME_COMMENT = "name";
    public static String EMAIL_COMMENT = "email";
    public static String BODY_COMMENT = "body";
    public static String ERROR_CREATE_COMMENT = "[0].message";

    /**
     * TODOS
     */
    public static String ERROR_CREATE_TODOS = "[0].message";
    public static String ERROR_UPDATE_TODOS = "message";



}

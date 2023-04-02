package tests.api;

import config.ProjectCredentialsConfig;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import tests.api.models.CreatePostModelJson;
import tests.api.models.editPostModels.EditPostModel;
import tests.api.userApi.CreatePostApi;
import tests.api.userApi.DeletePostApi;
import tests.api.userApi.GeneralApi;

public class TestDataApi {
    protected final static GeneralApi GENERAL_API = new GeneralApi();
    protected final static CreatePostApi CREATE_POST_API = new CreatePostApi();
    protected final static DeletePostApi DELETE_POST_API = new DeletePostApi();
    public static final ProjectCredentialsConfig config = ConfigFactory.create(ProjectCredentialsConfig.class, System.getProperties());
    static CreatePostModelJson createPostModelJson;
    static EditPostModel editPostModel;
    protected final static String username = config.getUsername();
    protected final static String password = config.getPassword();
    protected final static String clientId = config.getClientId();
    protected final static String clientSecret = config.getClientSecret();
    protected static String accessToken;
    protected static Response response;
}

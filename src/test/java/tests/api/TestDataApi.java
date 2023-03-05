package tests.api;

import config.ProjectCredentialsConfig;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import tests.api.models.CreatePostModelJson;
import tests.api.models.editPostModels.EditPostModel;
import tests.api.pages.CreatePostPage;
import tests.api.pages.DeletePostPage;
import tests.api.pages.GeneralPage;

public class TestDataApi {
    protected final static GeneralPage generalPage = new GeneralPage();
    protected final static CreatePostPage createPostPage = new CreatePostPage();
    protected final static DeletePostPage deletePostPage = new DeletePostPage();
    public static final ProjectCredentialsConfig config = ConfigFactory.create(ProjectCredentialsConfig.class, System.getProperties());
    static CreatePostModelJson createPostModelJson;
    EditPostModel editPostModel;
    protected final static String username = config.getUsername();
    protected final static String password = config.getPassword();
    protected final static String clientId = config.getClientId();
    protected final static String clientSecret = config.getClientSecret();
    protected static String accessToken;
    protected static Response response;
}

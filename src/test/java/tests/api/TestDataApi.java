package tests.api;

import io.restassured.response.Response;
import tests.api.models.CreatePostModelJson;
import tests.api.models.editPostModels.EditPostModel;
import tests.api.pages.CreatePostPage;
import tests.api.pages.DeletePostPage;
import tests.api.pages.GeneralPage;

public class TestDataApi {
    protected final static GeneralPage generalPage = new GeneralPage();
    protected final static CreatePostPage createPostPage = new CreatePostPage();
    protected final static DeletePostPage deletePostPage = new DeletePostPage();
    static CreatePostModelJson createPostModelJson;
    EditPostModel editPostModel;
    protected final static String username = "Own_Faithlessness596";
    protected final static String password = "2Password!";
    protected final static String clientId = "D_LVmt_CTKwjw7Zr5apjlg";
    protected final static String clientSecret = "jnxPoRui8WuxTAUcvK6MlYszG46I1A";
    protected static String accessToken;
    protected static Response response;
}

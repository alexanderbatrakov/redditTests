package tests.api;

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
    protected final static String username = "Alex211621";
    protected final static String password = "swimmer88151";
    protected final static String clientId = "Du1kpj218PIM_i16bZuoWQ";
    protected final static String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";
}

package tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import tests.api.pages.CreatePostPage;
import tests.api.pages.GeneralPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePostTests extends TestDataApi {
    CreatePostPage createPostPage = new CreatePostPage();
    GeneralPage generalPage = new GeneralPage();
    String username = "Alex211621";
    String password = "swimmer88151";
    String clientId = "Du1kpj218PIM_i16bZuoWQ";
    String clientSecret = "WI0dNXFzCQ0jB7a6onK0WXWiP7NUEg";

   @Test
   void CreatePostSuccessfulTest (){
       String accessToken = generalPage.getAccessToken(username, password, clientId, clientSecret);
       createPostModelJson = createPostPage.createPost(accessToken, username);

       assertThat(createPostModelJson.getJson().getData().getUrl()).isNotEmpty();
       assertThat(createPostModelJson.getJson().getData().getId()).isNotEmpty();
       assertThat(createPostModelJson.getJson().getData().getName()).isNotEmpty();
   }
    @Test
    void CreatePostIncorrectTokenTest (){
        String accessToken = "fdggdfgdf";
        Response response = createPostPage.createPostError(accessToken, username);
        int statusCode = response.getStatusCode();
        assertEquals(401, statusCode);
    }
}

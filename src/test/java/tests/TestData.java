package tests;

import com.github.javafaker.Faker;
import config.ProjectCredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Locale;

public class TestData {
    private static final ProjectCredentialsConfig config = ConfigFactory.create(ProjectCredentialsConfig.class, System.getProperties());
    static Faker faker = new Faker(new Locale("en"));
    //ui
    public static String login = config.getLogin();
    public static String password = config.getPassword();
    public static String shortLogin = " ";
    protected final static int minLengthOfLogin = 3;
    protected final static int maxLengthOfLogin = 20;

    public static String wrongLogin() {
        String wrongLoginPicker = faker.name().username();
        while (wrongLoginPicker.length() <= minLengthOfLogin && wrongLoginPicker.length() <= maxLengthOfLogin) {
            wrongLoginPicker = faker.name().username();
        }
        return wrongLoginPicker;
    }

    public static String wrongPassword = faker.internet().password();

    public static String shortLogin() {
        String shortLoginPicker = faker.name().firstName();
        while (shortLoginPicker.length() >= minLengthOfLogin) {
            shortLoginPicker = faker.name().firstName();

        }
        return shortLoginPicker;
    }

    public static String longLogin() {
        String longLoginPicker = faker.name().name();
        while (longLoginPicker.length() <= maxLengthOfLogin) {
            longLoginPicker = faker.name().name();

        }
        return longLoginPicker;
    }
    //
    //API
    public static String title = faker.book().title();
    public static String titleType = "self";
}



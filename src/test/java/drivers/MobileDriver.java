package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static tests.TestData.mobileConfig;

public class MobileDriver implements WebDriverProvider {

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName("Android")
                .setDeviceName(mobileConfig.getDeviceName())
                .setPlatformVersion(mobileConfig.getOsVersion())
                .setApp(getAppPath())
                .setAppPackage("com.reddit.frontpage")
                .setAppActivity("com.reddit.frontpage.StartActivity");

        return new AndroidDriver(getDeviceUrl(), options);

    }

    private String getAppPath() {
        String appPath = "src/test/resources/apps/Reddit+2023.08.0.798718.apk";
        File app = new File(appPath);
        return app.getAbsolutePath();
    }

    public static URL getDeviceUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

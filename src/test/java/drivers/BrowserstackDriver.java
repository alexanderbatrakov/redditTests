package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ProjectCredentialsConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static tests.TestData.mobileConfig;

public class BrowserstackDriver implements WebDriverProvider {
    private static final ProjectCredentialsConfig config = ConfigFactory.create(ProjectCredentialsConfig.class, System.getProperties());
    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);


        mutableCapabilities.setCapability("browserstack.user", config.getBSlogin());
        mutableCapabilities.setCapability("browserstack.key", config.getBSpassword());

        mutableCapabilities.setCapability("app", mobileConfig.getAppUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", mobileConfig.getDeviceName());
        mutableCapabilities.setCapability("os_version", mobileConfig.getOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(mobileConfig.getRemoteBSUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${env}.properties"})

public interface ProjectConfig extends Config {

    @Key("browserSize")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("isRemote")
    Boolean getIsRemote();

    @Key("remoteUrl")
    String getSelenideUrl();

    @Key("appUrl")
    String getAppUrl();

    @Key("remoteBSUrl")
    String getRemoteBSUrl();
    @Key("deviceName")
    String getDeviceName();

    @Key("osVersion")
    String getOsVersion();

    @Key("environment")
    String getEnvironment();
}



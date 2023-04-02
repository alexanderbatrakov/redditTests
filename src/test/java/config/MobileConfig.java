package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:${env}.properties"})

public interface MobileConfig extends Config {

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



package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})

public interface ProjectCredentialsConfig extends Config {

    @Key("username")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("clientId")
    String getClientId();

    @Key("clientSecret")
    String getClientSecret();

    @Key("BSlogin")
    String getBSlogin();

    @Key("BSpassword")
    String getBSpassword();
}

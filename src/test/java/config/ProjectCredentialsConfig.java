package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:credentials.properties"})

public interface ProjectCredentialsConfig extends Config{

    @Key ("login")
    String getLogin();

    @Key ("password")
    String getPassword();

}

package homework.config.web;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:homework/${env}.properties"})
public interface WebConfig extends Config {

    @Key("browserName")
    BrowserName browserName();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    String browserSize();

    @Key("isRemote")
    boolean isRemote();

    @Key("remoteURL")
    String remoteURL();
}

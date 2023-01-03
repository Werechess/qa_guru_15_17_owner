package owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigOld {

    // ./gradlew clean test -DbaseURL=https://gitlab.com -Dbrowser=FIREFOX

    public String getBaseURL() {
        String baseURL = System.getProperty("baseURL");
        if (Objects.isNull(baseURL)) {
            baseURL = "https://github.com";
        }
        return baseURL;
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser", "CHROME");
        return Browser.valueOf(browser);
    }

    public URL getRemoteURL() throws MalformedURLException {
        String remoteURL = System.getProperty("remoteURL");
        if (Objects.isNull(remoteURL)) {
            remoteURL = "http://localhost";
        }
        return new URL(remoteURL);
    }
}

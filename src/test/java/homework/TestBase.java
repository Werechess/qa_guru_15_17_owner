package homework;

import homework.config.ConfigReader;
import homework.config.ProjectConfiguration;
import homework.config.web.WebConfig;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    public static void setUp() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig);
        projectConfiguration.webConfig();
    }
}

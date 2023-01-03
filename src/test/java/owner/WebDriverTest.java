package owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebDriverTest {

    private WebDriver driver;

    @Test
    void testGitHub1() {
        // тело выполнения теста
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

    @BeforeEach
    public void startDriver() {
        // подготовка Driver
        driver = new WebDriverProvider().get();
    }

    @AfterEach
    public void stopDriver() {
        // выход из Driver
        driver.quit();
    }
}

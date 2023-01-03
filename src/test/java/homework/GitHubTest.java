package homework;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GitHubTest extends TestBase {

    @Test
    @Tag("homework")
    void testGitHub() {
        open("https://github.com");
        $("h1").shouldHave(text("Let’s build from here"));
    }
}

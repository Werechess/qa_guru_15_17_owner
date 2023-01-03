package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.AuthConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class AuthTest {

    @Test
    void testAuthClasspath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("someuser");
        assertThat(config.password()).isEqualTo("123");
    }

    @Test
    void testAuthWithSecretFile() throws IOException {
        String content = "username=secret-user\npassword=secret-password";
        Path secret = Paths.get("/tmp/secret.properties");
        // works in Jenkins
        Files.write(secret, content.getBytes(StandardCharsets.UTF_8));

        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());
        assertThat(config.username()).isEqualTo("secret-user");
        assertThat(config.password()).isEqualTo("secret-password");

        Files.delete(secret);
    }
}

package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.Browser;
import owner.config.TypeConfig;

import static org.assertj.core.api.Assertions.assertThat;

class TypeTest {

    @Test
    void testInteger() {
        System.setProperty("integer", "10");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(10);
    }

    @Test
    void testDouble() {
        System.setProperty("double", "10.10");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(10.10);
    }

    @Test
    void testBoolean() {
        System.setProperty("boolean", "true");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getBoolean()).isTrue();
    }

    @Test
    void testEnum() {
        System.setProperty("enum", "CHROME");
        TypeConfig config = ConfigFactory.create(TypeConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.CHROME);
    }
}

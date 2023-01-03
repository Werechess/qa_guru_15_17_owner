package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.MobileConfig;

import static org.assertj.core.api.Assertions.assertThat;

class MobileTest {

    @Test
    void testMobile() {
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("iPhone 13 Pro");
        assertThat(config.getPlatformName()).isEqualTo("iOS");
        assertThat(config.getPlatformVersion()).isEqualTo("13");
    }

    @Test
    void testMobileWithSystemOverride() {
        System.setProperty("platform.version", "12");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("iPhone 13 Pro");
        assertThat(config.getPlatformName()).isEqualTo("iOS");
        assertThat(config.getPlatformVersion()).isEqualTo("12");
    }

    @Test
    void testMobileWithTemplateProperty() {
        System.setProperty("device", "android");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.getDeviceName()).isEqualTo("Google Pixel");
        assertThat(config.getPlatformName()).isEqualTo("Android");
        assertThat(config.getPlatformVersion()).isEqualTo("6");
    }
}

package pt.aubay.cv.app.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Application {

    private Properties mailConfig;

    public Properties getMailConfig() {

        if (mailConfig == null) {

            final InputStream stream = Application.class.getResourceAsStream("/application.properties");

            if (stream == null) {

                throw new RuntimeException("No properties!");
            }

            try {

                this.mailConfig = new Properties();

                this.mailConfig.load(stream);

            } catch (final IOException e) {

                throw new RuntimeException("Configuration could not be loaded");

            }
        }
        return mailConfig;
    }
}
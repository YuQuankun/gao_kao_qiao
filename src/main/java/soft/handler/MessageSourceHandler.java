package soft.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Locale;


/**
 * @author kun_mi
 */
@Component
public class MessageSourceHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MessageSourceHandler.class);

    public String getMessage(String messageKey) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames("/exception/error_code");

        String message = "";
        try {
            Locale locale = Locale.CHINA;
            message = messageSource.getMessage(messageKey, null, locale);
        } catch (Exception e) {
            LOG.error("parse message error! ", e);
        }
        return message;
    }

}

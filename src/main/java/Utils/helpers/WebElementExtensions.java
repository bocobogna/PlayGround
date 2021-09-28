package Utils.helpers;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class WebElementExtensions {
    //logger
    static Logger log = LoggerFactory.getLogger(WebElementExtensions.class);

    public static void getElement(SelenideElement element) {
        try {
            if (isElementDisplayed(element)) {
                assertThat(element.exists()).isEqualTo(true);
                log.info("Element is displayed: {}", element);
            } else {
                assertThat(element.exists()).isEqualTo(false);
                log.info("Element is not displayed: {}", element);
            }
        } catch (NoSuchElementException ex) {
            log.error("Expected NoSuchElementExceptions: {}", ex.getMessage());
        }
    }

    public static boolean isElementDisplayed(SelenideElement element) {
        boolean ifExists = true;
        try {
            if (element.isDisplayed())
                return ifExists;
        } catch (NoSuchElementException ignore) {
            ifExists = false;
        }
        return ifExists;
    }
}

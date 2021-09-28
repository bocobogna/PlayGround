package Utils.helpers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.ElementNotVisibleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Utils.helpers.JSExecutorHelper.highlight;

public class WebElementHelper {

    //logger
    static Logger log = LoggerFactory.getLogger(WebElementHelper.class);

    public static SelenideElement clickOnElement(SelenideElement element) {
        try {
            highlight(element);
            element.click();
            log.info("Click on Element {}", element);
            return element;
        } catch (ElementNotVisibleException ex) {
            log.error("Something went wrong to click element: {} - Exception: {}", element, ex.getMessage());
        }
        return element;
    }

    public static void scrollToElement(SelenideElement element) {
        try {
            element.scrollTo();
            highlight(element);
            log.info("Scroll To Element: {}", element);
        } catch (ElementNotVisibleException ex) {
            log.error("Something went wrong to move to element: {} - Exception: {}", element, ex.getMessage());
        }
    }
}

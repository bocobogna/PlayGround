package Utils.helpers;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JSExecutorHelper {

    //logger
    static Logger log = LoggerFactory.getLogger(JSExecutorHelper.class);

    public static <T extends SelenideElement> T highlight(T element) {
        try {
            for (int i = 0; i < 2; i++) {
                executeJavaScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid green;');", element);
                executeJavaScript("arguments[0].setAttribute('style', '');", element);
            }
            return element;
        } catch (NoSuchElementException ex) {
            log.error("Something went wrong to highlight Element: {} - Exception: {}", element, ex.getMessage());
        }
        return element;
    }

}

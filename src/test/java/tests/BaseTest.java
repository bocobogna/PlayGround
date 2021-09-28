package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

@ExtendWith({ScreenShooterExtension.class})
public abstract class BaseTest {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true);

    //logger
    Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void setup() {

        Selenide.closeWebDriver();

        Configuration.timeout = 7000;
        Configuration.baseUrl = "https://cnn.com";
        Configuration.reportsFolder = "target/screenshots";
        ScreenShooter.failedTests().succeededTests();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "disable-popup-blocking", "test-type");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}

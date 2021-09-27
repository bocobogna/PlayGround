package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.ScreenShooter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    //logger
    Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public static void setup() {

        Selenide.closeWebDriver();

        Configuration.timeout = 7000;
        Configuration.baseUrl = "https://cnn.com";
        Configuration.reportsFolder = "target/reports";
        ScreenShooter.failedTests().succeededTests();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "disable-popup-blocking", "test-type");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterClass
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}

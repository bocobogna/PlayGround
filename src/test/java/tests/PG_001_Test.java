package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.NewsPage;

import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class PG_001_Test {

    NewsPage nP = new NewsPage();

    @Test
    public void googleTest() {

        //Config
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://cnn.com";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);

        nP.open().acceptCookies();

        nP.scrollToHeaders();

        List<String> headersList = nP.getBusinessHeaders();
        nP.logInfo("Headers: \n" + headersList);

        List<String> firstHeader = nP.firstHeaderToLetterList();
        nP.logInfo("First header as letters: \n" + firstHeader);

        String firstDuplicate = nP.getFirstDuplicate(firstHeader);
        nP.logInfo("First duplicated letter in one header (case insensitive): \n" + firstDuplicate);

        Set<String> allDuplicates = nP.findDuplicates(firstHeader);
        nP.logInfo("All duplicated letters in one header (case insensitive): \n" + allDuplicates);

        nP.logInfo("All duplicated letters with indexes in one header (case insensitive): \n" + nP.getDuplicatesWithIndexes(firstHeader));

        nP.logInfo("All duplicated letters with counting in one header (case insensitive): \n" + nP.getDuplicatesCount(firstHeader));

        nP.logInfo("Most popular element for letters from one header (case insensitive): \n" + nP.getMostPopularElement(firstHeader));

//        ******************************************************************************************************************************************

        List<String> wordsList = nP.headersToWordsList(headersList);
        nP.logInfo("Headers as list of words: \n" + wordsList);

        String firstDuplicateWorld = nP.getFirstDuplicate(wordsList);
        nP.logInfo("First duplicated word: \n" + firstDuplicateWorld);

        allDuplicates = nP.findDuplicates(wordsList);
        nP.logInfo("All duplicated words in all headers (case insensitive): \n" + allDuplicates);

        nP.logInfo("All duplicated words in all headers with indexes for one header (case insensitive): \n" + nP.getDuplicatesWithIndexes(wordsList));

        nP.logInfo("All duplicated words in all headers with counting for one header (case insensitive): \n" + nP.getDuplicatesCount(wordsList));

        nP.logInfo("Most popular element for words from all headers (case insensitive): \n" + nP.getMostPopularElement(wordsList));

//        ******************************************************************************************************************************************

        List<String> headersAsLetters = nP.headersToLetters(headersList);
        nP.logInfo("Headers as letters: \n" + headersAsLetters);

        String firstLetterDuplicate = nP.getFirstDuplicate(headersAsLetters);
        nP.logInfo("First duplicated letter in all headers (case sensitive): \n" + firstLetterDuplicate);

        allDuplicates = nP.findDuplicates(headersAsLetters);
        nP.logInfo("All duplicated letters in all headers (case sensitive): \n" + allDuplicates);

        nP.logInfo("All duplicated letters in all headers with indexes for all headers (case sensitive): \n" + nP.getDuplicatesWithIndexes(headersAsLetters));

        nP.logInfo("All duplicated letters in all headers with counting for all headers (case sensitive): \n" + nP.getDuplicatesCount(headersAsLetters));

        nP.logInfo("Most popular element for letters from all headers (case sensitive): \n" + nP.getMostPopularElement(headersAsLetters));

        //Close driver
        Selenide.closeWebDriver();
    }
}

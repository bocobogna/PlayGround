package tests;

import org.junit.Test;
import pages.NewsPage;

import java.util.List;
import java.util.Set;

public class PG_001_Test extends BaseTest {

    NewsPage nP = new NewsPage();

    @Test
    public void pgTest() {

        nP.open()
                .acceptCookies();

        nP.scrollToHeaders();

        List<String> headersList = nP.getBusinessHeaders();
        log.info("Headers: \n" + headersList);

        List<String> firstHeader = nP.firstHeaderToLetterList();
        log.info("First header as letters: \n" + firstHeader);

        String firstDuplicate = nP.getFirstDuplicate(firstHeader);
        log.info("First duplicated letter in one header (case insensitive): \n" + firstDuplicate);

        Set<String> allDuplicates = nP.findDuplicates(firstHeader);
        log.info("All duplicated letters in one header (case insensitive): \n" + allDuplicates);

        log.info("All duplicated letters with indexes in one header (case insensitive): \n" + nP.getDuplicatesWithIndexes(firstHeader));

        log.info("All duplicated letters with counting in one header (case insensitive): \n" + nP.getDuplicatesCount(firstHeader));

        log.info("Most popular element for letters from one header (case insensitive): \n" + nP.getMostPopularElement(firstHeader));

//        ******************************************************************************************************************************************

        List<String> wordsList = nP.headersToWordsList(headersList);
        log.info("Headers as list of words: \n" + wordsList);

        String firstDuplicateWorld = nP.getFirstDuplicate(wordsList);
        log.info("First duplicated word: \n" + firstDuplicateWorld);

        allDuplicates = nP.findDuplicates(wordsList);
        log.info("All duplicated words in all headers (case insensitive): \n" + allDuplicates);

        log.info("All duplicated words in all headers with indexes for one header (case insensitive): \n" + nP.getDuplicatesWithIndexes(wordsList));

        log.info("All duplicated words in all headers with counting for one header (case insensitive): \n" + nP.getDuplicatesCount(wordsList));

        log.info("Most popular element for words from all headers (case insensitive): \n" + nP.getMostPopularElement(wordsList));

//        ******************************************************************************************************************************************

        List<String> headersAsLetters = nP.headersToLetters(headersList);
        log.info("Headers as letters: \n" + headersAsLetters);

        String firstLetterDuplicate = nP.getFirstDuplicate(headersAsLetters);
        log.info("First duplicated letter in all headers (case sensitive): \n" + firstLetterDuplicate);

        allDuplicates = nP.findDuplicates(headersAsLetters);
        log.info("All duplicated letters in all headers (case sensitive): \n" + allDuplicates);

        log.info("All duplicated letters in all headers with indexes for all headers (case sensitive): \n" + nP.getDuplicatesWithIndexes(headersAsLetters));

        log.info("All duplicated letters in all headers with counting for all headers (case sensitive): \n" + nP.getDuplicatesCount(headersAsLetters));

        log.info("Most popular element for letters from all headers (case sensitive): \n" + nP.getMostPopularElement(headersAsLetters));
    }
}

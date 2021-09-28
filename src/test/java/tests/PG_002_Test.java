package tests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BracketsPage;

public class PG_002_Test {

    //logger
    Logger log = LoggerFactory.getLogger(PG_002_Test.class);

    BracketsPage bP = new BracketsPage();

    @Test
    public void bgTest() {
        String ex_1 = "(){[a]}";
        String ex_2 = ")({[}]";
        String ex_3 = "((){}[]";
        String ex_4 = "{}{)(]";
        String ex_5 = "noBracketString";

        log.info("Are brackets '{}' balanced? Result: {}", ex_1, bP.isBalancedOnAmount(bP.removeNonBrackets(ex_1)));
        log.info("Are brackets '{}' balanced? Result: {}",ex_2, bP.isBalancedOnAmount(bP.removeNonBrackets(ex_2)));
        log.info("Are brackets '{}' balanced? Result: {}", ex_3, bP.isBalancedOnAmount(bP.removeNonBrackets(ex_3)));
        log.info("Are brackets '{}' balanced? Result: {}", ex_4, bP.isBalancedOnAmount(bP.removeNonBrackets(ex_4)));
        log.info("Are brackets '{}' balanced? Result: {}", ex_5, bP.isBalancedOnAmount(bP.removeNonBrackets(ex_5)));
    }
}

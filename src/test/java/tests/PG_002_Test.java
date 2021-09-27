package tests;

import org.junit.Test;
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

        log.info("Is balanced_1 '" + ex_1 + "' balanced: " + bP.isBalancedOnAmount(bP.removeNonBrackets(ex_1)));
        log.info("Is balanced_2 '" + ex_2 + "' balanced: " + bP.isBalancedOnAmount(bP.removeNonBrackets(ex_2)));
        log.info("Is notBalanced_1 '" + ex_3 + "' balanced: " + bP.isBalancedOnAmount(bP.removeNonBrackets(ex_3)));
        log.info("Is notBalanced_2 '" + ex_4 + "' balanced: " + bP.isBalancedOnAmount(bP.removeNonBrackets(ex_4)));
        log.info("Is notBalanced_3 '" + ex_5 + "' balanced: " + bP.isBalancedOnAmount(bP.removeNonBrackets(ex_5)));
    }
}

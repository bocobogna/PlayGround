package tests;

import org.junit.Test;
import pages.BracketsPage;
import pages.NewsPage;

public class BP_002_Test {

    BracketsPage bP = new BracketsPage();
    NewsPage nP = new NewsPage();

    @Test
    public void bgTest() {
        String balanced_1 = "(){[a]}";
        String balanced_2 = ")({[}]";
        String notBalanced_1 = "((){}[]";
        String notBalanced_2 = "{}{)(]";
        String notBalanced_3 = "noBracketString";

        nP.log("Is balanced_1 '" + balanced_1 + "' balanced: " + bP.isBalanced(bP.removeNonBrackets(balanced_1)));
        nP.log("Is balanced_2 '" + balanced_2 + "' balanced: " + bP.isBalanced(bP.removeNonBrackets(balanced_2)));
        nP.log("Is notBalanced_1 '" + notBalanced_1 + "' balanced: " + bP.isBalanced(bP.removeNonBrackets(notBalanced_1)));
        nP.log("Is notBalanced_2 '" + notBalanced_2 + "' balanced: " + bP.isBalanced(bP.removeNonBrackets(notBalanced_2)));
        nP.log("Is notBalanced_3 '" + notBalanced_3 + "' balanced: " + bP.isBalanced(bP.removeNonBrackets(notBalanced_3)));
    }
}

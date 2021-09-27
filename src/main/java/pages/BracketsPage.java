package pages;

public class BracketsPage {

    public String removeNonBrackets(String rawString) {
        String onlyBrackets = "";
        for (int i = 0; i < rawString.length(); i++) {
            if (rawString.charAt(i) == '(' || rawString.charAt(i) == ')' || rawString.charAt(i) == '[' || rawString.charAt(i) == ']' || rawString.charAt(i) == '{' || rawString.charAt(i) == '}') {
                onlyBrackets = onlyBrackets + rawString.charAt(i);
            }
        }
        return onlyBrackets;
    }

    public boolean isBalancedOnAmount(String toEvaluate) {
        int countOpened = 0;
        int countClosed = 0;

        if ((toEvaluate.length() % 2 != 0) || toEvaluate.length() == 0) {
            return false;
        } else {
            //Count ()
            for (int i = 0; i < toEvaluate.length(); i++) {
                if (toEvaluate.charAt(i) == '(') {
                    countOpened++;
                } else if (toEvaluate.charAt(i) == ')') {
                    countClosed++;
                }
            }
            if (countOpened != countClosed)
                return false;

            //Count []
            countOpened = 0;
            countClosed = 0;
            for (int i = 0; i < toEvaluate.length(); i++) {
                if (toEvaluate.charAt(i) == '[') {
                    countOpened++;
                } else if (toEvaluate.charAt(i) == ']') {
                    countClosed++;
                }
            }
            if (countOpened != countClosed)
                return false;

            //Count {}
            countOpened = 0;
            countClosed = 0;
            for (int i = 0; i < toEvaluate.length(); i++) {
                if (toEvaluate.charAt(i) == '{') {
                    countOpened++;
                } else if (toEvaluate.charAt(i) == '}') {
                    countClosed++;
                }
            }
            return countOpened == countClosed;
        }
    }

}

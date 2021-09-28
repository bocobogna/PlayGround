package Utils.datagenerator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataGenerator {

    public static String generateNowDate(String pattern) {
        return new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
    }
}

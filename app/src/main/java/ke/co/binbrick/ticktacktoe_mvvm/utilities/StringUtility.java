package ke.co.binbrick.ticktacktoe_mvvm.utilities;

/**
 * Created by vodera on 24/07/2018.
 */
public class StringUtility {

    public static String stringFromNumbers(int... numbers) {
        StringBuilder sNumbers = new StringBuilder();
        for (int number : numbers)
            sNumbers.append(number);
        return sNumbers.toString();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }
}

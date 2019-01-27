import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatterns {

    private static Pattern patternPoiskaNomeraPZ = Pattern.compile("\\b\\d{9}\\b"); // регулярные выражения

    public static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = patternPoiskaNomeraPZ.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Cant extract");
    }

    private static Pattern patternPoiskaNomeraZakupkiEIS = Pattern.compile("\\d{11}"); // поиск номера закупки ЕИС

    public static String getNomerZakupkiEISFromString(String stringDate) throws Exception {
        Matcher matcher = patternPoiskaNomeraZakupkiEIS.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        return "0";
    }

}

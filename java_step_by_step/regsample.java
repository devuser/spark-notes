import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static void main(String args[]) {
        String rawstr = "ISSERM.ISS002S.20130728.00.P";
        Pattern pattern = Pattern.compile("^([A-Z0-9]{6,8})\\.([A-Z0-9]{6,8})\\.(\\d{8})\\.[A-Z0-9]{2,4}\\.P");
        Matcher matcher = pattern.matcher(rawstr);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }
    }
}
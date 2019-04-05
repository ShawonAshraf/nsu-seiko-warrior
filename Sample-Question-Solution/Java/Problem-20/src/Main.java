import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String x = "hello world";
        System.out.println(funkyString(x));
    }

    public static String funkyString(String x) {
        // add more delimiters if needed
        String[] tokens = x.split(" ");

        ArrayList<String> parts = new ArrayList<>();

        for (String token : tokens) {
            char[] chars = token.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            chars[chars.length - 1] = Character.toUpperCase(chars[chars.length - 1]);

            parts.add(new String(chars));
        }

        return parts.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }
}

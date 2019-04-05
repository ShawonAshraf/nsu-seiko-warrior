import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String x = "      Enter    a     number.    ";

        // trim spaces first
        String trimmed = x.trim();
        String fixed = spaceFixed(trimmed);

        System.out.println(fixed);
    }

    public static String spaceFixed(String s) {
        // tokenize based on regex that matches whitespace
        String[] tokens = s.split("(\\s)+");
        String fixed = Arrays.asList(tokens).stream().collect(Collectors.joining(" "));

        return fixed;
    }

}

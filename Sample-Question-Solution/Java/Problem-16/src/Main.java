import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        * The set data structure omits duplicate values
        * So if we put characters from the string in a set, we remove the duplicates easily
        * */

        String x = "aadpp";

        // Set
        Set<Character> unique = new HashSet<>();

        // iterate
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            unique.add(c);
        }

        System.out.println(unique.stream().map(Objects::toString).collect(Collectors.joining("")));
    }
}

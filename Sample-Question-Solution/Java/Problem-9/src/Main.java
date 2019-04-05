import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // conver to lowercase
        String input = "Aatrewqeq".toLowerCase();

        System.out.println(getUniqueCharsLambda(input));

    }

    public static String getUniqueCharsLambda(String x) {
        // keep a dictionary to keep track of the characters
        // if the character already exists, it's no longer a unique char

        Map<Character, Boolean> charMap = new HashMap<>();
        char[] characters = x.toCharArray();

        // loop through characters and add to dictionary
        for (char c : characters) {
            if (charMap.containsKey(c)) {
                charMap.put(c, false);
            } else {
                charMap.put(c, true);
            }
        }

        ArrayList<Character> uniqueCharList = new ArrayList<>();
        // add unique chars to array
        charMap.forEach((key, value) -> {
            if (value) {
                uniqueCharList.add(key);
            }
        });

        return uniqueCharList.stream().map(Objects::toString).collect(Collectors.joining(""));
    }
}

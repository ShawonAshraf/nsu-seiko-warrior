import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static class Counter {
        public int vowels;
        public int consonants;

        public Counter(int vowels, int consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }

        @Override
        public String toString() {
            return "vowels=" + vowels +
                    ", consonants=" + consonants;
        }
    }

    public static void main(String[] args) {
	    String str = "A storm is brewing, just pick the right side when it comes to that.";

	    /*
	    * We have to find the number of vowels and consonants in the string.
	    * We can do it in a number of ways. Let's check them out.
	    * */

	    /*
	     *   for ease of operation, let's convert the entire string to lowercase, since case doesn't matter
	     *   for counting vowels and consonants.
         **/
	    String s = str.toLowerCase();
	    printCount(s);

	    /*
	    * Now this can be made a bit more sophisticated
	    * */
        printCount2(s);

        /*
        * Now what if we need to return something?
        * Check the Counter class above. Java can't return tuples like python
        * and we need multiple items returned from a function.
        * */
        Counter counter = returnCount(s);
        System.out.println(counter);

    }

    // as a void function that just prints the count
    public static void printCount(String str) {
        // using simple loop
        int len = str.length();
        // counters
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);

            // this vowel checking can be done via a function as well.
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }

        // done! now print
        System.out.println("Number of vowels : " + vowels + "\nNumber of consonants : " + consonants);
    }

    // with lambdas?
    public static void printCount2(String str) {
        // fetch only characters from the string
        // use an arraylist or a list, arrays are bad, in the sense that you need
        // to mention their size every time and lists in Java do have indices
        // let's use some new funky Java tricks
        // make sure to have JDK 8 or newer to try this one!

        // drop all non chars and white spaces
        List<Character> chars = str.chars()
                .mapToObj(k -> (char) k)
                .filter(k -> Character.isLetter(k))
                .collect(Collectors.toList());

        // count vowels
        int vowels = (int) chars.stream()
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                .count();

        System.out.println("Vowels : " + vowels);
        // then, the rest are just consonants!
        System.out.println("Consonants : " + (chars.size() - vowels));
    }

    // return the count
    public static Counter returnCount(String str) {
        // use any method to count the vowels and consonants you want
        // then instantiate a Counter object and return it.
        List<Character> chars = str.chars()
                .mapToObj(k -> (char) k)
                .filter(k -> Character.isLetter(k))
                .collect(Collectors.toList());

        // count vowels
        int vowels = (int) chars.stream()
                .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                .count();

        int consonants = chars.size() - vowels;

        return new Counter(vowels, consonants);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
         * We can generate indices randomly and then use that random index to add values to a
         * new array
         * */

        int[] sorted = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> unsorted = new ArrayList<>();

        System.out.println("Sorted : " + Arrays.toString(sorted));

        // random generator
        Random gen = new Random();
        gen.setSeed(42);

        for (int i = 0; i < sorted.length; ) {
            // 0 ~ sorted.length
            int randomIndex = gen.nextInt(sorted.length);

            // pick a value
            int el = sorted[randomIndex];

            // can generate duplicates
            // so if the list already contains el
            // don't add it.
            if (!unsorted.contains(el)) {
                unsorted.add(el);
                i++;
            }
        }
        System.out.println("Unsorted : " + unsorted);
    }
}

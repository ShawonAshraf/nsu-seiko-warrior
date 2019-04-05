import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        /*
        * This is a very easy problem. You need to divide the array into two parts and
        * then sort them.
        * */

        // don't use primitive types if you want to use lambdas
        // both int and Integer get unboxed to the same thing so you don't need to worry
        // about performance
        Integer[] b = {5, 2, 4, 7, 9, 3, 1, 6};
        int middle = (b.length / 2);

        /*
        * The first half will be from 0~middleIndex and the second half will be from
        * middleIndex + 1 ~ endIndex (which is length - 1).
        * */

        /*
        * You can either create two arrays to hold each half or use handy java Arrays tricks
        * */


        /*
        * Java Comparators basically work this way -
        * let's say we have two objects a and b
        *
        * if a > b, the comparator returns 1 or any positive value
        * if a < b, the comparator returns -1 or any negative value
        * if a == b, the comparator returns 0
        *
        * */

        /*
        * For sorting in ascending order, we need to make sure that two consecutive values
        * x and y meet the condition x < y.
        * Now to do so, our comparator should return a negative value
        * */
        Comparator<Integer> ascendingComparator = (x, y) -> x < y ? -1 : 1;

        /*
        * for descending we just have to do the opposite of ascending, change the negative
        * to positive
        * */
        Comparator<Integer> descendingComparator = (x, y) -> x < y ? 1 : -1;


        // read more on comparators here
        // https://www.callicoder.com/java-comparable-comparator/

        Arrays.sort(b, 0, middle, ascendingComparator);
        Arrays.sort(b, middle + 1, b.length, descendingComparator);

        // final output
        System.out.println(Arrays.toString(b));
    }
}

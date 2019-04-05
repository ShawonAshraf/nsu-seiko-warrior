import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] b = {11, 23, 30, 29, 5, 17, 79, 58, 2};

        // sort the array first
        // by default sorts in ascending order
        Arrays.sort(b);

        int secondLargest = b[b.length - 2];
        int secondMin = b[1];

        System.out.println(secondLargest + ", " + secondMin);
    }
}

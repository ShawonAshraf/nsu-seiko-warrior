import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    // the solution process is already mentioned in the doc
        int[] a = {4, 7, 11, -3, -6, 10, -12};
        int[] b = {2, 7, -7, -3, -6, 9, -1};

        // case 1
        System.out.println("Case 1 : [a] => " + Arrays.toString(a));
        System.out.println(getResult(a));

        // case 2
        System.out.println("Case 2: [b] => " + Arrays.toString(b));
        System.out.println(getResult(b));

    }

    public static int getResult(int[] x) {
        // I'm a very lazy person so I'm just going to use lambdas to make my life easier
        // you should use loops / lambdas whatever you like
        // you can study more about comparator objects in Java to get a hang of what happened inside
        // max. Also, you should get more idea about streams and collections in Java.

        int result = Arrays.stream(x).mapToObj(k -> Math.abs(k)).max((a, b) -> a > b ? 1 : -1).get();

        return result;
    }
}

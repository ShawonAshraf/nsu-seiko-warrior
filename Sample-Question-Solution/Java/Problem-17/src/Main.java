import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] b = {1, 2, 3, 6, 9, 13};
        ArrayList<Integer> result = new ArrayList<>();

        for (int n : b) {
            if (isPrime(n) && isFib(n)) {
                result.add(n);
            }
        }

        System.out.println(result.stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }

    public static boolean isFib(int n) {
        /*
        * a number "n" is said to be a fibonacci if,
        * 5*n*n + 4 or 5*n*n - 4 are perfect squares
        * */

        int a = 5*n*n + 4;
        int b = 5*n*n - 4;

        return isPerfectSquare(a) || isPerfectSquare(b);
    }

    public static boolean isPerfectSquare(int n) {
        return n == Math.sqrt(n) * Math.sqrt(n);
    }

    public static boolean isPrime(int n) {
        if (n < 2 || n != 2 &&  n % 2 == 0) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            for (int i = 3; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}

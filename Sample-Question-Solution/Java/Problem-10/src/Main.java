import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // let's use BigIntegers because the traditional int
        // will overflow

        BigInteger n = new BigInteger("100");
        BigInteger fact = factorial(n);

        System.out.println(fact);
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) {
            return n;
        }

        return n.multiply( factorial(n.subtract(BigInteger.ONE)) );
    }
}

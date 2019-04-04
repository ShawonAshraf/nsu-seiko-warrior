public class Main {

    public static void main(String[] args) {
	    // we have to count the number of digits before and after the decimal point
        // let's consider a number first and see what we can do with it!
        double n = 789.8765;
        // so we should be getting 3 digits before decimal point and 4 after the decimal point
        // from our function
        countDigits(n);
    }

    // just print counts
    public static void countDigits(double n) {
        int before = 0;
        int after = 0;

        double x = n;

        // can't use library functions here!
        // one way to get the digitCount before is to keep dividing by 10 until the result is 0
        // let me show you a detailed process here
        double temp;
        // Java gives real pain without casting
        System.out.println("Counting digits before the decimal point : ");
        while (true) {
            temp = x / 10;
            if ((int) temp == 0) {
                break;
            }
            x /= 10;
            before++;

            // log
            System.out.println("x = " + x + "\t x / 10 = " + temp + "\tbefore : " + before);
        }
        // as you can see from console logs, this algorithm ignores the last digit, so we have to increment
        // before
        before++;
        x /= 10;

        System.out.println("x = " + x + "\t x / 10 = " + temp + "\tbefore : " + before);
        System.out.println();

        // now what about digits after the decimal point?
        // fundamentally your programming language and the floating point design in
        // modern computers have a limitation. They don't have fixed precision
        // and there can be arbitrary number of garbage values after the decimal point.
        // for example Java Double has precision till the 15th digit after decimal point.
        // Still wouldn't be enough. So we have to think of a different approach. We can use the
        // ceil function here.

        x = n; // reinstate the value

        System.out.println("Counting digits after the decimal point : ");
        while (x != Math.ceil(x)) {
            System.out.println("x = " + x + "\t x * 10 = " + "\tafter : " + after);
            x *= 10;
            after++;
        }
        System.out.println("x = " + x + "\t x * 10 = " + "\tafter : " + after);

        System.out.println("before : " + before + "\tafter : " + after);
    }
}

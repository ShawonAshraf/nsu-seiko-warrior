import java.util.ArrayList;

public class Main {
    static class Result {
        int negatives;
        int positives;
        int maxDistance;

        public Result(int negatives, int positives, int maxDistance) {
            this.negatives = negatives;
            this.positives = positives;
            this.maxDistance = maxDistance;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "negatives=" + negatives +
                    ", positives=" + positives +
                    ", maxDistance=" + maxDistance +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, 0, -3, 6, -7, 8};
        System.out.println(getResult(arr));
    }

    public static boolean isPositive(int n) {
        // 0 is a non-negative number and not positive according to math defn.
        // however for this problem, we need to ignore 0, as a result the condition has been set
        // that way
        return n >= 0;
    }

    // check if two numbers have the same sign or not
    public static boolean isOfSameSign(int a, int b) {
        return (a >= 0 && b >= 0) || (a < 0 && b < 0);
    }

    public static Result getResult(int[] b) {
        int len = b.length;

        // let's keep lists to keep track of distances
        ArrayList<Integer> positiveDistance = new ArrayList<>();
        ArrayList<Integer> negeativeDistances = new ArrayList<>();

        // we'll need a nested loop structure here
        for (int i = 0; i < len; i++) {
            int currentValue = b[i];

            // look ahead for the whole values of same time
            for (int j = i + 1; j < len; j++) {
                // index to look for
                int index = Math.abs(j - i);

                // break away as soon as a match is found since we're looking for consecutive numbers

                if (isPositive(currentValue) && isOfSameSign(currentValue, b[j])) {
                    positiveDistance.add(index);
                    break;
                } else if (!isPositive(currentValue) && isOfSameSign(currentValue, b[j])) {
                    negeativeDistances.add(index);
                    break;
                }
            }
        }

        // using lambdas
        // you write your own function if you want
        int maxPos = positiveDistance.stream().max((x, y) -> x > y ? 1 : -1).get();
        int maxNeg = negeativeDistances.stream().max((x, y) -> x > y ? 1 : -1).get();
        int maxBetweenSameSign = Math.max(maxPos, maxNeg);

        return new Result(maxPos, maxNeg, maxBetweenSameSign);
    }
}

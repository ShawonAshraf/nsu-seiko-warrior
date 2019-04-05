public class Main {
    public static void main(String[] args) {
        int[] b = {67, 778, 9, 23, 45, 8};

        int sum = getSum(b, 0);
        System.out.println(sum);
    }

    public static int getSum(int[] b, int starIndex) {
        int sum = b[starIndex];
        if (starIndex == b.length - 1) {
            return sum;
        }
        return sum += getSum(b, starIndex + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        int result = recursiveExp(10, 4);
        System.out.println(result);
    }

    public static int recursiveExp(int base, int power) {
        if (power == 0) {
            return 1;
        } else if (power == 1) {
            return base;
        }


        return base * recursiveExp(base, power - 1);
    }
}

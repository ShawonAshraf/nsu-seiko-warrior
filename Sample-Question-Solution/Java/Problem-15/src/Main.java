import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        * This is a Longest increasing subsequence problem
        * Will require knowledge regarding dynamic programming and memoization
        * */

        int[] b = {1, 2, 3, 2, 5, 7, 9, 8, 2};

        System.out.println(longestIncreasingSubsequence(b));
    }

    public static ArrayList<Integer> longestIncreasingSubsequence(int[] b) {
        // a list for the sequence
        ArrayList<Integer> seq = new ArrayList<>();
        ArrayList<Integer> position = new ArrayList<>();
        // populate
        for (int i = 0; i < b.length; i++) {
            seq.add(1);
            position.add(-1);
        }

        /*
        * Here we check for the increasing subSequence and
        * update the position
        * */

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < i; j++) {
                if (b[j] < b[i] && seq.get(i) < seq.get(j) + 1) {
                    // update value on position
                    seq.set(i, seq.get(j) + 1);
                    position.set(i, j);
                }
            }
        }


        // let's get the final position
        int pos = 0;
        int subSeqLen = seq.get(0);

        System.out.println(seq);

        for (int i = 0; i < b.length; i++) {
            if (seq.get(i) > subSeqLen) {
                // update on pos
                pos = i;
                subSeqLen = seq.get(i);
            }
        }

        // now for seq.
        seq.clear();

        for (; pos != -1; ) {
            seq.add(b[pos]);
            pos = position.get(pos);
        }

        return seq;
     }
}

package algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanSum {


    // brute force
    static boolean canSum(int target, List<Integer> numbers) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        for (int num : numbers) {

            int reminder = target - num;
            if (canSum(reminder, numbers)) {

                return true;
            }
        }
        return false;
    }

    // memoization
    public static boolean canSumMemo(int targetSum, List<Integer> numbers) {
        return canSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static boolean canSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, Boolean> memo) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum < 0) {
            return false;
        }
        if (targetSum == 0) {
            return true;
        }
        for (Integer value : numbers) {
            if (canSumMemo(targetSum - value, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }

    // tabulation/bottom-up
    public boolean canSumTab(int targetSum, List<Integer> numbers) {

        boolean[] tabulation = new boolean[targetSum + 1];
        tabulation[0] = true;

        for (int i = 0; i < targetSum; i++) {
            for (Integer number : numbers) {

                if (tabulation[i] && i + number <= targetSum) {
                    tabulation[i + number] = true;
                }
            }
        }
        return tabulation[targetSum];
    }


    public static void main(String[] args) {

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + canSum(1000, Arrays.asList(1, 2, 4, 5)));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + canSumMemo(15, (Arrays.asList(1, 2, 4, 5))));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

        long preTime = System.currentTimeMillis();
        System.out.println("Can sum -> " + canSum(1000, Arrays.asList(1, 2, 4, 5)));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

    }
}

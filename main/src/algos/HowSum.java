package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HowSum {

    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return (new ArrayList<>()); }
        for (Integer value : numbers) {
            List<Integer> result = howSum(targetSum - value, numbers);
            if (result != null) {
                result.add(0, value);
                return result;
            }
        }
        return null;
    }

    public static List<Integer> howSumMemo(int targetSum, List<Integer> numbers) {
        return howSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> howSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return (new ArrayList<>()); }
        for (Integer value : numbers) {
            List<Integer> result = howSumMemo(targetSum - value, numbers, memo);
            if (result != null) {
                result.add(0, value);
                memo.put(targetSum, result);
                return result;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    public static List<Integer> howSumTab(int targetSum, List<Integer> numbers)  {
        List<List<Integer>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        for (int i = 0; i < targetSum; i++) { tabulation.add(null); }

        for (int i = 0; i <= targetSum; i++) {
            for (Integer number : numbers) {
                int index = i + number;
                if (index > targetSum || tabulation.get(i) == null) { continue; }
                List<Integer> list = new ArrayList<>(tabulation.get(i));
                list.add(0, number);
                if (index == targetSum) {
                    return list;
                }
                tabulation.set(index, list);
            }
        }
        return null;
    }


    public static void main(String[] args) {

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + howSum(1000, Arrays.asList(12, 2, 4, 5)));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

        long preTime = System.currentTimeMillis();
        System.out.println("Can sum -> " + howSumMemo(1000, (Arrays.asList(12, 2, 4, 5))));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + howSumTab(1000, Arrays.asList(12, 2, 4, 5)));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

    }
}

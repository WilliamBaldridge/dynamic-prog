package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BestSum {

    public static List<Integer> bestSum(int targetSum, List<Integer> numbers) {
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return new ArrayList<>(); }
        List<Integer> shortest = null;
        for (Integer value : numbers)  {
            List<Integer> combination = bestSum(targetSum - value, numbers);
            if (combination != null) {
                combination.add(0, value);
                if (shortest == null || shortest.size() > combination.size()) {
                    shortest = combination;
                }
            }
        }
        return shortest;
    }


    public static List<Integer> bestSumMemo(int targetSum, List<Integer> numbers) {
        return bestSumMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> bestSumMemo(int targetSum, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) { return memo.get(targetSum); }
        if (targetSum < 0) { return null; }
        if (targetSum == 0) { return new ArrayList<>(); }
        List<Integer> shortest = null;
        for (Integer value : numbers)  {
            List<Integer> combination = bestSumMemo(targetSum - value, numbers, memo);
            if (combination != null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                list.addAll(combination);
                if (shortest == null || shortest.size() > list.size()) {
                    shortest = list;
                }
            }
        }
        memo.put(targetSum, shortest);
        return shortest;
    }

    public static List<Integer> bestSumTab(int targetSum, List<Integer> numbers) {
        List<List<Integer>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        for (int i = 0; i < targetSum; i++) { tabulation.add(null); }
        for (int i = 0; i <= targetSum; i++) {
            for (Integer number : numbers) {
                int index = i + number;
                if (index > targetSum || tabulation.get(i) == null) {
                    continue;
                }
                List<Integer> list = new ArrayList<>(tabulation.get(i));
                list.add(0, number);
                if (tabulation.get(index) == null || tabulation.get(index).size() > list.size()) {
                    tabulation.set(index, list);
                }
            }
        }
        return tabulation.get(targetSum);
    }


    public static void main(String[] args) {

        long preTime = System.currentTimeMillis();
        System.out.println("Can sum -> " + bestSum(1000, Arrays.asList(12, 2, 4, 5)));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + bestSumMemo(1000, (Arrays.asList(12, 2, 4, 5))));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + bestSumTab(1000, Arrays.asList(12, 2, 4, 5)));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));
    }

}

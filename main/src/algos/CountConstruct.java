package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountConstruct {

    public static int countConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return 1; }
        int sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) { continue; }
            sum += countConstruct(target.replaceFirst(prefix, ""), wordBank);
        }
        return sum;
    }


    public static Integer countConstructMemo(String target, List<String> wordBank) {
        return countConstructMemo(target, wordBank, new HashMap<>());
    }
    private static Integer countConstructMemo(String target, List<String> wordBank, HashMap<String, Integer> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return 1; }
        Integer sum = 0;
        for (String prefix : wordBank) {
            if (!target.startsWith(prefix)) { continue; }
            sum += countConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo);
        }
        memo.put(target, sum);
        return sum;
    }


    public static Integer countConstructTab(String target, List<String> wordBank) {
        List<Integer> tabulation = new ArrayList<>();
        tabulation.add(1);
        for (int i = 0; i < target.length(); i++) { tabulation.add(0); }

        for (int i = 0; i < target.length(); i++) {
            if (tabulation.get(i) == 0) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(
                            i+prefix.length(),
                            tabulation.get(i) + tabulation.get(i+prefix.length())
                    );
                }
            }
        }
        return tabulation.get(target.length());
    }


    public static void main(String[] args) {


//        long preTime = System.currentTimeMillis();
//        System.out.println("Number of ways to construct string -> " + countConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Number of ways to construct string -> " + countConstructMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

        long preTime = System.currentTimeMillis();
        System.out.println("Number of ways to construct string-> " + countConstructTab("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));
    }
}

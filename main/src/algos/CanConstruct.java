package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanConstruct {

    public static boolean canConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) { continue; }
            if (canConstruct(target.replaceFirst(subWord, ""), wordBank)) {
                return true;
            }
        }
        return false;
    }


    public static boolean canConstructMemo(String target, List<String> wordBank) {
        return canConstructMemo(target, wordBank, new HashMap<>());
    }
    private static boolean canConstructMemo(String target, List<String> wordBank, HashMap<String, Boolean> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return true; }
        for (String subWord : wordBank) {
            if (!target.startsWith(subWord)) { continue; }
            if (canConstructMemo(target.replaceFirst(subWord, ""), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }


    public static boolean canConstructTab(String target, List<String> wordBank) {
        List<Boolean> tabulation = new ArrayList<>();
        tabulation.add(true);
        for (int i = 0; i < target.length(); i++) { tabulation.add(false); }

        for (int i = 0; i < target.length(); i++) {
            if (!tabulation.get(i)) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (word.startsWith(prefix)) {
                    tabulation.set(i + prefix.length(), true);
                }
                if (tabulation.get(target.length())) { return true; }
            }
        }
        return false;
    }


    public static void main(String[] args) {

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + canConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Can sum -> " + canConstructMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd"))));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

        long preTime = System.currentTimeMillis();
        System.out.println("Can sum -> " + canConstructTab("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));
    }
}

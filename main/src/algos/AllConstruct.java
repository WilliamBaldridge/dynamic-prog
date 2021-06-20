package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllConstruct {

    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        if (target.isEmpty()) { return Arrays.asList(new ArrayList<>()); }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> suffixWays =  allConstruct(target.replaceFirst(prefix, ""), wordBank);
                suffixWays.forEach( a -> a.add(0, prefix));
                result.addAll(suffixWays);
            }
        }
        return result;
    }


    public static List<List<String>> allConstructMemo(String target, List<String> wordBank) {
        return allConstructMemo(target, wordBank, new HashMap<>());
    }
    private static List<List<String>> allConstructMemo(String target, List<String> wordBank, HashMap<String, List<List<String>>> memo) {
        if (memo.containsKey(target)) { return memo.get(target); }
        if (target.isEmpty()) { return Arrays.asList(new ArrayList<>()); }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : wordBank) {
            if (target.startsWith(prefix)) {
                List<List<String>> suffixWays = allConstructMemo(target.replaceFirst(prefix, ""), wordBank, memo)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                suffixWays.forEach( a -> a.add(0, prefix));
                result.addAll(suffixWays);
            }
        }
        memo.put(target, result);
        return result;
    }


    public static List<List<String>> allConstructTab(String target, List<String> wordBank) {
        List<List<List<String>>> tabulation = new ArrayList<>();
        tabulation.add(new ArrayList<>());
        tabulation.get(0).add(new ArrayList<>());
        for (int i = 0; i < target.length(); i++) { tabulation.add(new ArrayList<>()); }

        for (int i = 0; i <= target.length(); i++) {
            if (tabulation.get(i).isEmpty()) { continue; }
            String word = target.substring(i);
            for (String prefix : wordBank) {
                if (!word.startsWith(prefix)) { continue; }
                List<List<String>> current = tabulation.get(i)
                        .stream()
                        .map(ArrayList::new)
                        .collect(Collectors.toList());
                current.forEach(arr -> arr.add(prefix));
                tabulation.get(i+prefix.length()).addAll(current);
            }
        }
        return tabulation.get(target.length());
    }

    public static void main(String[] args) {


        long preTime = System.currentTimeMillis();
        System.out.println("Number of ways to construct string -> " + allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Number of ways to construct string -> " + allConstructMemo("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Number of ways to construct string-> " + allConstructTab("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));
    }
}

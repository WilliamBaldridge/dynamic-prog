package algos;


public class Fib {

    // brute force
    static int fibNumber(int n) {
        if (n <= 2)
            return 1;
        return fibNumber(n - 1) + fibNumber(n - 2);
    }

    // Fib with memoization recursion with array

    static int fibNumber(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];
        if (n <= 2)
            return 1;
        memo[n] = fibNumber(n - 1, memo) + fibNumber(n - 2, memo);
        return memo[n];
    }

    // Fib "bottom-up"
    static long fibB(int n) {

        if (n == 1 || n == 2) return 1;
        long[] table = new long[n + 1];
        table[1] = 1;
        table[2] = 1;

        for (int i = 3; i <= n; i++)
            table[i] = table[i - 1] + table[i - 2];
        return table[n];
    }

    static long fibNumBottom(int n) {

        long[] table = new long[n + 1];
        table[1] = 1;
        for (int i = 0; i <= n; i++) {
            if (i + 1 < table.length)
                table[i + 1] += table[i];
            if (i + 2 < table.length)
                table[i + 2] += table[i];
        }
        return table[n];
    }


    public static void main(String args[]) {

//        fibArray[0] = 1;
//        fibArray[1] = 1;
//        long preTime = System.currentTimeMillis();
//        System.out.println("Value of 25th number in Fibonacci series-> " + fibonacci(50));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));


        long preTime = System.currentTimeMillis();
        System.out.println("Value of 25th number in Fibonacci series-> " + fibB(50));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Value of 25th number in Fibonacci series-> " + fibNumBottom(50));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

    }
}

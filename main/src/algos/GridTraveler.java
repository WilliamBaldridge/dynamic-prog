package algos;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    static long grid(long m, long n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        return (grid(m - 1, n) + grid(m, n - 1));
    }

    // Memoization
    static Map<String,Long> memo=new HashMap<>();
    static long gridMemo(long m,long n)
    {
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;
        String key=m+"?"+n;

        if(memo.containsKey(key))
            return memo.get(key);

        memo.put(key,(grid(m-1,n)+grid(m,n-1)));
        return memo.get(key);
    }

    // tabulation (bottom-up?)
    static long gridBottomUp(int m, int n) {

        long[][] table = new long[m + 1][n + 1];
        table[1][1] = 1;

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++) {

                long current = table[i][j];
                if (j + 1 <= n)
                    table[i][j + 1] += current;
                if (i + 1 <= m)
                    table[i + 1][j] += current;
            }
        return table[m][n];
    }


    public static void main(String[] args) {


//        long preTime = System.currentTimeMillis();
//        System.out.println("Possible moves to traverse Grid -> " + grid(15, 15));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

        long preTime = System.currentTimeMillis();
        System.out.println("Possible moves to traverse Grid -> " + gridMemo(15, 15));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

//        long preTime = System.currentTimeMillis();
//        System.out.println("Possible moves to traverse Grid -> " + gridBottomUp(15, 15));
//        long postTime = System.currentTimeMillis();
//        System.out.println("Time taken to compute in milliseconds-> " + (postTime - preTime));

    }

}

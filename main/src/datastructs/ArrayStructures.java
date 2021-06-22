package datastructs;

import java.util.*;

public class ArrayStructures {

    // A static array is a fixed length container containing n elements indexable from [0, n-1]

    // When & where used
    // 1. Storing and accessing sequential data
    // 2. Temp storing objects
    // 3. Used in IO routines as buffers
    // 4. Lookup tables and inverse lookup tables
    // 5. To return multiple values from a function
    // 6. Dynamic prog to cache answers to sub-problems (bottom-up/tabulation using loops and arrays)

    /*
                 Complexity
            static array    Dynamic array
    Access      O(1)            O(1)
    Search      O(n)            O(n)
    Insert      N/A             O(n)
    Append      N/A             O(1)
    Delete      N/A             O(n)

     */



    public static void main(String[] args) {


        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        System.out.println(arr);
        arr.add(10);
        System.out.println(arr);

        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(arr2);
        arr2.remove(3);
        System.out.println(arr2);



    }


}

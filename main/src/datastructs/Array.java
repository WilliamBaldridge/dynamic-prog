package datastructs;

import java.util.Arrays;

public class Array {

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

    private int [] arr;
    private int len = 0;
    private int capacity = 0;

    public Array(int[] arr) {
        this.arr = arr;
    }

    public Array(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public static int[] add(int[] arr, int capacity) {

        int[] extendedArray = Arrays.copyOf(arr, arr.length + 1);

        extendedArray[extendedArray.length - 1] = capacity;

        return extendedArray;
    }


    public static void main(String[] args) {

        int[] arr = new int[10];
        System.out.println(arr.length);
        Array.add(arr, 2);
        System.out.println(arr.length);
    }


}

package datastructs.priorityqueue;

import java.util.*;

public class PriorityQAndHeapNotes<T extends Comparable<T>> {

    // A PriorityQueue (PQ) is a abstract data type (ADT) which operates similar to a normal queue except that each element has a certain priority. The priority of the elements in the priority queue determine the order in which elements are removed from the PQ
    // *** PQs only support comparable data, meaning data inserted must be able to be ordered in some way, either least to greatest or vis-a-vis. This is to assign relative priorities to each element

    // A heap is a tree based data struct that satisfies the heap invariant (aka heap property): If A is a parent node of B, then A is ordered with respect to B for all nodes A, B in the heap
    // Max Heap is parent node >= children , Min Heap is parent <= children
    // Various tree types for Heaps, i.e binary and fibonacci
    // A "complete binary tree" is a tree where every level, except possibly the last, is completely filled and all nodes are as far left as possible
    // Array representation is fast and fills in order left to right and down
    // let i = parent node (zero based, as array index)
    // left child = 2i + 1
    // right child = 2i + 2
    // inserted elements also bubble up
    // poll() (remove) removes the root (index 0 in array), will also bubble down
    // remove(12) will remove at value, scan through to remove, which is swapped with last node in tree, then bubble up/down as needed

    /*

    Removing elements from Binary Heap using Hashtable

        The inefficiency of .remove() comes from the fact we have to perform a linear search to find out where an element is indexed at (like for loop matching).
        However, a hashtable provides a constant time lookup and update for a mapping from a key (the node value) to a value (the index)

        Dealing with multiple value problem:
            Instead of mapping one value to one position (one index to one value), we will map one value to multiple positions. We can maintain a Set or Tree Set of indices (values) for which a particular node value (key) maps to (i.e. node 2 = Set(0, 2, 6)) it does not matter which you remove (same process using array ex. above), as long as the heap invariant (ordering) is satisfied


     */


    // When & where used
    // 1. Used in certain implementations of Dijkstra's shortest path algorithm
    // 2. Anytime you need to dynamically fetch the "next best" or "next worst" element
    // 3. Used in Huffman coding (which is often used for lossless data compression)
    // 4. Best first search algos, such as A*, use PQs to continuously grab the next most promising node
    // 5. Used by Minimum Spanning Tree algos

    /*
                    Complexity
        Binary Heap             O(n)
        construction
        Polling                 O(log(n))
        Peeking                 O(1)
        Adding                  O(log(n))
        Naive removing          O(n)
        *Advanced removing
        with help from a        O(log(n))
        hash table*
        Naive contains          O(n)
        *Contains check
        with help of a          O(1)
        hash table*

        * Using a hash table help optimize operations does take up linear space and also adds some overhead to the binary heap implementation

     */


    public static void main(String[] args) {

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Arrays.asList(1, 6, 3, 9, 5));
        System.out.println(queue1);
        queue1.add(6);
        System.out.println(queue1);
        queue1.poll();
        System.out.println(queue1);
        queue1.remove(4);
        System.out.println(queue1);


        System.out.println(queue1.comparator());



        // Hashtable ex only really useful when removing as much as adding
        Map<Integer, TreeSet<Integer>> heapMap = new HashMap<>();
        heapMap.put(2, new TreeSet<>(Arrays.asList(1, 3, 6)));
        System.out.println(heapMap);
        heapMap.put(0, new TreeSet<>(Arrays.asList(0, 2)));
        heapMap.put(4, new TreeSet<>(Arrays.asList(4)));
        System.out.println(heapMap);
        System.out.println(heapMap.containsKey(1));



        heapMap.remove(0, 0);
        System.out.println(heapMap);

    }

}

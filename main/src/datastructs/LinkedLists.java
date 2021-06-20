package datastructs;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedLists {

    // Singly Linked List (SLL) & Doubly linked list (DLL)

    // Is a sequential list of nodes that hold data which point to other nodes also containing data
    // ex.   (data) -> (data) -> (data) -> (null)

    // When & where used
    // 1. List, queue, and stack implementations
    // 2. Circular lists
    // 3. Model real world object like trains
    // 4. separate chaining, which is present certain Hashtable implementations to deal with hashing collisions
    // 5. implementation of adjacency lists for graphs

    /*
                    Pros            Cons
      Singly   less memory          cannot easily access previous
      Linked   simpler impl         elements

      Doubly    can travers         takes 2x memory
      Linked    backwards

     */

    // when removing nodes in SLLs, be sure to clean memory after to prevent memory leaks


    /*
                    Complexity
                SSL             DLL
    Search      O(n)            O(n)

    Insert      O(1)            O(1)
    at head

    insert      O(1)            O(1)
    at tail

    remove      O(1)            O(1)
    at head

    remove      O(n)            O(1)
    at tail

    remove      O(n)            O(n)
    at middle

     */


    public static void main(String[] args) {

        LinkedList<Integer> sll = new LinkedList<>();

        sll.add(1);
        System.out.println(sll);

        LinkedList<Integer> sll2 = new LinkedList<>(Arrays.asList(1,2,3,4));
        System.out.println(sll2);

        sll2.removeFirst();
        System.out.println(sll2);

        sll2.remove(1);
        System.out.println(sll2);
    }



}

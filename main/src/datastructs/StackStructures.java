package datastructs;

import java.util.*;

public class StackStructures {

    // A stack is a one-ended linear data structure which models a real world stack by having to primary operations, push and pop at the top, LIFO

    // When & where used
    // 1. Undo commands in text editors
    // 2. Used in compiler syntax checking for matching brackets and braces
    // 3. Can be used to model a pile of books or plates
    // 4. Used behind the scenes to support recursion by keeping track of previous function calls.
    // 5. Can be used to do a Depth First Search (DFS) on a graph


    /*
               Complexity
        Pushing         O(1)
        Popping         O(1)
        Peeking         O(1)
        Searching       O(n)
        Size            O(1)

     */


    public static void main(String[] args) {


        Stack<Integer> stack1 = new Stack<Integer>();

        stack1.push(1);
        System.out.println(stack1);
        stack1.push(2);
        System.out.println(stack1.peek());
        System.out.println(stack1);
        System.out.println(stack1.empty());
        stack1.iterator();

        // A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class. For example:
        Deque<Integer> stack2 = new ArrayDeque<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(stack2);
        stack2.pop();
        System.out.println(stack2);
        stack2.push(1);
        System.out.println(stack2);
        stack2.peekFirst();

    }


}

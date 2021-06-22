package datastructs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuesStructures {

    // A Queue is a linear data structure which models a real world queues by having to primary operations, enqueue and dequeue, FIFO

    // When & where used
    // 1. Waiting lines
    // 2. Can be used to efficiently keep track of the x most recent added elements
    // 3. Web server request where you want first com first serve
    // 4. Breadth first search (BFS)

    /*
               Complexity
        Enqueue         O(1)
        Dequeue         O(1)
        Peeking         O(1)
        Contains        O(n)
        Removal         O(n)
        .empty()        O(1)

     */


    public static void main(String[] args) {

        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        integerQueue.add(5);
        System.out.println(integerQueue);
        int firstInQueue = integerQueue.remove();
        System.out.println("The element deleted from the head is: " + firstInQueue);
        System.out.println("The queue after deletion is: " + integerQueue);
        int head = integerQueue.peek();
        System.out.println("The head of the queue is now: " + head);
        int size = integerQueue.size();
        System.out.println("The size of the queue is now: " + size);

//

    }

}

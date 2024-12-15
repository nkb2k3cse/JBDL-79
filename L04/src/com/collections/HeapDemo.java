package com.collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapDemo {

    public static void main(String[] args) {

//        Queue<Integer> queue = new PriorityQueue<>();// MinHeap
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());// ManHeap
        queue.offer(34);// add end of queue
        queue.offer(1);
        queue.offer(10);
        queue.offer(-10);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
/*
Smallest K int in array.


 */

//LinkedQueue class which creates a queue with a linked list implementation (FIFO queue)
package edu.soen341.projectb.nodes;

import java.util.*;
public class LinkedQueue implements Iterable<Node> {
    // LinkedList definition
    public LinkedQueue() {
        queue = new LinkedList<Node>();
    }
    // Main methods, note that pop() methods implements the FIFO mechanism
    public void add(Node node) {
        queue.add(node);
    }

    public Node pop() {
        return queue.poll();
        // Node first = queue.getFirst();
        // queue.removeFirst();
        // return first;
    }

    public int size(){
        return queue.size();
    }

    public void clear(){
        queue.clear();
    }


    public void remove(Node node) {
        queue.remove(node);
    }
    //Iterates over whole list, overridden
    @Override
    public Iterator<Node> iterator() {
        return null;
    }

    private LinkedList<Node> queue;
}

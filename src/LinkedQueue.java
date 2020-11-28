import java.util.*;
public class LinkedQueue implements Iterable<Node> {

    private LinkedList<Node> queue;

    public LinkedQueue() {
        queue = new LinkedList<Node>();
    }

    public void add(Node node) {
        queue.add(node);
    }

    public Node pop() {
        return queue.poll();
        // Node first = queue.getFirst();
        // queue.removeFirst();
        // return first;
    }


    public void remove(Node node) {
        queue.remove(node);
    }

    @Override
    public Iterator<Node> iterator() {
        return null;
    }

    
}

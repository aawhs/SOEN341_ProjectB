import java.util.*;
public class Linked implements Iterable<Node> {

    private LinkedList<Node> list;

    public Linked() {
        list = new LinkedList<Node>();
    }

    public void add(Node node) {
        list.add(node);
    }

    public Node pop() {
        return list.poll();
        
    }


    public void remove(Node node) {
        list.remove(node);
    }

    @Override
    public Iterator<Node> iterator() {
        return null;
    }
}

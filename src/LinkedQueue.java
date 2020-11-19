import java.util.*;
public class LinkedQueue<Item> implements Iterable<Item>{
    private Queue queue;

    public LinkedQueue(){
        queue = new LinkedList();
    }

    public void add(Item item){
        queue.add(item);
    }

    public Object getNext(){
        return queue.poll();
    }

    public void remove(Item item){
        queue.remove(item);
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}

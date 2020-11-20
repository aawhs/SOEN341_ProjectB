import java.util.Iterator;
import java.util.Map;

public interface ISymbolTable<Key extends Comparable<Key>, Value>{
    //Symbol Table Main Function
    Value get(Key key);
    void put(Key key, Value val);
    void remove(Key key);
    boolean contains(Key key);
    Iterator<Map.Entry<Comparable, Object>> poll();

    //Helper Functions
    int size();
    boolean isEmpty();
    boolean isValid(Comparable key);
    Iterable<Key> keys();
    Iterator<Key> iterator();
}

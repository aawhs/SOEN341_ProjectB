import java.util.Iterator;

public interface ISymbolTable <Key extends Comparable<Key>, Value>
{
    //Symbol Table Main Function
    Node get(Key key);
    void put(Key key, Value val);
    void remove(Key key);
    boolean contains(Key key);

    //Helper Functions
    int size();
    boolean isEmpty();
    boolean isValid(Comparable key);
    Iterable<Key> keys();
    Iterator<Key> iterator();
}

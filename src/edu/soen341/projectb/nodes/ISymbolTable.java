//Interface which contains used in the implementation of SymbolTable
package edu.soen341.projectb.nodes;

import java.util.Iterator;
import java.util.Map;

public interface ISymbolTable<Key extends Comparable<Key>, Value>{
    //Symbol Table Main Functions
    Value get(Key key);
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

import java.util.Iterator;
import java.util.TreeMap;

public class SymbolTable implements ISymbolTable{

    private TreeMap<Comparable, Object> symbolTable;

    public SymbolTable() {
        symbolTable = new TreeMap<>();
    }

    //Insert
    @Override
    public void put(Comparable key, Object val) {
        if(key == null){
            throw new IllegalArgumentException("calls put() with null key");
        }
        if(val == null){
            symbolTable.remove(key);
        }else{
            symbolTable.put(key,val);
        }
    }

    @Override
    public Object get(Comparable key) {
        if(key == null)
        return null;
    }

    @Override
    public void remove(Comparable key) {

    }

    @Override
    public boolean contains(Comparable key) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Iterable keys() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}

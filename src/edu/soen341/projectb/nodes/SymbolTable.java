package edu.soen341.projectb.nodes;

import java.util.Iterator;
import java.util.TreeMap;

public class SymbolTable implements ISymbolTable {

    public TreeMap<Comparable, Object> getSymbolTable() {
        return symbolTable;
    }

    private TreeMap<Comparable, Object> symbolTable;


    public SymbolTable() {
        symbolTable = new TreeMap<>();
    }

    //Insert Key-Value Pair
    @Override
    public void put(Comparable key, Object val) {
        if(!isValid(key)) throw new IllegalArgumentException("cannot put null key");
        if(val == null) symbolTable.remove(key);
        else symbolTable.put(key,val);
    }

    //Get Value paired with key
    @Override
    public Object get(Comparable key) {
        if(!isValid(key)) throw new IllegalArgumentException("cannot get null key");
        return symbolTable.get(key);
    }


    //remove key-value pair
    @Override
    public void remove(Comparable key) {
        if(!isValid(key)) throw new IllegalArgumentException("cannot remove null key");
        symbolTable.remove(key);
    }

    //Check if Symbol Table contains key
    @Override
    public boolean contains(Comparable key) {
        if(!isValid(key)) throw new IllegalArgumentException("cannot check for null key");
        return symbolTable.containsKey(key);
    }

    //Return Symbol Table size
    @Override
    public int size() {
        return symbolTable.size();
    }

    //Check if Symbol Table is Empty
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    //Helper Methods
    @Override
    public boolean isValid(Comparable key) {
        if(key == null){
            return false;
        }
        return true;
    }

    @Override
    public Iterable keys() {
        return symbolTable.keySet();
    }

    @Override
    public Iterator iterator() {
        return symbolTable.keySet().iterator();
    }

    /**
     * Used in AUnit testing
     * @param i the value of the .get value from SymbolTable.get()
     * @return Hexadecimal formatted string for the value of the input argument
     */
    public String toHex(int i){
        return String.format("0x%02X",i);
    }
}

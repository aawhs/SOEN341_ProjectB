package com.cm.assembler;

public class Test_Error {
    public static void main(String[] args){
        System.out.print("Test _Error\n");
        System.out.print(String.format("This is a test error at position: 1, 1"));


        Position position = new Position(1,1);
        _Error.create("\nThis is a test error at position:", position).printErrors();
    }
}

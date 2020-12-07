package edu.soen341.projectb.assembler;

public class Directive { //extends Node?
    private String stringOperand;

    public Directive(){
        stringOperand = "";
    }

    public Directive(String so){
        stringOperand = so;
    }

    public void setStringOperand(String so){
        stringOperand = so;
    }

    public String getStringOperand(){
        return stringOperand;
    }
}

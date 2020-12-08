package edu.soen341.projectb.assembler;

public class Directive implements Opcode { //extends Node?
    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

    private String directive;
    private int opcode;
    private String stringOperand;

    public Directive(){
        this.directive = "";
        this.stringOperand = "";
    }

    public Directive(String so){
        this.directive = ".cstring";
        this.opcode = _CSTRING;
        this.stringOperand = so;
    }

    public int getOpcode() {
        return opcode;
    }

    public void setStringOperand(String so){
        stringOperand = so;
    }

    public String getStringOperand(){
        return stringOperand;
    }
}

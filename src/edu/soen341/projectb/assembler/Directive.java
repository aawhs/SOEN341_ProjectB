package edu.soen341.projectb.assembler;
    //The Directive Class is used in relation to the Directive Tokens acquired by the Lexer for Parsing
public class Directive { 
    //Basic Contructor for the Directive Object
    public Directive(){
        stringOperand = "";
    }
    //Paramaterize Constructor for the Directive Object
    public Directive(String so){
        stringOperand = so;
    }
    //Basic Setter method in relation to Directive Object
    public void setStringOperand(String so){
        stringOperand = so;
    }
    //Basic Getter method in relation to Directive Object
    public String getStringOperand(){
        return stringOperand;
    }
    //Necessary Data Members for the Directive Class
    private String stringOperand;
}

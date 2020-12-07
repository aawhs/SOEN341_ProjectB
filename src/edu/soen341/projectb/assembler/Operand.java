package edu.soen341.projectb.assembler;
    //Class Operand is designed to hold labels,addresses and offset
public class Operand {
    //Basic Contructor for the Operand Class
    public Operand() {
        this.label = new Label ("");
        this.address = 0;
        this.offset = 0;
    }
    //Paramaterized Contructor for the Operand Class
    public Operand(Label l, int a, int o){
        this.label = l;
        this.address = a;
        this.offset = o;
    }
    //Basic Setter method in relation to Operand Class
    public void setLabel(Label l){
        this.label = l;
    }
    //Basic Setter method in relation to Operand Class
    public void setAddress(int i){
        this.address = i;
    }
    //Basic Setter method in relation to Operand Class
    public void setOffset(int i){
        this.offset = i;
    }
    //Basic Getter method in relation to Operand Class
    public Label getLabel(){
        return label;
    }
    //Basic Getter method in relation to Operand Class
    public int getAddress(){
        return address;
    }
    //Basic Getter method in relation to Operand Class
    public int getOffset(){
        return offset;
    }
    //Necessary Data Members for the Operand Class
    Label label;
    int address;
    int offset;
}



package edu.soen341.projectb.assembler;

public class Operand {
    Label label;
    int address;
    int offset;

    public Operand() {
        this.label = new Label ("");
        this.address = 0;
        this.offset = 0;
    }

    public Operand(Label l, int a, int o){
        this.label = l;
        this.address = a;
        this.offset = o;
    }

    public void setLabel(Label l){
        this.label = l;
    }

    public void setAddress(int i){
        this.address = i;
    }

    public void setOffset(int i){
        this.offset = i;
    }

    public Label getLabel(){
        return label;
    }

    public int getAddress(){
        return address;
    }

    public int getOffset(){
        return offset;
    }


}



package edu.soen341.projectb.assembler;

public class Label {

    private String identifier = " ";

    public Label(String i){
        this.identifier = i;
    }

    public String getIdentifier(){
        return identifier;
    }
}

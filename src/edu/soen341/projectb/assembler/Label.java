package edu.soen341.projectb.assembler;
    //The Label class is intended to hold Label Objects 
public class Label {
    //Paramaterized Constructor for the Label Class
    public Label(String i){
        this.identifier = i;
    }
    //Basic Getter method in relation to Label Object
    public String getLabel(){
        return identifier;
    }
    //Necessary Data Members for the Label Class
    private String identifier = "";
}

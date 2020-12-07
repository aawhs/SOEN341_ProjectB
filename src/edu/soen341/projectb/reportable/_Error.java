package edu.soen341.projectb.reportable;

import edu.soen341.projectb.helper.Position;

import java.util.ArrayList;

public class _Error {
    //Constructors
    _Error(String t, Position pos){
        this.text = t;
        this.pos = pos;
    }
    public static _Error create(String t, Position position){
        _Error e = new _Error(t, position);
        addError(e);
        return e;
    }
    
    //Method to add error to errors list
    public static void addError(_Error error){
        list_of_errors.add(error);
    }

    //Method to print all errors stored in errors list
    public static void printErrors(){
        for(int i = 0; i < list_of_errors.size(); i++){
            System.out.println(list_of_errors.get(i).text + " " + list_of_errors.get(i).pos.toString());

        }
    }
    /*
    public boolean spellError(String line){
        for(int i = 0; i< inherentMnemonics.length; i++){
            if(inherentMnemonics[i].contains(line)){
                this.error("Spelling error");
                return true;
            }
        }
        return false;
    }
    */

    //_Error attributes
    private String text;
    private Position pos;
    static ArrayList<_Error> list_of_errors = new ArrayList<>();
}

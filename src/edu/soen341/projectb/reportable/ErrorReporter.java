package edu.soen341.projectb.reportable;

import java.util.ArrayList;
public class ErrorReporter implements IReportable {
    


    public ErrorReporter(){
        errors = new ArrayList<_Error>();
    }
    //Methods
    @Override
    public void record(_Error e) {
        //TODO ADD ERROR TO LIST
        errors.add(e);
    }

    public void getException(){
        errors.get(0);
    }

    public void printErrors() {
        for(int i = 0; i < errors.size(); i++){
            System.out.println(errors.get(i).getText() + " " + errors.get(i).getPosition().toString());

        }
    }

    //Attribute
    static ArrayList<_Error> errors = new ArrayList<>();
}
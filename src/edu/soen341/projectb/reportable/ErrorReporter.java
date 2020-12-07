package edu.soen341.projectb.reportable;

import java.util.ArrayList;
public class ErrorReporter implements IReportable {
    


    //Methods
    @Override
    public void record(_Error e) {
        //TODO ADD ERROR TO LIST
        errors.add(e);
    }

    public void getException(){
        errors.get(0);
    }

    //Attribute
    ArrayList<_Error> errors = new ArrayList<>();
}
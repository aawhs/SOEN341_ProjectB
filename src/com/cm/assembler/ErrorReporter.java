package com.cm.assembler;

import java.util.ArrayList;
public class ErrorReporter implements IReportable{
    ArrayList<_Error> errors = new ArrayList<>();

    @Override
    public void record(_Error e) {
        //TODO ADD ERROR TO LIST
        errors.add(e);
    }

    public void getException(){
        errors.get(0);
    }
}
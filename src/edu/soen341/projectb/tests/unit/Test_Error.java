package edu.soen341.projectb.tests.unit;

import edu.soen341.projectb.helper.Position;
import edu.soen341.projectb.reportable.ErrorReporter;
import edu.soen341.projectb.reportable._Error;

public class Test_Error {
    public static void main(String[] args){
        System.out.print("Test _Error\n");
        System.out.print(String.format("This is a test error at position: (1,1)"));


        Position position = new Position(1,1);
        //_Error.create("\nThis is a test error at position:", position).printErrors();
        ErrorReporter er = new ErrorReporter();
        Position pos = new Position(1,2);
        _Error error = new _Error("test", pos);
        _Error error1 = new _Error("test", pos);
        _Error error2 = new _Error("test", pos);
        _Error error3 = new _Error("test", pos);
        er.record(error);
        er.record(error2);
        er.record(error3);
        er.record(error1);
        er.printErrors();
    }
}

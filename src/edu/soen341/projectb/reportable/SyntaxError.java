package edu.soen341.projectb.reportable;

public class SyntaxError extends Exception{


    //Empty constructor
    public SyntaxError(){
        msg = "Syntax error";
    }
    //Parameter constructors
    public SyntaxError(String msg){
        this.msg = msg;
    }
    public SyntaxError(String msg, Throwable cause){
        this.msg = msg;
        this.cause = cause;
    }
    //Setter
    public void setMessage(String msg){
        this.msg = msg;
    }
    //Getters
    public String getMessage(){
        return msg;
    }
    public Throwable getThrowable(){
        return cause;
    }


    //Attributes
    private String msg;
    private Throwable cause;
}

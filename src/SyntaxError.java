public class SyntaxError extends Exception implements IReportable{
    private String msg;
    private Throwable cause;
    public SyntaxError(){
        msg = "Syntax error";
    }
    public SyntaxError(String msg){
        this.msg = msg;
    }
    public SyntaxError(String msg, Throwable cause){
        this.msg = msg;
        this.cause = cause;
    }
    public String getMessage(){
        return msg;
    }
    public Throwable getThrowable(){
        return cause;
    }
    public void setMessage(String msg){
        this.msg = msg;
    }

    @Override
    public void record(_Error e) {
        // TODO Auto-generated method stub

    }
}

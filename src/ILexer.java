public interface ILexer {
    static int EOF = -1;
    static int ILLEGAL_CHAR = 9;
     Position position = null;
     ErrorReporter errorReporter = new ErrorReporter();
    int  getToken();
    String getTokenName(int t);
    private Position getPosition(){
        return position;
    }
    void error(String t);
}
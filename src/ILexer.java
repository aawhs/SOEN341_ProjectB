import java.io.IOException;

public interface ILexer {
    static int EOF = -1;
    static int EOL = '\n';
    int  getToken() throws IOException;
    String getTokenName(int t);
    public ISymbolTable getKeywordTable();
}
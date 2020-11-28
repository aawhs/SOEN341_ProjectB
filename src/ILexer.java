import java.io.IOException;
import java.util.Queue;

public interface ILexer {
    static int EOF = -1;
    static int EOL = '\n';
    Tokens getToken() throws IOException;
    String getTokenName(int t);
    Queue getKeywordTable();
    ISymbolTable getOpCodes();
    //boolean spellError(String line);
    Position getPosition();
}


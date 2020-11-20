import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;

public class Environment {
    //Constructors
    public Environment(String filePath) throws IOException, URISyntaxException {
        this.sourceFile = new SourceFile(filePath);
        this.reader = new Reader(sourceFile);
        this.keywordTable = new LinkedList();
        this.lexer = new Lexer(reader, keywordTable);
        this.errorReporter = new ErrorReporter();
        this.table = new SymbolTable();
    }

    public Environment() {
        this.lexer = null;
        this.sourceFile = null;
        this.errorReporter = null;
        this.table = null;
        this.keywordTable = null;

    }

    //Set functions
    public void setLexer(ILexer lexer) {
        this.lexer = lexer;
    }

    public void setSourceFile(ISourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setErrorReporter(IReportable errorReporter) {
        this.errorReporter = errorReporter;
    }

    public void setTable(ISymbolTable table) {
        this.table = table;
    }

    public void setKeywordTable(Queue keywordTable) {
        this.keywordTable = keywordTable;
    }

    //Get functions
    public ILexer getLexer() {
        return lexer;
    }

    public ISourceFile getSourceFile() {
        return sourceFile;
    }

    public IReportable getErrorReporter() {
        return errorReporter;
    }

    public ISymbolTable getTable() {
        return table;
    }

    public Queue getKeywordTable() {
        return keywordTable;
    }


    private ILexer        lexer;
    private ISourceFile   sourceFile;
    private IReportable   errorReporter;
    private ISymbolTable table;
    private Queue keywordTable;
    private IReader       reader;

    public LineStmtSeq getSeq() {
        return seq;
    }

    public void setSeq(LineStmtSeq seq) {
        this.seq = seq;
    }

    private LineStmtSeq seq;
    
}

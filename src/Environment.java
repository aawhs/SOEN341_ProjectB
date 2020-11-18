public class Environment {
    //Constructors
    public Environment(ILexer lexer, ISourceFile sourceFile, IReportable errorReporter
            , ISymbolTable table, ISymbolTable keywordTable) {
        this.lexer = lexer;
        this.sourceFile = sourceFile;
        this.errorReporter = errorReporter;
        this.table = table;
        this.keywordTable = keywordTable;
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

    public void setKeywordTable(ISymbolTable keywordTable) {
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

    public ISymbolTable getKeywordTable() {
        return keywordTable;
    }


    private ILexer        lexer;
    private ISourceFile   sourceFile;
    private IReportable   errorReporter;
    private ISymbolTable  table;
    private ISymbolTable  keywordTable;
    
}

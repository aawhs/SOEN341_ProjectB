public class Environment {
    ILexer lexer;
    SourceFile sourceFile;
    IReportable errorReporter;
    SymbolTable symbolTable;

    public Environment(){
        lexer = null;
        sourceFile = new SourceFile(sourceFile.getFileName());
        errorReporter = new ErrorReporter();
        symbolTable = new SymbolTable();
    }
    public Environment(ILexer lexer, SourceFile src, IReportable er, SymbolTable st){
        this.lexer = lexer;
        sourceFile = src;
        errorReporter = er;
        symbolTable = st;
    }
    
    //Set functions
    public void setLexer(ILexer lexer){
        this.lexer = lexer;
    }
    public void setSourceFile(SourceFile src){
        sourceFile = src;
    }
    public void setErrorReporter(ErrorReporter er){
        errorReporter = er;
    }
    public void setSymbolTable(SymbolTable st){
        symbolTable = st;
    }

    //Get functions
    public ILexer getLexer(){
        return lexer;
    }
    public SourceFile getSourceFile(){
        return sourceFile;
    }
    public IReportable getErrorReporter(){
        return errorReporter;
    }
    public SymbolTable getSymbolTable(){
        return symbolTable;
    }
    
}

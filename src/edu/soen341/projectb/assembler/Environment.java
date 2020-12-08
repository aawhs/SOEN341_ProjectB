package edu.soen341.projectb.assembler;
import edu.soen341.projectb.assembler.ILexer;
import edu.soen341.projectb.assembler.Lexer;
import edu.soen341.projectb.file.IReader;
import edu.soen341.projectb.file.ISourceFile;
import edu.soen341.projectb.file.Reader;
import edu.soen341.projectb.file.SourceFile;
import edu.soen341.projectb.nodes.ISymbolTable;
import edu.soen341.projectb.nodes.SymbolTable;
import edu.soen341.projectb.options.IOption;
import edu.soen341.projectb.options.OptionFactory;
import edu.soen341.projectb.reportable.ErrorReporter;
import edu.soen341.projectb.reportable.IReportable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.Queue;
    //The Goal of the Enviorment Class is to create the enviorment necessary to process the options and files for the parser and lexer
public class Environment {
    //Paramaterized Constructor Class for the Environment
    public Environment(String filePath, String args) throws IOException, URISyntaxException {
        this.sourceFile = new SourceFile(filePath);
        this.reader = new Reader(sourceFile);
        this.keywordTable = new LinkedList();
        this.lexer = new Lexer(reader, keywordTable);
        this.errorReporter = new ErrorReporter();
        this.table = new SymbolTable();
        this.optionFactory = new OptionFactory();
        switch(args){
            case "-l": case"-h": case"-v":
            case "-listing": case "-help": case "-verbose":
                this.options= optionFactory.getOption(args);
                break;
            default:
                this.options = optionFactory.getOption(null);
                break;
        }
    }
    //Basic Constructor Class for the Environment
    public Environment() {
        this.lexer = null;
        this.sourceFile = null;
        this.errorReporter = null;
        this.table = null;
        this.keywordTable = null;
    }
    //Basic Setter method in relation to Environment Object
    public void setLexer(ILexer lexer) {
        this.lexer = lexer;
    }
    //Basic Setter method in relation to Environment Object
    public void setSourceFile(ISourceFile sourceFile) {
        this.sourceFile = sourceFile;
    }
    //Basic Setter method in relation to Environment Object
    public void setErrorReporter(IReportable errorReporter) {
        this.errorReporter = errorReporter;
    }
    //Basic Setter method in relation to Environment Object
    public void setTable(ISymbolTable table) {
        this.table = table;
    }
    //Basic Setter method in relation to Environment Object
    public void setKeywordTable(Queue keywordTable) {
        this.keywordTable = keywordTable;
    }
    //Basic Setter method in relation to Environment Object
    public void setSeq(LineStmtSeq seq) {
        this.seq = seq;
    }
    //Basic Getter method in relation to Environment Object
    public ILexer getLexer() {
        return lexer;
    }
    //Basic Getter method in relation to Environment Object
    public ISourceFile getSourceFile() {
        return sourceFile;
    }
    //Basic Getter method in relation to Environment Object
    public IReportable getErrorReporter() {
        return errorReporter;
    }
    //Basic Getter method in relation to Environment Object
    public ISymbolTable getTable() {
        return table;
    }
    //Basic Getter method in relation to Environment Object
    public Queue getKeywordTable() {
        return keywordTable;
    }
    //Basic Getter method in relation to Environment Object
    public IOption getOptions() {
        return options;
    }
    //Basic Getter method in relation to Environment Object
    public LineStmtSeq getSeq() {
        return seq;
    }
    //Necessary Data Members for the Environment Class
    private ILexer lexer;
    private ISourceFile sourceFile;
    private IReportable errorReporter;
    private ISymbolTable table;
    private Queue keywordTable;
    private IReader reader;
    private LineStmtSeq seq;
    private IOption options;
    private OptionFactory optionFactory;
}

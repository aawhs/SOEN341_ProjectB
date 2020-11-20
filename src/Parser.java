/*
 * Parser_Skeleton.java - A parser gets tokens from the lexical analyser.
 *
 * @author  Michel de Champlain
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class Parser implements IParser {
    public Parser(Environment env) throws IOException {
        this.lexer = env.getLexer();
        this.sourceFile = env.getSourceFile();
        this.errorReporter = env.getErrorReporter();
        this.table = env.getTable();
        this.keywordTable = env.getKeywordTable();
        this.opCodes = lexer.getOpCodes();
        nextToken(); // prime
        if(token == 1000) {
            parse();
        }

        address = 0;
    }

    /*
    // Record the error: <t> expected, found <token> at <token>.position
    protected void expect(int t) {
        if (t != token) {
            String expected = lexer.getTokenName(t);
            errorReporter.record( _Error.create( expected+" expected", lexer.getPosition()) );
        }
        nextToken();
    }
    protected void expect(String t) {
        errorReporter.record( _Error.create(t+" expected", Lexer.getPosition()) );
    }
    protected void error(String t) {
        errorReporter.record( _Error.create(t, Lexer.getPosition()) );
    }

    private class SyntaxError extends Exception {}
    */


    // -------------------------------------------------------------------
    // An assembly unit is zero or more line statement(s).
    //
    // AssemblyUnit = { LineStmt } EOF .
    // -------------------------------------------------------------------
    @Override
    public Link parse() throws IOException {
        System.out.println("Parsing a AssemblyUnit...");

        seq = new LineStmtSeq();
        LineStmt lineStmt;
        int count = 0;
        FileWriter fileWriter = new FileWriter("S1Test1.txt");

        while (token != lexer.EOF) {
            String s = keywordTable.poll().toString();
            lineStmt = parseLineStmt(s);
            seq.add(lineStmt);
            //System.out.println(seq.pop().getInstruction().printInstruction());
            fileWriter.write(seq.pop().getInstruction().printInstruction());
            count++;
            nextToken();
        }

        return new TranslationUnit(seq);
    }
    //---------------------------------------------------------------------------------
    private Instruction parseInherent(Instruction inst, String line) {
        // your code...
        /**
         * Input: String
         * Output: Saves mnemonic and opcode in inst object
         */
        inst.parseMnemonic(line);
        return inst;
    }
    //---------------------------------------------------------------------------------
    private Instruction parseImmediate() {
        // your code...
        return new Instruction();
    }
    //---------------------------------------------------------------------------------
    private Instruction parseRelative() {
        // your code...
        return new Instruction();
    }
    // -------------------------------------------------------------------
    // A line statement:
    //   - could be empty (only a EOL);
    //   - could have a single comment start at BOL or after a label, label/inst, or label/dir;
    //   - could have a label only, etc.
    //
    // LineStatement = [Label] [Instruction | Directive ] [Comment] EOL .
    //
    public LineStmt parseLineStmt(String line) {
        Label        label = null;
        Instruction  inst = new Instruction();
        Comment      comment = null;

        System.out.println("Parsing a Line Statement...");

        //parseLabel(); TODO: parse the label in a line statement - create a function to translate label
        //parseComment(); TODO: parse the comment in a line statement - create a function to translate the comment

        /**
         * Inputs: Instruction, String
         * Output: void, saves mnemonic and respective opcode in object variables
         */
        inst = parseInherent(inst, line);

        return new LineStmt(label, inst, comment);
    }

    protected void nextToken() throws IOException {
        token = lexer.getToken();
    }

    private int           token;
    private int           address;
    private ILexer        lexer;
    private ISourceFile   sourceFile;
    private IReportable   errorReporter;
    private ISymbolTable table;
    private Queue keywordTable;
    private ISymbolTable opCodes;

    public LineStmtSeq getSeq() {
        return seq;
    }

    private LineStmtSeq   seq;

}


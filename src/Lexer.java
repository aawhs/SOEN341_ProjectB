/*
 * Lexer_Skeleton.java - A lexical analyser extracts tokens by reading
 *                       characters from a source file (.asm) for the parser.
 *
 * @author  Michel de Champlain
 */

import java.io.*;
import java.net.URISyntaxException;


public class Lexer implements ILexer, Opcode {
    /** Create a lexer that scans the given character stream. */
    public Lexer(IReader reader, ISymbolTable keywordTable) throws FileNotFoundException, URISyntaxException {
        this.reader = reader;
        this.keywordTable = keywordTable;
        errorReporter = new ErrorReporter();



        // Enter all mnemonics as keywords in the symbol table...
        linePos = 1;
        colPos = 0;
        curlinePos = linePos;
        curcolPos = colPos;
        position = new Position(curlinePos, curcolPos);
        read();

    }

    /* Read the next character. */
    private int read() {
        colPos++;
        return this.ch = reader.read();
    }

     public void error(String t) {
        errorReporter.record(_Error.create(t, getPosition()));
    }

    private void scanNumber() {
        // your code...
    }
    private int scanIdentifier() {
        // your code...
        return 0;
    }
    private int scanDirective() {
        // your code...
        return 0;
    }
    private int scanString() {
        // your code...
        return 0;
    }
    /**
     * Scan the next token. Mark position on entry in case of error.
     * @return   the token.
     */
    public int getToken() {
        // skip whitespaces
        // "\n", "\r\n", "\n", or line comments are considered as EOL

        // your code...

        // Mark position (after skipping blanks)
        curlinePos = linePos;
        curcolPos = colPos;

        while (true) {
            switch ( ch ) {

                case -1:
                    return EOF;
                case 'a': case 'b': case 'c': case 'd': case 'e':
                case 'f': case 'g': case 'h': case 'i': case 'j':
                case 'k': case 'l': case 'm': case 'n': case 'o':
                case 'p': case 'q': case 'r': case 's': case 't':
                case 'u': case 'v': case 'w': case 'x': case 'y':
                case 'z':
                case 'A': case 'B': case 'C': case 'D': case 'E':
                case 'F': case 'G': case 'H': case 'I': case 'J':
                case 'K': case 'L': case 'M': case 'N': case 'O':
                case 'P': case 'Q': case 'R': case 'S': case 'T':
                case 'U': case 'V': case 'W': case 'X': case 'Y':
                case '_':
                case 'Z':
                    return scanIdentifier();

                case '.':  /* dot for directives as a first character */
                    return scanDirective();
                case ';'
                    return COMMENT;


                case '0': case '1': case '2': case '3': case '4':
                case '5': case '6': case '7': case '8': case '9':
                    scanNumber();
                    return NUMBER;

                case '-':
                    read(); return MINUS;

                case ',':
                    read(); return COMMA;

                case '"':
                    return scanString();

                default:
                    read(); return ILLEGAL_CHAR;
            }
        }
    }

    @Override
    public String getTokenName(int t) {
        return null;
    }

    private Position getPosition(){
        return position;
    }
    public boolean numError(){
        if ((this.getToken() == this.COMMENT))
            return false;
        if (this.getToken() == this.NUMBER && (this.getPosition().getColPos() >= 0) && (this.getPosition().getColPos() <= 0)){
            this.error("Unexpected digit error.");
            return true;
        }
        return false;
    }

    private int linePos = 1;
    private int colPos = 0;
    private int curlinePos = linePos;
    private int curcolPos = colPos;

    private final Integer MINUS = 101,
                            COMMA= 102 ,
                            ILLEGAL_CHAR = 103,
                            NUMBER= 104,
                            COMMENT = 105;

    private int ch;
    private IReader reader;
    private IReportable errorReporter;
    private ISymbolTable keywordTable;
    private Position position;

}

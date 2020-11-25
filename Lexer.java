import java.io.*;
import java.util.Queue;

public class Lexer implements ILexer, Opcode {
    /** Create a lexer that scans the given character stream. */
    public Lexer(IReader reader, Queue keywordTable) throws IOException {
        //Define Helpers
        this.reader = reader;
        this.keywordTable = keywordTable;


        opCodes = new SymbolTable();

        //Populate opcode ST
        for(int i = 0; i < inherentOpcodes.length ; i++){
            opCodes.put(inherentMnemonics[i], inherentOpcodes[i]);
        }

        //Instantiate Position Variables

        linePos = 1;
        colPos = 0;
        curlinePos = linePos;
        curcolPos = colPos;

        tokenSwitch = true;
        mnemonic ="";
        read();
    }

    /* Read the next character. */
    private int read() throws IOException {
        colPos++;
        return (ch = reader.read());
    }



    private void error(String t) {

        //errorReporter.record(_Error.create(t, getPosition()));
    }

    private void scanNumber() {
        value+=ch;
        while() {
        	
        }
        position = new Position(curlinePos,curcolPos);
        linePos++;
        getToken();
        
    }
    private int scanIdentifier() throws IOException {
        mnemonic += (char)ch;
        while ((ch = read()) != '\n'){
            mnemonic += (char)ch;
        }
        //System.out.println(mnemonic);
        position = new Position(curlinePos,curcolPos);
        keywordTable.add(mnemonic);
        linePos++;
        return 1000;
    }
    private int scanDirective() {

        return 0;
    }
    private int scanString() {
        return 0;
    }
    /**
     * Scan the next token. Mark position on entry in case of error.
     * @return   the token.
     */
    public int getToken() throws IOException {
        // skip whitespaces
        // "\n", "\r\n", "\n", or line comments are considered as EOL

            while(ch == '\n' || ch == '\r' || ch == ' ' || ch == ';'){
                ch = read();
                mnemonic ="";
            }
            curlinePos = linePos;
            curcolPos = colPos;
            while (tokenSwitch) {
                switch ( ch ) {
                    case -1:
                        tokenSwitch = false;
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
            return 0;

    }

    @Override
    public String getTokenName(int t) {
        return null;
    }

    private int linePos;
    private int colPos;
    private int curlinePos;
    private int curcolPos;
    private int ch;
    private String mnemonic;
    private Integer value;
    private IReader reader;

    public Queue getKeywordTable() {
        return keywordTable;
    }


    private Queue keywordTable;

    public ISymbolTable getOpCodes() {
        return opCodes;
    }

    public boolean spellError(String line){
        for(int i = 0; i< inherentMnemonics.length; i++){
            if(inherentMnemonics[i].contains(line)){
                this.error("Spelling error");
                return true;
            }
        }
        return false;
    }

    private final Integer   MINUS = 1001,
                            COMMA= 1002 ,
                            ILLEGAL_CHAR = 1003,
                            NUMBER= 1004;


    private ISymbolTable opCodes;
    private IReportable errorReporter;

    public Position getPosition() {
        return position;
    }

    private Position position;
    private boolean tokenSwitch;

}
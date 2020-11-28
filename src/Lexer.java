import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Lexer implements ILexer, Opcode {
    /** Create a lexer that scans the given character stream. */
    public Lexer(IReader reader, Queue table) throws IOException {
        //Define Helpers
        this.reader = reader;
        this.table = table;
        keywordsTable = new SymbolTable();


        opCodes = new SymbolTable();

        //Populate opcode ST
        for(int i = 0; i < inherentOpcodes.length ; i++){
            opCodes.put(inherentMnemonics[i], inherentOpcodes[i]);
        }


        for(int i = 0; i < immediateOpcodes.length; i++){
            opCodes.put(immediateMnemonics[i], immediateOpcodes[i]);
            keywordsTable.put(immediateMnemonics[i], Tokens.IMMEDIATE);
        }

        //Instantiate Position Variables
        linePos = 1;
        colPos = 0;
        curlinePos = linePos;
        curcolPos = colPos;

        tokenSwitch = true;
        mnemonic ="";
        read(); //prime
    }

    /* Read the next character. */
    private int read() throws IOException {
        colPos++;
        return (ch = reader.read());
    }

    private int scanComment(){
        /*public String parseComment(String c){
            boolean cmt = false;
            String str = "";
            for(int i = 0; i < c.length(); i++){
                if(cmt == true){
                    str = str + c.charAt(i);
                }
                if(c.charAt(i) == commentStart){
                    cmt = true;
                }
                if(c.charAt(i) == EOL){
                    return str;
                }
            }
            return str;
        }
        */
      String str = "";
      str += (char)ch;

      while((ch = read()) != '\n'){
          str += (char)ch;
      }
      String commenString = str.substring(str.indexOf(";"), str.length());
      position = new Position(curcolPos,curcolPos);
      table.add(commenString);
      linePos++;
      return 1000;
    }

    private void error(String t) {

        //errorReporter.record(_Error.create(t, getPosition()));
    }

    private void scanNumber() {

        strnum += (char)ch;
        char numoff;
        while((ch = read()) != '\n'){
            strnum += (char)ch;
        }
        for(int i = 0; i < strnum.length(); i++){
            if(Number.contains(strnum.charAt(i)) && ((strnum.charAt(i-1) == ' ' && strnum.charAt(i+1) == ' '))){
                numoff = strnum.charAt(i);            }
        }
        position = new Position(curlinePos,curcolPos);
        keywordTable.add(numoff);
        linePos++;
    }
   

    }
    private Tokens scanIdentifier() throws IOException {
        temp += (char)ch;
        while(((ch = read()) != '\n')){
            temp += (char)ch;
        }
        if(keywordsTable.contains(temp)){
            position = new Position(curlinePos,curcolPos);
            table.add(temp);
            linePos++;
            return (Tokens) keywordsTable.get(temp);

        }
        position = new Position(curlinePos,curcolPos);
        table.add(temp);
        linePos++;

        return Tokens.LABEL;

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
                        read(); 
                        scanNumber();
                        return MINUS;

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
    private IReader reader;
    private String commenString;
    private String strnum;
    private ArrayList <Integer> Number = new ArrayList<Integer>(Arrays.asList(-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9));


    public Queue getTable() {
        return table;
    }

    private int linePos = 1;
    private int colPos = 0;
    private int curlinePos = linePos;
    private int curcolPos = colPos;
    public boolean spellError(String line){
        for(int i = 0; i<inherentMnemonics.length; i++){
            if(inherentMnemonics[i].contains(line)){
                this.error("Spelling error");
                return true;
            }
        }
        return false;
    }


    private Queue table;
    private ISymbolTable keywordsTable;


    public ISymbolTable getOpCodes() {
        return opCodes;
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

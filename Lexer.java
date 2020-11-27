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
		stringHolder ="";
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

	}
	private int scanIdentifier() throws IOException {
		//Temporary "stringHolder" variable before lookup
		stringHolder += (char)ch;
		//Populate the stringHolder variable
		while ((ch = read()) != '\n'){
			stringHolder += (char)ch;
		}
		if(stringHolder.charAt(0)==';') {
			Comment comment=new Comment(stringHolder);
		}
		//lookup in symbol table
		if(opCodes.contains(stringHolder) || position.getColPos()!=1) {
			keywordTable.add(stringHolder);
			position = new Position(curlinePos,curcolPos);
			linePos++;
			return 1000; 
		}
		else {
			position = new Position(curlinePos,curcolPos);
			linePos++;
			return 1001;
		}        
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
			stringHolder ="";
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
			case ';':
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

	public Queue getKeywordTable() {
		return keywordTable;
	}

	public ISymbolTable getOpCodes() {
		return opCodes;
	}

	public Position getPosition() {
		return position;
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

	private int linePos;
	private int colPos;
	private int curlinePos;
	private int curcolPos;
	private int ch;
	private String stringHolder;
	private Integer value;
	private IReader reader;
	private String commentTest;
	private ISymbolTable opCodes;
	private IReportable errorReporter;
	private Queue keywordTable;
	private Position position;
	private boolean tokenSwitch;

}

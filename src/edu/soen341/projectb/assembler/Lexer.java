package edu.soen341.projectb.assembler;

import edu.soen341.projectb.file.IReader;
import edu.soen341.projectb.helper.Position;
import edu.soen341.projectb.nodes.ISymbolTable;
import edu.soen341.projectb.nodes.SymbolTable;
import edu.soen341.projectb.reportable.IReportable;
import edu.soen341.projectb.reportable._Error;

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
		for(int i = 0; i < Opcode.inherentOpcodes.length ; i++){
			opCodes.put(Opcode.inherentMnemonics[i], Opcode.inherentOpcodes[i]);
			keywordsTable.put(Opcode.inherentMnemonics[i], Tokens.INHERENT);
		}


		for(int i = 0; i < Opcode.immediateOpcodes.length; i++){
			opCodes.put(Opcode.immediateMnemonics[i], Opcode.immediateOpcodes[i]);
			keywordsTable.put(Opcode.immediateMnemonics[i], Tokens.IMMEDIATE);
		}

		for(int i = 0; i < Opcode.relativeOpcodes.length; i++){
			opCodes.put(relativeMnemomnics[i], Opcode.relativeOpcodes[i]);
			keywordsTable.put(Opcode.relativeMnemomnics[i], Tokens.RELATIVE);
		};

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

	private Tokens scanComment() throws IOException {
		String str = "";
		str += (char)ch;
		while((ch = read()) != '\n'){
			str += (char)ch;
		}
		String commentString = str.substring(str.indexOf(";"), str.length());
		position = new Position(curlinePos,curcolPos);
		table.add(commentString);
		return Tokens.COMMENT;
	}

	private void error(String t) {

		errorReporter.record(_Error.create(t, getPosition()));
	}

	private Tokens scanNumber() throws IOException {

		strnum = "";
		strnum += (char)ch;
		char numoff = 0;
		while((ch = read()) != '\n' && (ch != 32)){
			strnum += (char)ch;
		}
		/*
		for(int i = 0; i < strnum.length(); i++){
			if(Number.contains(strnum.charAt(i)) && ((strnum.charAt(i-1) == ' ' && strnum.charAt(i+1) == ' '))){
				numoff = strnum.charAt(i);            }
		}

		 */
		position = new Position(curlinePos,curcolPos);
		table.add(strnum);
		return  Tokens.NUMBER;
	}

	private Tokens scanIdentifier() throws IOException {
		temp = "";
		temp += (char)ch;
		while((ch = read()) != '\n' && (ch != 32)){
			temp += (char)ch;
			if(keywordsTable.contains(temp)){
				position = new Position(curlinePos,curcolPos);
				table.add(temp);
				read();
				return (Tokens) keywordsTable.get(temp);
			}
		}
		position = new Position(curlinePos,curcolPos);
		table.add(temp);
		return Tokens.LABEL;
	}

	private Tokens scanDirective() throws IOException {
		temp = "";
		temp += (char)ch;
		while(((ch = read()) != 32)){
			temp += (char)ch;
		}

		if(temp.contains(".cstring")){
			/*
			if(temp.contains("")){
				String sub = temp.substring(temp.indexOf("\"") + 1, temp.indexOf("\"") + 3);
				sub = sub + " " + "NUL";
				position = new Position(curlinePos,curcolPos);
				table.add(sub);
				return Tokens.DIRECTIVE;
			}
			*/

			position = new Position(curlinePos,curcolPos);
			table.add(temp);
			read();
			return Tokens.DIRECTIVE;
		}
		return Tokens.ILLEGAL_CHAR;
	}

	private Tokens scanString() throws IOException{
		temp = "";
		temp += (char)ch;
		while(((ch = read()) != '\n' && (ch != 32))){
			temp += (char)ch;
		}
		table.add(temp);
		position = new Position(curlinePos,curcolPos);
		return Tokens.STRING;
	}

	public Tokens getToken() throws IOException {
		// skip whitespaces
		// "\n", "\r\n", "\n", or line comments are considered as EOL
		while(ch == 32){
			read();
		}

		curlinePos = linePos;
		curcolPos = colPos;
		while (tokenSwitch) {
			switch ( ch ) {
				case '\n': case '\r':
					colPos = 0;
					linePos++;
					read();
					return Tokens.EOL;
				case -1:
					tokenSwitch = false;
					return Tokens.EOF;

				case ';':
					return scanComment();

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
					return Tokens.NUMBER;

				case '-':
					read();
					scanNumber();
					return Tokens.MINUS;

				case ',':
					read(); return Tokens.COMMA;

				case '"':
					return scanString();


				default:
					read(); error("Illegal char"); return Tokens.ILLEGAL_CHAR;
			}
		}
		return Tokens.EOF;

	}

	@Override
	public String getTokenName(Tokens t) {
		return t.name();
	}



	public Queue getTable() {
		return table;
	}

	public boolean spellError(String line){
		for(int i = 0; i< Opcode.inherentMnemonics.length; i++){
			if(Opcode.inherentMnemonics[i].contains(line)){
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

	private ISymbolTable opCodes;
	private IReportable errorReporter;

	public Position getPosition() {
		return position;
	}

	private Position position;
	private boolean tokenSwitch;

	private int linePos;
	private int colPos;
	private int curlinePos;
	private int curcolPos;
	private int ch;
	private String temp="";
	private String mnemonic;
	private IReader reader;
	private String commenString;
	private String strnum ="";
	private ArrayList <Integer> Number =
			new ArrayList<Integer>(Arrays.asList(
					-9,-8,-7,-6,-5,-4,-3,-2,-1,
					0,1,2,3,4,5,6,7,8,9));
}

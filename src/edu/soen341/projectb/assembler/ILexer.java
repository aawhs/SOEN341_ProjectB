package edu.soen341.projectb.assembler;
import edu.soen341.projectb.helper.Position;
import edu.soen341.projectb.nodes.ISymbolTable;
import java.io.IOException;
import java.util.Queue;
    //Interface implementation of the Lexer used as a template where the methods below will be instantiated properly in the lexer
public interface ILexer {
    //Template of a Basic Getter method in relation to ILexer Interface
    Tokens getToken() throws IOException;
    //Template of a Basic Getter method in relation to ILexer Interface
    String getTokenName(Tokens t);
    //Template of a Basic Getter method in relation to ILexer Interface
    Queue getTable();
    //Template of a Basic Getter method in relation to ILexer Interface
    ISymbolTable getOpCodes();
    //Template of a Basic Getter method in relation to ILexer Interface
    Position getPosition();
    //Necessary Data Members for the ILexer Interface
    static int EOF = -1;
    static int EOL = '\n';
}


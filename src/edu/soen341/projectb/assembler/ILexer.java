package edu.soen341.projectb.assembler;

import edu.soen341.projectb.helper.Position;
import edu.soen341.projectb.nodes.ISymbolTable;

import java.io.IOException;
import java.util.Queue;

public interface ILexer {
    static int EOF = -1;
    static int EOL = '\n';
    Tokens getToken() throws IOException;
    String getTokenName(Tokens t);
    Queue getTable();
    ISymbolTable getOpCodes();
    //boolean spellError(String line);
    Position getPosition();
}


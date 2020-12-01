package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;

public interface IReader {
    int linePos = 0;
	int colPos = 0;
	int curlinePos = 0;
	int curcolPos = 0;
	void openFile() throws FileNotFoundException, URISyntaxException;
    void readFile() throws IOException;
    void scanCharacters();
    int read() throws IOException;
   /* public void parseLineStmt();
    public void parseInstruction(); // Parses all instructions from lineStatements
*/
}

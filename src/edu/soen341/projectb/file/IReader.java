//IReader interface which contains all the methods and fields needed to read the input file
package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;

public interface IReader {
	//open and read file methods
	void openFile() throws FileNotFoundException, URISyntaxException;
    void readFile() throws IOException;
    //Methods for reading and scanning chars
    void scanCharacters();
    int read() throws IOException;
    //Variables for lines and columns
    int linePos = 0;
    int colPos = 0;
    int curlinePos = 0;
    int curcolPos = 0;

}

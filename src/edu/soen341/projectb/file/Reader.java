//Reader class which handles the reading and scanning of the input files
package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;

public class Reader implements IReader {
    //Constructor which initializes the source file,opens it and connects to it
    public Reader(ISourceFile srcFile) throws FileNotFoundException, URISyntaxException {
        this.srcFile = srcFile;
        openFile();
        fileReader = new BufferedReader(new FileReader(srcFile.getFile().getPath()));
    }
    //Methods to open the file and read the its content
    public void openFile() throws FileNotFoundException, URISyntaxException {
        srcFile.openInputStream();
        srcFile.canReadFile();
    }

    public void readFile() throws IOException {
        ch_num = fileReader.read();
        //System.out.print(ch =(char)ch_num);
    }

    public void scanCharacters(){

    }
    //Methods to read chars and strings
    public int read() throws IOException {
        readFile();
        return ch_num;
    }

    public String readString() throws IOException{
        line = fileReader.readLine();
        return line;
    }
    //Variables that store file elements
    private ISourceFile srcFile;
    private BufferedReader fileReader;
    //Variables for counters, characters and strings read
    private int ch_num = 0;
    private char ch;
    private String line;
    //*Variables*
    private int colPos=0;
    private int rowPos=0;
    private int size = 0;
    private Character [][] charactersList = new Character[50][500];
    private String[] lineStatements = new String[50];
    private String[] instructions = new String[50];
}

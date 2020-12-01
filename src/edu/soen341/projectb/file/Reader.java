package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;

public class Reader implements IReader {
    public Reader(ISourceFile srcFile) throws FileNotFoundException, URISyntaxException {
        this.srcFile = srcFile;
        openFile();
        fileReader = new BufferedReader(new FileReader(srcFile.getFile().getPath()));
    }
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

    public int read() throws IOException {
        readFile();
        return ch_num;
    }

    public String readString() throws IOException{
        line = fileReader.readLine();
        return line;
    }

    private ISourceFile srcFile;
    private BufferedReader fileReader;
    private int ch_num = 0;
    private char ch;
    private String line;
    private int colPos=0;
    private int rowPos=0;
    private int size = 0;
    private Character [][] charactersList = new Character[50][500];
    private String[] lineStatements = new String[50];
    private String[] instructions = new String[50];
}

package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;

public interface ISourceFile {
    String getFileName();
    boolean canReadFile();
    boolean isOpen();
    void setFilePath() throws URISyntaxException;
    void openFile() throws URISyntaxException;
    File getFile();
    void openInputStream() throws FileNotFoundException, URISyntaxException;
    void openOutputStream() throws FileNotFoundException, URISyntaxException;
    void close() throws IOException;
    void dstFilePath();
    FileInputStream getFileInStream();
    FileOutputStream getFileOutStream();
}


//SourceFile class that deals with the handling of the source (input) files
package edu.soen341.projectb.file;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

//Managing file with open, close and input/output stream initializing
public class SourceFile implements ISourceFile {
    //Constructor that sets source file to the argument in the main function
    public SourceFile(String args) {
        this.fileName = args;
    }


    //Creates File object for the input file
    public void openFile() throws URISyntaxException {

        srcFile = new File(filePathSystem.toURI());

    }

    //Create input stream for the file
    public void openInputStream() throws FileNotFoundException, URISyntaxException {
        setFilePath();
        openFile();
        assert canReadFile();
        srcStream = new FileInputStream(srcFile);
        assert isOpen();
    }

    //Create output stream for the file
    public void openOutputStream() throws FileNotFoundException {
        dstFile = new File(fileName);
        dstStream = new FileOutputStream(dstFile);
    }

    //Close file
    public void close() throws IOException {
        if(srcStream != null)
            srcStream.close();
        if(dstStream != null)
            dstStream.close();
    }

    //Reset file
    public void reset() throws IOException, URISyntaxException {
        srcStream.close();
        openInputStream();
    }

    //Overriden method to check if file is readable
    @Override
    public boolean canReadFile() {
        if (!srcFile.canRead()) {
            System.out.println("\nSource File");
            System.out.println("Cannot open srcFile '" + srcFile.getName() + "'");
            return false;
        }
        System.out.println("\nSource File");
        System.out.println("[OK] srcFilePath = '" + getAbsolutePath() +"'\n"+
                "[OK] srcFileName = '" + srcFile.getName() + "'");
        return true;

    }
    //Overriden method to check if file is open
    @Override
    public boolean isOpen() {
        if (srcStream != null) {
            return true;
        }
        System.out.println("\nCannot open srcFile '" + fileName + "'");
        return false;
    }
    //returns destination file path
    public void dstFilePath(){
        System.out.println("\nDestination File");
        System.out.println("[OK] dstFilePath = '" + getAbsolutePath() +"'\n"+
                "[OK] dstFileName = '" + dstFile.getName() + "'");
    }
    //Initializes the filepath of the file
    public void setFilePath() {
        srcPath = Paths.get(fileName);
        filePathSystem = ClassLoader.getSystemResource(srcPath.toString());
    }
    //Setter for bufferedReader object
    public void setBufferedReader() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(getFile()));
    }
    //Getter methods for file and streams
    public File getFile(){
        return this.srcFile;
    }

    public FileInputStream getFileInStream() {
        return this.srcStream;
    }

    public FileOutputStream getFileOutStream(){
        return  this.dstStream;
    }

    //Return the absolute path of the file
    public String getAbsolutePath(){
        if(dstFile != null)
            return dstFile.getAbsolutePath();
        else if (srcFile != null)
            return srcFile.getAbsolutePath();
        else
            return "No Path";
    }

    //Returns file name
    public String getFileName(){
        return this.fileName;
    }
    //Return bufferedReader object
    public BufferedReader getBufferedReader(){
        return reader;
    }



    //Variables for files,streams and readers
    Path srcPath;
    private URL filePathSystem;
    private String fileName;
    private File srcFile;
    private File dstFile;
    private FileInputStream srcStream;
    private FileOutputStream dstStream;
    private BufferedReader reader;
}

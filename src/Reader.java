import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public Reader(String filepath) throws FileNotFoundException, URISyntaxException {
        srcFile = new SourceFile(filepath);
        openFile();
    }
    public void openFile() throws FileNotFoundException, URISyntaxException {
        srcFile.openInputStream();
        srcFile.canReadFile();
    }

    public void readFile() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(srcFile.getFile().getPath()));
        while((ch_num = fileReader.read())!= -1) {
            ch = (char) ch_num;
            charactersList[rowPos][colPos] = ch;
            if(ch != '\n'){
                colPos++;
            }
            else{
                rowPos++;
            }
        }
        for(int i = 0; i < rowPos; i++){
           for(int j = 0; j < colPos; j++){
               if(charactersList[i][j] != null)
                System.out.print(charactersList[i][j]);
           }
        }
        
        fileReader.close();
    }

    public void scanCharacters(){

    }

    public char getCharacter(){
        return ch;
    }
    
    public void parseLineStmt() // Parses all line statement from charactersList
    {
    	for (int i = 0; i < lineStatements.length; i++)
    	{
    		String lineStatement = "";
    		
    		for (int j = 0; j < charactersList[i].length; j++)
    		{
    			lineStatement += charactersList[i][j].charValue();
    		}
    		
    		lineStatements[i] = lineStatement;
    	}
    }
    
    public void parseInstruction() // Parses all instructions from lineStatements
    {
    	for (int i = 0; i < lineStatements.length; i++)
    	{
    		String[] tokens = lineStatements[i].split("\\s");
    		
    		for (int j = 0; j < tokens.length; j++)
    		{
    			if (Opcode.isOpcode(tokens[j]))
    			{
    				instructions[i] = tokens[j];
    			}
    		}
    	}
    }

    private ISourceFile srcFile;
    private int ch_num = 0;
    private char ch;
    private int colPos=0;
    private int rowPos=0;
    private int size = 0;
    private Character [][] charactersList = new Character[50][500];
    private String[] lineStatements = new String[50];
    private String[] instructions = new String[50];
}

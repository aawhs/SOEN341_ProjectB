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
    }

    public void scanCharacters(){

    }

    public char getCharacter(){
        return ch;
    }






    private ISourceFile srcFile;
    private int ch_num = 0;
    private char ch;
    private int colPos=0;
    private int rowPos=0;
    private int size = 0;
    private Character [][] charactersList = new Character[50][500];


}

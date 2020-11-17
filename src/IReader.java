import java.io.*;
import java.net.URISyntaxException;

public interface IReader {
    int linePos = 0;
	int colPos = 0;
	int curlinePos = 0;
	int curcolPos = 0;
	public void openFile() throws FileNotFoundException, URISyntaxException;
    public void readFile() throws IOException;
    public void scanCharacters();
    public char getCharacter();
    public void parseLineStmt();
    public void parseInstruction(); // Parses all instructions from lineStatements

}

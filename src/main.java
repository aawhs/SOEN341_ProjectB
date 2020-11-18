import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class main {
    public static void main(String args[]) throws IOException, URISyntaxException {
       Reader reader = new Reader("S1Test1.asm");
       reader.readFile();

       SymbolTable st = new SymbolTable();
       ArrayList<Character> ch = new ArrayList<>();
       st.put(0, ch);

    }
}

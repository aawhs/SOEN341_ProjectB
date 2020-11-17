import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class main {
    public static void main(String args[]) throws IOException, URISyntaxException {
       Reader reader = new Reader("S1Test1.asm");
       reader.readFile();
    }
}

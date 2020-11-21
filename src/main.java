import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class main {
    public static void main(String args[]) throws IOException, URISyntaxException {
       Environment env = new Environment("S1Test1.asm");
       Parser parser = new Parser(env);

    }
}

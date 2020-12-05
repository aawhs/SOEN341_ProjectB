package edu.soen341.projectb;

import edu.soen341.projectb.assembler.Environment;
import edu.soen341.projectb.assembler.Parser;

import java.io.IOException;
import java.net.URISyntaxException;

public class CmAssembler {
    public static void main(String[] args) throws IOException, URISyntaxException {
        args = new String[]{"-l"};
        Environment env = new Environment("S1Test1.asm",args[0]);
        Parser parser = new Parser(env);
    }
}

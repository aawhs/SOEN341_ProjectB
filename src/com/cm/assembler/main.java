package com.cm.assembler;

import java.io.IOException;
import java.net.URISyntaxException;

public class main {
    public static void main(String args[]) throws IOException, URISyntaxException {
        args = new String[]{"-l"};
        Environment env = new Environment("com/cm/assembler/S1Test1.asm",args[0]);
        Parser parser = new Parser(env);
    }
}

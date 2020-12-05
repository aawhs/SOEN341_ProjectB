package edu.soen341.projectb.assembler;

import edu.soen341.projectb.binary.*;
import edu.soen341.projectb.nodes.*;
import edu.soen341.projectb.options.*;
import edu.soen341.projectb.file.ISourceFile;
import edu.soen341.projectb.file.SourceFile;
import edu.soen341.projectb.reportable._Error;
import edu.soen341.projectb.reportable.ErrorReporter;
import edu.soen341.projectb.reportable.IReportable;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class Parser implements IParser {
    public Parser(Environment env) throws IOException {
        this.lexer = env.getLexer();
        this.sourceFile = env.getSourceFile();
        this.errorReporter = env.getErrorReporter();
        this.table = env.getTable();
        this.keywordTable = env.getKeywordTable();
        this.opCodes = lexer.getOpCodes();
        this.options = env.getOptions();
        nextToken(); // prime
        parse();


        address = 0;
    }


    // Record the error: <t> expected, found <token> at <token>.position
    
    protected void expect(Tokens t) throws IOException {
        if (t != token) {
            String expected = lexer.getTokenName(t);
            errorReporter.record( _Error.create( expected+" expected", lexer.getPosition()));
            errorReporter.getException();
            System.out.println(expected);
            nextToken();
        }
    }

     
    /*protected void expect(String t) {
        errorReporter.record( _Error.create(t+" expected", lexer.getPosition()) );
    }
    protected void error(String t) {
        errorReporter.record( _Error.create(t, lexer.getPosition()) );
    }

    private class SyntaxError extends Exception {}
    */


    // -------------------------------------------------------------------
    // An assembly unit is zero or more line statement(s).
    //
    // AssemblyUnit = { LineStmt } EOF .
    // -------------------------------------------------------------------
    private void printLabel(FileWriter fr, File file) throws IOException{
        if (options.isEnabled() &&
        options.isRequired() &&
        options.getClass().getSimpleName().equals("ListingOption")) {
    System.out.println("Listing File : " + file.getAbsolutePath());
    fr.write(String.format("%1s%10s%15s%10s%20s%20s\n",
            "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
        }else if (options.getClass().getSimpleName().equals("VerboseOption")&&options.isEnabled() && options.isRequired()) {
    
        System.out.print(String.format("%1s%10s%15s%10s%20s%20s\n",
                "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
    } else {
        options.printUsage();
    }


    };

    public LinkedQueue parse() throws IOException {
        System.out.println("Parsing an AssemblyUnit...");



        seq = new LineStmtSeq();
        GenerateBinary binary = new GenerateBinary(seq);
        LineStmt lineStmt ;


        int count = 0;
        File file = new File("S1Test1.lst");
        FileWriter fr = new FileWriter(file);


         /*
            if (options.isEnabled() &&
                    options.isRequired() &&
                    options.getClass().getSimpleName().equals("ListingOption")) {
                System.out.println("Listing File : " + file.getAbsolutePath());
                fr.write(String.format("%1s%10s%15s%10s%20s%20s\n",
                        "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
            }
            if (options.getClass().getSimpleName().equals("VerboseOption")) {
                if (options.isEnabled() && options.isRequired()) {
                    System.out.print(String.format("%1s%10s%15s%10s%20s%20s\n",
                            "Line", "Address", "Machine Code", "Label", "Assembly Code", "Comment") + "\n");
                } else {
                    options.printUsage();
                }
            }
        */

            printLabel(fr,file);
            while (!token.equals(Tokens.EOF) ) {
                if(!token.equals(Tokens.EOL)){
                    if(!keywordTable.isEmpty()){
                        String s = keywordTable.poll().toString();

                        lineStmt = parseLineStmt(s);
                        seq.add(lineStmt);
                        String[] inst = seq.pop().getInstruction().printInstruction();
                        binary.getInstructions().add(inst);


                        if (options.isEnabled() && options.isRequired() &&
                                options.getClass().getSimpleName() == "ListingOption") {
                            fr.write(String.format("%02d\t   %#04X\t\t %4s\t\t\t\t\t\t  %-4s",
                                    lexer.getPosition().getLinePos(), address, inst[0], inst[1]) + "\n");
                        } else if (options.getClass().getSimpleName() == "VerboseOption") {
                            if (options.isEnabled() && options.isRequired()) {
                                System.out.print(String.format("%02d\t   %#04X\t\t %4s\t\t\t\t\t\t  %-4s",
                                        lexer.getPosition().getLinePos(), address, inst[0], inst[1]) + "\n");
                            } else {
                                options.printUsage();
                            }
                        }


                        count++;
                        address++;
                        nextToken();
                    }
                } else{
                    nextToken();
                }
            }

            System.out.print("Assembly Unit (Mnemonics) processed and stored in Nodes");
            if (!options.isEnabled()) {
                System.out.print(" ,to create a listing file or verbose use options : '-l' or '-v' respectively");
            }
            fr.flush();
            fr.close();
            binary.init();
            binary.printBinary();
            binary.writeBinary();
            binary.printText();

            return new TranslationUnit(seq);

    }

        private Instruction parseInherent (Instruction inst, String line) throws IOException {
            inst.parseMnemonic(line);
            return inst;
        }
  
        private Instruction parseImmediate (Instruction inst, String line) throws IOException{
            inst.parseMnemonic(line);
            return inst;
        }
        
        private Instruction parseRelative (Instruction inst, String line) throws IOException{
            inst.parseMnemonic(line);
            return inst;
        }
        // -------------------------------------------------------------------
        // A line statement:
        //   - could be empty (only a EOL);
        //   - could have a single comment start at BOL or after a label, label/inst, or label/dir;
        //   - could have a label only, etc.
        //
        // LineStatement = [Label] [Instruction | Directive ] [Comment] EOL .
        //
        public LineStmt parseLineStmt (String line) throws IOException {
            Label label = null;
            Instruction inst = new Instruction();
            Comment comment = null;

            //System.out.println("Parsing a Line Statement...");

            //parseLabel(); TODO: parse the label in a line statement - create a function to translate label
            //parseComment(); TODO: parse the comment in a line statement - create a function to translate the comment

            /**
             * Inputs: Instruction, String
             * Output: void, saves mnemonic and respective opcode in object variables
             */
            if(token == Tokens.INHERENT){
                inst = parseInherent(inst, line);
            }
            else if(token == Tokens.IMMEDIATE){
                inst = parseImmediate(inst, line);
            }
            else if(token == Tokens.RELATIVE){
                inst = parseRelative(inst, line);
            }

            return new LineStmt(label, inst, comment);
        }

        protected void nextToken () throws IOException {
            token = lexer.getToken();
        }

        public LineStmtSeq getSeq () {
        return seq;
    }


        private Tokens token;
        private int address;
        private ILexer lexer;
        private ISourceFile sourceFile;
        private IReportable errorReporter;
        private ISymbolTable table;
        private Queue keywordTable;
        private ISymbolTable opCodes;
        private IOption options;
        private LineStmtSeq seq;

}


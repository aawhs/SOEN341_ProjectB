//GenerateBinary class which takes care binary executable file generation
package edu.soen341.projectb.binary;

import edu.soen341.projectb.assembler.LineStmtSeq;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateBinary {
    //Parameterized constructor which initializes line statement sequence
    public GenerateBinary(LineStmtSeq seq) throws IOException {
        this.rev = seq;
    }
    //Initialiazing the setups
    public void init() {
        setUpHeader();
        setUpTemplate();
        setUpMachineCode();
        setUpBinary();
    }
    //printing the binary format to the screen
    public void printBinary(){
        System.out.println(binary);
    }
    //Writing the binary file content to the console
    public void writeBinary() throws IOException {
        File file = new File("S1Test1.exe");
        FileWriter fr = new FileWriter(file);
        fr.write(binary);
        fr.flush();
        fr.close();
    }
    //Printing instructions to the screen
    void printMC(){
        for(int i = 0; i < instructions.size(); i++){
            System.out.println(instructions.get(i)[0]);
        }
    }
    //Printing the executable file to the screen
    public void printText() throws IOException {
        setupText();
        System.out.println(text);
    }
    //Method to set up header in the output
    void setUpHeader(){
        this.header = "\nOffset(h)  00  01  02  03  04  05  06  07  08  09  0A  0B  0C  0D  0E  0F  Decoded Text";
    }
    //Setting up the template with the right formatting and content
    void setUpTemplate(){
        this.templateExe = this.header + '\n' + getStringOffset() + "   00  08  ";
    }
    //**Retrieving machince code values and formatting the data**
    void setUpMachineCode(){
        for(int i = 0; i < instructions.size(); i++){
            if(columnCount < 16) {
                this.machineCode += instructions.get(i)[0] + "  ";
                columnCount++;
            }
            else{
                for(int j = currentChar; j < i; j++){
                    int a = Integer.valueOf(instructions.get(i)[0]);
                    a += 0;
                    char b = (char)a;
                    if(Character.isLetter(b))
                        decodedText += b;
                    else
                        decodedText += '.';
                }
                machineCode+= decodedText;
                columnCount = 0;
                this.machineCode += "\n";
                offset+=10;
                machineCode+=getStringOffset() + "   ";
                currentChar+=16;
            }
        }
    }
    // Setting up binary format for output
    void setUpBinary(){
        this.binary = this.templateExe + this.machineCode;
    }
    //Connecting to the executable file and writing to it
    void setupText() throws IOException {
        File file = new File("S1Test2.exe");
        FileWriter fr = new FileWriter(file);
        for(int i = 0; i < instructions.size(); i++){
            Integer a = Integer.valueOf(instructions.get(i)[0]);
            //a += 19;
            fr.write(a);
        }
        fr.flush();
        fr.close();
    }
    //Getter helper method for instructions arraylist
    public ArrayList getInstructions(){
        return this.instructions;
    }
    //Formatting the offsets
    String getStringOffset(){
        return String.format("%08d",this.offset);
    }
    //Printing the executable file to the screen

    //setting up arrayList to store Instructions
    ArrayList<String[]> instructions = new ArrayList<>();
    //setting up line statement sequence
    LineStmtSeq rev;
    //Variables to store different types of text
    String machineCode = "";
    String templateExe;
    String header;
    String decodedText = "";
    //Variables to store different types of numerical values needed in the binary executable file
    int offset = 0;
    int columnCount = 2;
    int currentChar = 0;
    //Variables which stores the string formatting of the BEF
    String binary = "";
    String text = "";


}

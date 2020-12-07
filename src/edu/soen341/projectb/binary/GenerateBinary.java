package edu.soen341.projectb.binary;

import edu.soen341.projectb.assembler.LineStmt;
import edu.soen341.projectb.assembler.LineStmtSeq;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateBinary {

    ArrayList<String[]> instructions = new ArrayList<>();
    LineStmtSeq rev;
    String machineCode = "";
    String templateExe;
    String header;
    String decodedText = "";
    int offset = 0;
    int columnCount = 2;
    int currentChar = 0;

    String binary = "";

    String text = "";

    public GenerateBinary(LineStmtSeq seq) throws IOException {
        this.rev = seq;
    }

    void setUpHeader(){
        this.header = "\nOffset(h)  00  01  02  03  04  05  06  07  08  09  0A  0B  0C  0D  0E  0F  Decoded Text";
    }

    void setUpTemplate(){
        this.templateExe = this.header + '\n' + getStringOffset() + "   00  08  ";
    }

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

    void setUpBinary(){
        this.binary = this.templateExe + this.machineCode;
    }
    public void printBinary(){
        System.out.println(binary);
    }

    public void writeBinary() throws IOException {
        File file = new File("S1Test1.exe");
        FileWriter fr = new FileWriter(file);
        fr.write(binary);
        fr.flush();
        fr.close();
    }

    public ArrayList getInstructions(){
        return this.instructions;
    }

    void printMC(){
        for(int i = 0; i < instructions.size(); i++){
            System.out.println(instructions.get(i)[0]);
        }
    }

    String getStringOffset(){
        return String.format("%08d",this.offset);
    }

    public void init(){
        setUpHeader();
        setUpTemplate();
        setUpMachineCode();
        setUpBinary();
    }

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

    public void printText() throws IOException {
        setupText();
        System.out.println(text);
    }

    public void addToRev(LineStmt l){
        rev.add(l);
    }
}

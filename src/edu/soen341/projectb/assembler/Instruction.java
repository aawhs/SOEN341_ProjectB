package edu.soen341.projectb.assembler;
import edu.soen341.projectb.assembler.Operand;
    //The Instruction Class is designed to hold Instruction objects and then separate and parse them as needed
public class Instruction implements Opcode {
    //Paramaterized Contructor for the Instruction Object
    public Instruction(String inst){
        setInstruction(inst);
    }
    //Paramaterized Contructor for the Instruction Object
    public Instruction(Opcode opcode, Operand operand){
        this.operand = operand;
    }
    //Basic Contructor for the Instruction Object
    public Instruction(){
        this.operand = new Operand();
    }
    //Custom Method used by the parser in relation to the Instruction Class
    public void parseMnemonic(String inst){
        String mnemonic_temp = "";
        for (int i = 0; i < inst.length(); i++){
            if(inst.charAt(i) == ' ' || inst.charAt(i) == '.'){break;}
            mnemonic_temp += inst.charAt(i);
        }
        setInstruction(mnemonic_temp);
    }
    /*public String[] printInstruction(){
        String[] inst = new String[2];
        inst[0]= String.format("%02d",opCode);
        inst[1]=mnemonic;
        return inst;
    }
    */    
     //Custom Method used by the Instruction Class to verify the instructions value in relation to Opcodes and Mnemonics
    public void setInstruction(String inst){
        for(int i = 0; i< Opcode.inherentMnemonics.length; i++){
            if(Opcode.inherentMnemonics[i].contains(inst)){
                this.mnemonic = Opcode.inherentMnemonics[i];
                this.opCode = Opcode.inherentOpcodes[i];
            }
        }
        for(int i = 0; i< Opcode.immediateMnemonics.length; i++) {
            if (Opcode.immediateMnemonics[i].contains(inst)) {
                this.mnemonic = Opcode.immediateMnemonics[i];
                this.opCode = Opcode.immediateOpcodes[i];
            }
        }
        for(int i = 0; i< Opcode.relativeMnemomnics.length; i++) {
            if (Opcode.relativeMnemomnics[i].contains(inst)) {
                this.mnemonic = Opcode.relativeMnemomnics[i];
                this.opCode = Opcode.relativeOpcodes[i];
                break;
            }
        }
    }
    //Basic Setter method in relation to Instruction Object
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    //Basic Setter method in relation to Instruction Object
    public void setOperand(Operand operand) {
        this.operand = operand;
    }
     //Basic Setter method in relation to Instruction Object
     public void setOpCode(int opCode) {
        this.opCode = opCode;
    }
    //Basic Getter method in relation to Instruction Object
    public int getOpCode() {
        return opCode;
    }
    //Basic Getter method in relation to Instruction Object
    public String getOperand() {
        if(operand.address != 0){
            return String.valueOf(operand.getAddress());
        }else if(operand.offset != 0){
            return String.valueOf(operand.getOffset());
        }
        return operand.label.getLabel();
    }
    //Basic Getter method in relation to Instruction Object
    public String getMnemonic() {
        return mnemonic;
    }
    //Necessary Data Members for the Instruction Class
    public String mnemonic = "";
    public int opCode;
    public Operand operand = new Operand();
}


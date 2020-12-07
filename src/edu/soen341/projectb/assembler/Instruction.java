package edu.soen341.projectb.assembler;

import edu.soen341.projectb.assembler.Operand;

public class Instruction implements Opcode {
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public String getOperand() {
        if(operand.address != 0){
            return String.valueOf(operand.getAddress());
        }else if(operand.offset != 0){
            return String.valueOf(operand.getOffset());
        }
        return operand.label.getLabel();
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }

    public String mnemonic = "";
    public int opCode;
    public Operand operand = new Operand();

    public Instruction(String inst){setInstruction(inst);}

    public Instruction(Opcode opcode, Operand operand){
        this.operand = operand;
    }

    public Instruction(){}

    public void setInstruction(String inst){
        for(int i = 0; i< Opcode.inherentMnemonics.length; i++){
            if(Opcode.inherentMnemonics[i].contains(inst) && mnemonic == ""){
                this.mnemonic = Opcode.inherentMnemonics[i];
                this.opCode = Opcode.inherentOpcodes[i];
                break;
            }
        }
        for(int i = 0; i< Opcode.immediateMnemonics.length; i++) {
            if (Opcode.immediateMnemonics[i].contains(inst) && mnemonic == "") {
                this.mnemonic = Opcode.immediateMnemonics[i];
                this.opCode = Opcode.immediateOpcodes[i];
                break;
            }
        }
        for(int i = 0; i< Opcode.relativeMnemomnics.length; i++) {
            if (Opcode.relativeMnemomnics[i].contains(inst) && mnemonic == "") {
                this.mnemonic = Opcode.relativeMnemomnics[i];
                this.opCode = Opcode.relativeOpcodes[i];
                break;
            }
        }
    }

    public void parseMnemonic(String inst){
        setInstruction(inst);
    }

    public String[] printInstruction(){
        String[] inst = new String[2];
        inst[0]= String.format("%02d",opCode);
        inst[1]=mnemonic;
        return inst;
    }

    /**
     * Used in AUnit testing
     * @return mnemonic
     */
    public String getMnemonic() {return mnemonic;}
}

